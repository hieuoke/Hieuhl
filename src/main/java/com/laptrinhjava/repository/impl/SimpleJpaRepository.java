package com.laptrinhjava.repository.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.laptrinhjava.annotation.Entity;
import com.laptrinhjava.annotation.Table;
import com.laptrinhjava.mapper.ResultSetmapper;
import com.laptrinhjava.repository.JpaRepository;

public class SimpleJpaRepository<T> implements JpaRepository<T> {
	
	@SuppressWarnings("unused")
	private Class<T> zClass;
	
	@SuppressWarnings("unchecked")
	public SimpleJpaRepository() {
		Type type  = getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		zClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}
	
	@Override
	public List<T> findAll() {
		String tableName = "";
		if(zClass.isAnnotationPresent(Entity.class) &&  zClass.isAnnotationPresent(Table.class)){
			Table table1 = zClass.getAnnotation(Table.class);
			tableName = table1.name(); 
		}
		String sql  = "SELECT * FROM studentjdbc."+tableName+" ";
		ResultSetmapper<T> resultSetmapper = new ResultSetmapper<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {	
			connection = EntityManagerFactory.getConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			return resultSetmapper.mapRow(resultSet, this.zClass);

	} catch (SQLException e1) {
		return null;
	} finally {
		try {
			if (connection != null) {
				connection.close();
			}
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e1) {
			return null;
			}
		}
		
	}

	@Override
	public List<T> seachStudent(String name) {

		String tableName = "";
		if(zClass.isAnnotationPresent(Entity.class) &&  zClass.isAnnotationPresent(Table.class)){
			Table table1 = zClass.getAnnotation(Table.class);
			tableName = table1.name(); 
		}
		String sql  = "SELECT * FROM studentjdbc."+tableName+" where name LIKE '%"+name+"%' ";
		ResultSetmapper<T> resultSetmapper = new ResultSetmapper<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {	
			connection = EntityManagerFactory.getConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			return resultSetmapper.mapRow(resultSet, this.zClass);

	} catch (SQLException e1) {
		return null;
	} finally {
		try {
			if (connection != null) {
				connection.close();
			}
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e1) {
			return null;
			}
		}
		
	}

	@SuppressWarnings("unused")
	@Override
	public Long delete(long id) {
		String tableName = "";
		if(zClass.isAnnotationPresent(Entity.class) &&  zClass.isAnnotationPresent(Table.class)){
			Table table1 = zClass.getAnnotation(Table.class);
			tableName = table1.name(); 
		}
		String sql  = "DELETE FROM studentjdbc."+tableName+" WHERE id = "+id+" ";
		ResultSetmapper<T> resultSetmapper = new ResultSetmapper<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {	
			connection = EntityManagerFactory.getConnection();
			connection.setAutoCommit(false);
			try {
				statement = connection.prepareStatement(sql.toString());
				int row = statement.executeUpdate(sql);
				if(row > 0) {
					connection.commit();
					return (long)row;
				}
				connection.commit();
			} catch (Exception e) {
				connection.rollback();
				 System.out.println(e.getMessage());
			}		
	} catch (SQLException e1) {
		System.out.println(e1.getMessage());
	} finally {
		try {
			if (connection != null) {
				connection.close();
			}
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e1) {
			return null;
			}
		}
		return id;

	}

	@SuppressWarnings("unused")
	@Override
	public Long update(long id,String name, int age, String address) {
		String tableName = "";
		if(zClass.isAnnotationPresent(Entity.class) &&  zClass.isAnnotationPresent(Table.class)){
			Table table1 = zClass.getAnnotation(Table.class);
			tableName = table1.name(); 
		}
		String sql  = "UPDATE studentjdbc."+tableName+" set name = '"+name+"', age = "+age+", address = '"+address+"' WHERE id = "+id+" ";
		ResultSetmapper<T> resultSetmapper = new ResultSetmapper<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {	
			connection = EntityManagerFactory.getConnection();
			connection.setAutoCommit(false);
			try {
				statement = connection.prepareStatement(sql.toString());
				int row = statement.executeUpdate(sql);
				if(row > 0) {
					connection.commit();
					return (long)row;
				}
				connection.commit();
			} catch (Exception e) {
				connection.rollback();
				 System.out.println(e.getMessage());
			}		
	} catch (SQLException e1) {
		System.out.println(e1.getMessage());
	} finally {
		try {
			if (connection != null) {
				connection.close();
			}
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e1) {
			return null;
			}
		}
		return id;

	}

	@SuppressWarnings("unused")
	@Override
	public Long addStudent(String name, int age, String address) {
			String tableName = "";
			if(zClass.isAnnotationPresent(Entity.class) &&  zClass.isAnnotationPresent(Table.class)){
				Table table1 = zClass.getAnnotation(Table.class);
				tableName = table1.name(); 
			}
			String sql  = "INSERT INTO studentjdbc."+tableName+"(name,age,address) VALUES(?,?,?)";
			ResultSetmapper<T> resultSetmapper = new ResultSetmapper<>();
			Connection connection = null;
			PreparedStatement statement = null;
			ResultSet resultSet = null;
			try {	
				connection = EntityManagerFactory.getConnection();
				connection.setAutoCommit(false);
				try {
					statement = connection.prepareStatement(sql);
					statement.setString(1, name);
					statement.setInt(2, age);
					statement.setString(3, address);
					int row = statement.executeUpdate();
					if(row > 0) {
						connection.commit();
						return (long)row;
					}
					connection.commit();
				} catch (Exception e) {
	//				connection.rollback();
					 System.out.println(e.getMessage());
				}		
		} catch (SQLException e1) {
			System.out.println(e1.getMessage());
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e1) {
				return null;
				}
			}
		return null;
	}

	
}

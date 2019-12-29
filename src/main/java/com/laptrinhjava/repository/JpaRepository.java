package com.laptrinhjava.repository;

import java.util.List;

public interface JpaRepository<T> {
	Long addStudent(String name, int age, String address);
	List<T> seachStudent(String name);
	List<T> findAll();
	Long delete(long id);
	Long update(long id,String name, int age, String address);

}

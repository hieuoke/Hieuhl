package com.laptrinhjava.entity;

import com.laptrinhjava.annotation.Column;
import com.laptrinhjava.annotation.Entity;
import com.laptrinhjava.annotation.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "student")
public class StudentEntity extends PaseEntity {
	//java annotation
	
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "address")
    private String address;
	
	

	
}

   
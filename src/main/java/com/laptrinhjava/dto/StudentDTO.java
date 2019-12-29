package com.laptrinhjava.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@SuppressWarnings("serial")
public class StudentDTO implements Serializable {

		private long id;
	    private String name;
	    private int age;
	    private String address;
	    private Date createdDate;
		private Date modifiedDate;
		private String createdBy;
		private String modifiedBy;
		
	    public StudentDTO() {
	    }

	   

	}


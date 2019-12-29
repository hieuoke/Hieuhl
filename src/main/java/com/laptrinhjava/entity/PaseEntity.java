package com.laptrinhjava.entity;

import java.util.Date;

import com.laptrinhjava.annotation.Column;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaseEntity {

	@Column(name = "createddate")
	private Date createdDate ;
	
	@Column(name = "modifieddate")
	private Date modifiedDate ;
	
	@Column(name = "createdby")
	private String createdBy ;
	
	@Column(name = "modifiedby")
	private String modifiedBy;

	
}

package com.laptrinhjava.service;

import java.util.List;

import com.laptrinhjava.dto.StudentDTO;

public interface IStudentService {
	Long addStudent(String name, int age, String address);
	List<StudentDTO> seach(String name);
	List<StudentDTO> findAll();
	Long delete(long id);
	Long update(long id,String name, int age, String address);
}

package com.laptrinhjava.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.laptrinhjava.converter.StudentConverter;
import com.laptrinhjava.dto.StudentDTO;
import com.laptrinhjava.entity.StudentEntity;
import com.laptrinhjava.repository.IStudentRepository;
import com.laptrinhjava.repository.impl.StudentRepository;
import com.laptrinhjava.service.IStudentService;

public class StudentService implements IStudentService{

	private IStudentRepository studentRepository;
	private StudentConverter studentConverter;
	
	public StudentService() {
		studentRepository = new StudentRepository();
		studentConverter = new StudentConverter();
	}
	
	@Override
	public List<StudentDTO> findAll() {
		List<StudentEntity> studentEntities = studentRepository.findAll();
		return studentEntities.stream().map(item ->
		studentConverter.convertToDTO(item)).collect(Collectors.toList());
	}

	@Override
	public List<StudentDTO> seach(String name) {
		
		
		List<StudentEntity> studentEntities = studentRepository.seachStudent(name);
		return studentEntities.stream().map(item ->
		studentConverter.convertToDTO(item)).collect(Collectors.toList());
	}

	@Override
	public Long update(long id, String name, int age, String address) {
		return studentRepository.update(id, name, age, address);	
	}

	@Override
	public Long delete(long id) {
		return studentRepository.delete(id);	
	}

	@Override
	public Long addStudent(String name, int age, String address) {
		return studentRepository.addStudent(name, age, address);
	}



}

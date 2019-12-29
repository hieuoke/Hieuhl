package com.laptrinhjava.converter;

import org.modelmapper.ModelMapper;

import com.laptrinhjava.dto.StudentDTO;
import com.laptrinhjava.entity.StudentEntity;

public class StudentConverter {
	public StudentDTO convertToDTO(StudentEntity entity) {
		ModelMapper modelMapper = new ModelMapper();
		
		return modelMapper.map(entity, StudentDTO.class);
	}
}

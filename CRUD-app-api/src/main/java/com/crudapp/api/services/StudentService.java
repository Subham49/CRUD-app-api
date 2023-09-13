package com.crudapp.api.services;

import java.util.List;

import com.crudapp.api.payload.StudentDto;

public interface StudentService {
	StudentDto createStudent(StudentDto studentDto);
	StudentDto updateStudent(StudentDto studentDto, int rollNo);
	StudentDto getStudent(int rollNo);
	List<StudentDto> getAllStudent();
	void deleteStudent(int rollNo);
	StudentDto getStudentByEmail(String email);
}

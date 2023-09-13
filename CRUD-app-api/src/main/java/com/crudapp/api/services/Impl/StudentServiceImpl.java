package com.crudapp.api.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudapp.api.entities.Student;
import com.crudapp.api.exception.ResourceNotFoundException;
import com.crudapp.api.payload.StudentDto;
import com.crudapp.api.repository.StudentRepo;
import com.crudapp.api.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public StudentDto createStudent(StudentDto studentDto) {
		// TODO Auto-generated method stub
//		System.out.println(studentDto);
		Student student = this.studentRepo.save(this.modelMapper.map(studentDto, Student.class));
//		System.out.println(student);
		return this.modelMapper.map(student, StudentDto.class);
	}

	@Override
	public StudentDto updateStudent(StudentDto studentDto, int rollNo) {
		// TODO Auto-generated method stub
		Student student = this.studentRepo.findById(rollNo).orElseThrow(()->new ResourceNotFoundException("Student ", "roll no", rollNo+""));
		student.setAbout(studentDto.getAbout());
		student.setAddress(studentDto.getAddress());
		student.setEmail(studentDto.getEmail());
		student.setImage(studentDto.getImage());
		student.setName(studentDto.getName());
		student.setPhoneNo(studentDto.getPhoneNo());
		Student save = this.studentRepo.save(student);
		return this.modelMapper.map(save, StudentDto.class);
	}

	@Override
	public StudentDto getStudent(int rollNo) {
		// TODO Auto-generated method stub
		Student student = this.studentRepo.findById(rollNo).orElseThrow(()->new ResourceNotFoundException("Student ", "roll no", rollNo+""));
		return this.modelMapper.map(student, StudentDto.class);
	}

	@Override
	public List<StudentDto> getAllStudent() {
		// TODO Auto-generated method stub
		List<Student> students = this.studentRepo.findAll();
		List<StudentDto> list = students.stream().map(student -> this.modelMapper.map(student, StudentDto.class)).collect(Collectors.toList());
		return list;
	}

	@Override
	public void deleteStudent(int rollNo) {
		// TODO Auto-generated method stub
//		StudentDto studentDto = this.getStudent(rollNo);
		this.studentRepo.deleteById(rollNo);
	}
	@Override
	public StudentDto getStudentByEmail(String email) {
		// TODO Auto-generated method stub
		 Student student = this.studentRepo.findByEmail(email);
		 if(student == null)
			 throw new ResourceNotFoundException("Student ", "email id", email);
		 return this.modelMapper.map(student, StudentDto.class);
	}
}

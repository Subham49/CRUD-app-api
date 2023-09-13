package com.crudapp.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudapp.api.payload.ApiResponse;
import com.crudapp.api.payload.StudentDto;
import com.crudapp.api.services.StudentService;

@RestController
@RequestMapping("/students/")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/")
	public ResponseEntity<StudentDto> createStudent(@Valid @RequestBody StudentDto studentDto)
	{
		System.out.println(studentDto);
		StudentDto createStudent = this.studentService.createStudent(studentDto);
		return new ResponseEntity<StudentDto>(createStudent, HttpStatus.CREATED);
	}
	
	@PutMapping("/{rollNo}")
	public ResponseEntity<StudentDto> updateStudent(@Valid @RequestBody StudentDto studentDto, @PathVariable int rollNo)
	{
//		System.out.println(studentDto+"==========="+rollNo);
		StudentDto updateStudent = this.studentService.updateStudent(studentDto, rollNo);
		return new ResponseEntity<StudentDto>(updateStudent, HttpStatus.OK);
	}
	
	@DeleteMapping("/{rollNo}")
	public ResponseEntity<ApiResponse> deleteStudent(@PathVariable int rollNo)
	{
		this.studentService.deleteStudent(rollNo);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Student wiht roll no "+rollNo+" deleted successfully", true), HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<StudentDto>> getAllStudent()
	{
		List<StudentDto> list = this.studentService.getAllStudent();
		return new ResponseEntity<List<StudentDto>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{rollNo}")
	public ResponseEntity<StudentDto> getStudent(@PathVariable int rollNo)
	{
		StudentDto student = this.studentService.getStudent(rollNo);
		return new ResponseEntity<StudentDto>(student, HttpStatus.OK);
	}
	
	@GetMapping("/search/{email}")
	public ResponseEntity<StudentDto> getStudentByEmail(@PathVariable String email)
	{
		StudentDto student = this.studentService.getStudentByEmail(email);
		return new ResponseEntity<StudentDto>(student, HttpStatus.OK);
	}
}

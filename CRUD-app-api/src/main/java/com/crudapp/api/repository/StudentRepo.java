package com.crudapp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudapp.api.entities.Student;
import com.crudapp.api.payload.StudentDto;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	Student findByEmail(String email);
}

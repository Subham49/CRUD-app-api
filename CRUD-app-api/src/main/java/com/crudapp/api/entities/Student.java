package com.crudapp.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.crudapp.api.payload.StudentDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rollNo;
	
	private String name;
	
	private String email;
	
	private String phoneNo;
	
	private String image;
	
	@Column(length = 100000)
	private String address;
	
	@Column(length = 100000)
	private String about;

	
	
}

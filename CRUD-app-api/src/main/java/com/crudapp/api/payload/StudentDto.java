package com.crudapp.api.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
	private int rollNo;
	
	@NotNull(message = "name can't be empty")
	@Size(min = 3, max = 20, message = "name must be between 3 and 20")
	private String name;
	
	@Email(message = "enter a valid email id")
	@NotNull(message = "email can't be empty")
	private String email;
	
	@NotNull(message = "phone no. can't be empty")
	@Size(min = 10, max = 10, message = "phone no must be 10 digit")
	private String phoneNo;
	
	
	private String image;
	
	@Size(min = 1, message = "address must not be empty")
	private String address;
	
	@Size(min = 1, message = "about must not be empty")
	private String about;

	
	
	
}

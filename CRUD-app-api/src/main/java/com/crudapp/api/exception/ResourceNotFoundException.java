package com.crudapp.api.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
	private String sourceName;
	private String fieldName;
	private String fieldValue;
	public ResourceNotFoundException(String sourceName, String fieldName, String fieldValue) {

		super(String.format("%s not found with %s : %s", sourceName, fieldName, fieldValue));
		this.sourceName = sourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
}

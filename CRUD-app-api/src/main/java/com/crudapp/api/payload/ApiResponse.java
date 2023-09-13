package com.crudapp.api.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ApiResponse {
	private String message;
	private boolean flag;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public ApiResponse(String message, boolean flag) {
		super();
		this.message = message;
		this.flag = flag;
	}
	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

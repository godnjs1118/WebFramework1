package com.lab.hwkim.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Course {
	private int year;
	
	private int semester;
	
	@Size(min=2, max=20, message="Title must be between 2 and 20 chars")
	@NotEmpty(message="Code cannot be empty")
	private String code;
	
	@Size(min=2, max=20, message="Title must be between 2 and 20 chars")
	@NotEmpty(message="Title cannot be empty")
	private String title;
	
	@NotEmpty(message="Division cannot be empty")
	private String division;
	
	private int credit;
}

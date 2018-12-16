package com.lab.hwkim.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CreditPerSemester {
	private int year;
	private int semester;
	private int credit;
}

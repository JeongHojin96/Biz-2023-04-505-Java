package com.callor.scanner.models;

import com.callor.scanner.service.StudentServiceV22;

public class StudentD {
	public static void main(String[] args) {

		StudentServiceV22 stService = new StudentServiceV22();
		stService.inputStudents();
		stService.printStudents();
		
	}
}

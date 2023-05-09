package com.callor.classes.exec;

import com.callor.classes.models.StudentDto;
import com.callor.classes.service.StudentService;
import com.callor.classes.service.impl.StudentServiceImplV1;

public class StudentD {

	public static void main(String[] args) {
		StudentService stSer = new StudentServiceImplV1();
		stSer.loadStudent();
		stSer.printStudent();
		
		StudentDto stDto = stSer.getStudent("S0003");
		System.out.println(stSer.toString());
	}
}

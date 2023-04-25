package com.callor.classes.exec;

import com.callor.classes.model.StudentDto;

public class ExecD {

	public static void main(String[] args) {
		
		StudentDto 가학생 = new StudentDto();
		StudentDto 나학생 = new StudentDto();
		StudentDto 다학생 = new StudentDto();
		StudentDto 라학생 = new StudentDto();
		StudentDto 마학생 = new StudentDto();
		
		가학생.stName = "가학생";
		가학생.intKor = 90;
		
		나학생.stName = "나학생";
		나학생.intKor = 92;
		
		다학생.stName = "다학생";
		다학생.intKor = 81;
		
		라학생.stName = "라학생";
		라학생.intKor = 84;
		
		마학생.stName = "마학생";
		마학생.intKor = 93;
		
		int intTotal = 가학생.intKor+나학생.intKor+다학생.intKor+라학생.intKor+마학생.intKor;
		System.out.println(intTotal);
		
	}
}

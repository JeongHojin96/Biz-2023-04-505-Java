package com.callor.scanner.service;

import java.util.Scanner;

import com.callor.scanner.models.StudentDto;

public class StudentServiceV1 {
	
	public void inputStudent() {
		StudentDto student = new StudentDto();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("학생정보 입력");
		
		System.out.print("학번 >> ");
		String stNum = scan.nextLine();
		
		System.out.print("이름 >> ");
		String stName = scan.nextLine();

		System.out.print("학과 >> ");
		String stDept = scan.nextLine();

		int intGrade = 0;
		while (true) {
			System.out.print("학년 >> ");
		String stGrade = scan.nextLine();
		try {
			intGrade = Integer.valueOf(stGrade);
		} catch (Exception e) {
			System.err.println("정수로 입력.");
			continue;
		}
		if(intGrade < 1 || intGrade > 4) {
			System.err.println("1 ~ 4 범위");
			continue;
		}
		break;
	}
		
		System.out.print("전화번호 >> ");
		String stTel = scan.nextLine();
		
		student.setStNum(stNum);
		student.setStName(stName);
		student.setStDept(stDept);
		student.setStGrade(intGrade);
		student.setStTel(stTel);

		System.out.println(student.toString());
		
	}

}
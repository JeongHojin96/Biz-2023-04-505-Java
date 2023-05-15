package com.callor.student.exec;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.student.models.StudentDto;

public class StudentExecA {

	public static void main(String[] args) {
		List<StudentDto> stdList = new ArrayList<>();
		StudentDto stDto = new StudentDto();
		Scanner scan = new Scanner(System.in);

		System.out.println("학생정보 입력");

		System.out.print("학번 >> ");
		String stNum = scan.nextLine();

		System.out.print("이름 >> ");
		String stName = scan.nextLine();

		System.out.print("학과 >> ");
		String stDept = scan.nextLine();

		System.out.println("학년 >> ");
		String stGrade = scan.nextLine();

		System.out.print("전화번호 >> ");
		String stTel = scan.nextLine();

		stDto.setStNum(stNum);
		stDto.setStName(stName);
		stDto.setStDept(stDept);
		stDto.setStGrade(Integer.valueOf(stGrade));
		stDto.setStTel(stTel);

		// field 생성자를 사용하여 (데이터가 포함된) 객체 생성
		stDto = new StudentDto(stNum, stName, stDept, Integer.valueOf(stGrade), stTel);
	
		System.out.println(stDto);
		
		stdList.add(stDto);
		
		System.out.println(stdList.toString());
		
		
	}
	

}

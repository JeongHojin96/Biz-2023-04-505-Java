package com.callor.classes.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.callor.classes.models.StdData;
import com.callor.classes.models.StudentDto;
import com.callor.classes.service.StudentService;

public class StudentServiceImplV1 implements StudentService {

	// 클래스 영역에 필드 변수로 StudentDto List type 으로
	// stdList 객체 선언
	List<StudentDto> stdList;
	public StudentServiceImplV1 () {
		// 기본 생성자에서 객체를 초기화(사용할수 있도록 생성)
		stdList = new ArrayList<>();
	}
	
	@Override
	public void loadStudent() {
		// STUDENT 문자열 배열 데이터를 foreEach(확장 for) 를
		// 분해하여 개별 문자열을 str 담고 for() {} 에 전달하기
		for (String str : StdData.STUDENT) {
			
			// str 문자열 변수에 저장된 문자열을 ","를 기준으로 다시 분해
			// student 배열에 저장하기
			String[] student =str.split(",");
			
			// StudentDto class type 의 stDto 객체를 생성하고
			// StudentDto type 의 객체를 생성하고
			StudentDto stDto = new StudentDto();
			// student 배열의 각 요소를 StudentDto type 객체 요소(변수)에
			// 저장하기
			stDto.stNum = student[StdData.ST_NUM];
			stDto.stName = student[StdData.ST_NAME];
			stDto.stDept = student[StdData.ST_DEPT];
			stDto.stGrade = Integer.valueOf(StdData.ST_GRADE);
			stDto.stTel = student[StdData.ST_TEL];
			stDto.stAddress = student[StdData.ST_ADDRESS];
			
			// List<StudentDto> type 의 리스트에 추가하기
			stdList.add(stDto);
		}
	}

	@Override
	public void printStudent() {
		System.out.println("=".repeat(105));
		System.out.println("학번" + "\t" + "이름" + "\t" + "학과" + "\t\t" + "학년" + "\t" + "전화번호" + "\t" + "주소");
		System.out.println("-".repeat(105));
		for (StudentDto dto : stdList) {
			System.out.printf("%s\t",dto.stNum);
			System.out.printf("%s\t",dto.stName);
			System.out.printf("%s\t",dto.stDept);
			System.out.printf("%s\t",dto.stGrade);
			System.out.printf("%s\t",dto.stTel);
			System.out.printf("%s\n",dto.stAddress);
			
//			System.out.print(stdList.get(i).stNum + "\t");
//			System.out.print(stdList.get(i).stName + "\t");
//			System.out.print(stdList.get(i).stDept + "\t");
//			System.out.print(stdList.get(i).stGrade + "\t");
//			System.out.print(stdList.get(i).stTel + "\t");
//			System.out.print(stdList.get(i).stAddress + "\n");
		}
		System.out.println("=".repeat(105));
	}

	/*
	 * stdList 에서 stNum 학번의 학생데이터를 찾아서
	 * 학생데이터를 return 
	 */
	@Override
	public StudentDto getStudent(String stNum) {
		for(StudentDto dto : stdList) {
			if(dto.stNum.equals(stNum)) {
				return dto;
			}
		}
		return null;
	}

}

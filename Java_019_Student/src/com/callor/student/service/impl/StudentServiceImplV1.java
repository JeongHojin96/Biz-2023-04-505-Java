package com.callor.student.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.student.models.StudentDto;
import com.callor.student.service.StudentService;
import com.callor.student.utils.Line;

public class StudentServiceImplV1 implements StudentService {

	protected List<StudentDto> stdList;
	protected Scanner scan;

	public StudentServiceImplV1() {
		stdList = new ArrayList<>();
		scan = new Scanner(System.in);
	}

	public void insertStudent() {

		System.out.println(Line.dLINE(60));
		System.out.println("학생정보 추가 종료하려면 QUIT 입력");
		System.out.println(Line.sLINE(60));
		while (true) {

			System.out.print("학번 >> ");
			String stNum = scan.nextLine();
			if (stNum.equals("QUIT"))
				break;

			System.out.print("이름 >> ");
			String stName = scan.nextLine();
			if (stName.equals("QUIT"))
				break;

			System.out.print("학과 >> ");
			String stDept = scan.nextLine();
			if (stDept.equals("QUIT"))
				break;

			int intGrade = 0;
			while (true) {
				System.out.print("학년 >> ");
				String stGrade = scan.nextLine();
				if (stGrade.equals("QUIT"))
					break;

				try {
					intGrade = Integer.valueOf(stGrade);
				} catch (Exception e) {
					System.err.println("정수로 입력.");
					continue;
				}
				if (intGrade < 1 || intGrade > 4) {
					System.err.println("1 ~ 4 범위");
					continue;
				}
				break;
			}
			if (intGrade == 0)
				break;

			System.out.print("전화번호 >> ");
			String stTel = scan.nextLine();
			if (stTel.equals("QUIT"))
				break;

			StudentDto stDto = new StudentDto();

			stDto.stNum = stNum;
			stDto.stName = stName;
			stDto.stDept = stDept;
			stDto.stGrade = intGrade;
			stDto.stTel = stTel;

			stdList.add(stDto);

		}
		System.out.println("학생정보 입력 종료");
		this.printStudent();
	}

	/*
	 * insertStudent() 는 StudentService interface 에 정의되지 않은 method
	 * 
	 * 이 method는 상속받은 것이 아니고 V1 클래스에서 임의로 생성한 method 이다.
	 */

	@Override
	public void loadStudent() {
		System.out.println(Line.dLINE(100));
		System.out.println("대한 고교 학생 리스트");
		System.out.println(Line.dLINE(100));
		System.out.println("학번이름학과학년전화번호");
		System.out.println(Line.sLINE(100));
		if (stdList == null || stdList.size() < 1) {
			System.out.println("표시할 데이터가 없음");
			return;
		}
		for (StudentDto dto : stdList) {
			System.out.printf("%s\t", dto.stNum);
			System.out.printf("%s\t", dto.stName);
			System.out.printf("%s\t", dto.stDept);
			System.out.printf("%s\t", dto.stGrade);
			System.out.printf("%s\n", dto.stTel);
		}
		System.out.println(Line.dLINE(100));
	}

	@Override
	public void printStudent() {
		// TODO Auto-generated method stub

	}

	@Override
	public StudentDto getStudent(String stNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentDto> getStudentList() {
		// TODO Auto-generated method stub
		return null;
	}

}

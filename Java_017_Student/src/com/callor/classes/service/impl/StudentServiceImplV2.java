package com.callor.classes.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.classes.config.Line;
import com.callor.classes.datas.DataIndex;
import com.callor.classes.models.StudentDto;
import com.callor.classes.service.StudentService;

public class StudentServiceImplV2 implements StudentService {

	private List<StudentDto> stdList;

	public StudentServiceImplV2() {
		stdList = new ArrayList<>();
	}

	public void loadStudent() {
		String studentFile = "src/com/callor/classes/datas/student.csv";

		Scanner fileScan = null;
		InputStream is = null;

		try {
			is = new FileInputStream(studentFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		fileScan = new Scanner(is);

		while (fileScan.hasNext()) {
			String[] student = fileScan.nextLine().split(",");

			StudentDto stDto = new StudentDto();

			stDto.stNum = student[DataIndex.STUDENT.ST_NUM];
			stDto.stName = student[DataIndex.STUDENT.ST_NAME];
			stDto.stDept = student[DataIndex.STUDENT.ST_DEPT];
			stDto.stGrade = Integer.valueOf(student[DataIndex.STUDENT.ST_GRADE]);
			stDto.stTel = student[DataIndex.STUDENT.ST_TEL];
			stDto.stAddress = student[DataIndex.STUDENT.ST_ADDRESS];

			stdList.add(stDto);
		}
		fileScan.close();
	}

	public void printStudent() {
		System.out.println(Line.dLINE(100));
		System.out.println("학번       이름           학과\t\t학년\t전화번호\t주소");
		System.out.println(Line.sLINE(100));
		int i = 0;
		for (StudentDto dto : stdList) {
			System.out.printf("%4s\t", dto.stNum);
			System.out.printf("%5s\t", dto.stName);
			System.out.printf("%7s\t", dto.stDept);
			System.out.printf("%d\t", dto.stGrade);
			System.out.printf("%s\t", dto.stTel);
			System.out.printf("%s\n", dto.stAddress);
			
			i++;
			if (i % 5 == 0) {
				System.out.println(Line.sLINE(100));
			}
		}
		System.out.println(Line.dLINE(100));
	}

	@Override
	public StudentDto getStudent(String stNum) {
		for (StudentDto dto : stdList) {
			if (dto.stNum.equals(stNum)) {
				return dto;
			}
		}
		return null;
	}

}

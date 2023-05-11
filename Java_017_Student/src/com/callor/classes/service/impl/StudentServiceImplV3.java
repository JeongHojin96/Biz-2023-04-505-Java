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

/*
 * StudentServiceImplV1 은 StudentService interface 를 implements 하였고
 * StudentServiceImplV3 는 StudentServiceImplV1 을 extends 하였다.
 */

public class StudentServiceImplV3 implements StudentService {

	protected List<StudentDto> stdList;

	public StudentServiceImplV3() {
		stdList = new ArrayList<>();
	}

	@Override
	public void loadStudent() {
		String studentFile = "src/com/callor/classes/datas/student.csv";
		InputStream is = null;
		Scanner scan = null;

		try {
			is = new FileInputStream(studentFile);
		} catch (FileNotFoundException e) {
			System.out.println(studentFile + " 이 없습니다 확인하세요");
			return;
		}
		scan = new Scanner(is);
		while (scan.hasNext()) {
			// 한줄씩 파일에서 읽어 line 에 저장
			String line = scan.nextLine();
			String[] student = line.split(",");

			StudentDto stDto = new StudentDto();
			stDto.stNum = student[DataIndex.STUDENT.ST_NUM];
			stDto.stName = student[DataIndex.STUDENT.ST_NAME];
			stDto.stDept = student[DataIndex.STUDENT.ST_DEPT];
			stDto.stGrade = Integer.valueOf(student[DataIndex.STUDENT.ST_GRADE]);
			stDto.stTel = student[DataIndex.STUDENT.ST_TEL];
			stDto.stAddress = student[DataIndex.STUDENT.ST_ADDRESS];

			stdList.add(stDto);
		} // end while
		scan.close();
	}

	@Override
	public void printStudent() {
		System.out.println(Line.dLINE(100));
		System.out.println("학번\t이름\t학과\t학년\t전화번호\t주소");
		System.out.println(Line.sLINE(100));
		int rows = 0;
		for (StudentDto dto : stdList) {
			System.out.printf("%s\t", dto.stNum);
			System.out.printf("%s\t", dto.stName);
			System.out.printf("%s\t", dto.stDept);
			System.out.printf("%d\t", dto.stGrade);
			System.out.printf("%s\t", dto.stTel);
			System.out.printf("%s\n", dto.stAddress);
			// 5줄 마다 구분선을 출력
			// 다만 구분선 출력 위치가 리스트의 끝보다 작을때만
			if (++rows % 5 == 0 && rows < stdList.size()) {
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

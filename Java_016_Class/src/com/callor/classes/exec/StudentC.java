package com.callor.classes.exec;

import java.util.ArrayList;
import java.util.List;

import com.callor.classes.models.StdData;
import com.callor.classes.models.StudentDto;

public class StudentC {

	public static void main(String[] args) {

		List<StudentDto> stdList = new ArrayList<>();

		for (int index = 0; index < StdData.STUDENT.length; index++) {
			String[] student = StdData.STUDENT[index].split(",");

			StudentDto stDto = new StudentDto();

			stDto.stNum = student[StdData.ST_NUM];
			stDto.stName = student[StdData.ST_NAME];
			stDto.stDept = student[StdData.ST_DEPT];
			stDto.stGrade = Integer.valueOf(student[StdData.ST_GRADE]);
			stDto.stTel = student[StdData.ST_TEL];
			stDto.stAddress = student[StdData.ST_ADDRESS];

			stdList.add(stDto);
			
		}
		System.out.println("=".repeat(105));
		System.out.println("학번" + "\t" + "이름" + "\t" + "학과" + "\t" + "\t" + "학년" + "\t" + "전화번호" + "\t" + "주소");
		System.out.println("-".repeat(105));
		for(int i = 0; i<stdList.size() ; i++) {
			System.out.print(stdList.get(i).stNum + "\t");
			System.out.print(stdList.get(i).stName + "\t");
			System.out.print(stdList.get(i).stDept + "\t");
			System.out.print(stdList.get(i).stGrade + "\t");
			System.out.print(stdList.get(i).stTel + "\t");
			System.out.print(stdList.get(i).stAddress + "\n");
			}
		System.out.println("=".repeat(105));
	}
}

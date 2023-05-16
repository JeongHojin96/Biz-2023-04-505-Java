package com.callor.student.exec;

import java.util.Scanner;

import com.callor.student.service.StudentService;
import com.callor.student.service.impl.StudentServiceImplV2;
import com.callor.student.utils.Line;

public class StudentExecG {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		StudentService stService = new StudentServiceImplV2() ;
		System.out.println(Line.dLine(60));
		System.out.println("대한고교 학사관리 2023");
		System.out.println(Line.dLine(60));
		stService.loadStudent();
		while (true) {
			System.out.println("실행할 업무를 선택하세요");
			System.out.println("1. 학생 리스트 확인");
			System.out.println("2. 학생 정보 추가/수정");
			System.out.println("3. 학생정보 삭제");
			System.out.println("4. 업무종료");
			System.out.print("업무선택 >> ");
			String strSelect = scan.nextLine();
			int intSelect = 0;
			try {
				intSelect = Integer.valueOf(strSelect);
			} catch (Exception e) {
				System.out.printf("업무선택을 확인하세요(%s)", strSelect);
				continue;
			}
			
			if(intSelect == 1) {
				stService.printStudent();
			} else if(intSelect == 2) {
				stService.insertStudent();
			} else if(intSelect == 3) {
				stService.deleteStudent();
			} else if(intSelect == 4) {
				break;
				
			} else {
				System.out.printf("업무 선택이 잘못되었습니다(%d) \n",intSelect);
			}
		}
		scan.close();
		
		System.out.println("업무종료");
	}
}

package com.callor.classes.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.callor.classes.config.Line;
import com.callor.classes.datas.DataIndex;
import com.callor.classes.models.ScoreDto;
import com.callor.classes.models.StudentDto;
import com.callor.classes.service.StudentService;

public class ScoreServiceImplV2 extends ScoreServiceImplV1 {

	public ScoreServiceImplV2() {
		// V1 에서 protected 로 선언 scList 를 사용할 수 있도록
		// 초기화 하는 작업, 반드시 필요
		scList = new ArrayList<>();
	}

	public void loadScore() {

		String studentFile = "src/com/callor/classes/datas/student.csv";
		String scoreFile = "src/com/callor/classes/datas/score.csv";
		InputStream is = null;
		Scanner scan = null;

		try {
			is = new FileInputStream(scoreFile);
		} catch (FileNotFoundException e) {
			System.out.println(scoreFile + " 이 없습니다 확인하세요");
			return;
		}
		scan = new Scanner(is);
		while (scan.hasNext()) {
			// 한줄씩 파일에서 읽어 line 에 저장
			String line = scan.nextLine();
			String[] score = line.split(",");

			ScoreDto scDto = new ScoreDto();
			scDto.stNum = score[DataIndex.SCORE.ST_NUM];
			scDto.scKor = Integer.valueOf(score[DataIndex.SCORE.SC_KOR]);
			scDto.scEng = Integer.valueOf(score[DataIndex.SCORE.SC_ENG]);
			scDto.scMath = Integer.valueOf(score[DataIndex.SCORE.SC_MATH]);
			scDto.scMusic = Integer.valueOf(score[DataIndex.SCORE.SC_MUSIC]);
			scDto.scArt = Integer.valueOf(score[DataIndex.SCORE.SC_ART]);

			scList.add(scDto);
		} // end while
		scan.close();
	}

	public void printScore() {
		StudentService stService = new StudentServiceImplV4();
		stService.loadStudent();

		System.out.println(Line.dLINE(120));
		System.out.println("학번\t  이름\t\t학과\t\t국어\t영어\t수학\t음악\t미술\t총점\t평균");
		System.out.println(Line.sLINE(120));

		for (ScoreDto scDto : scList) {
			StudentDto stDto = stService.getStudent(scDto.getStNum());

			System.out.print(scDto.getStNum() + "\t");

			if (stDto != null) {
				System.out.printf("%5s\t%s\t", stDto.stName, stDto.stDept);
			} else {
				System.out.print("---\t---\t");
			}
			System.out.printf("%4d\t%4d\t%4d\t%4d\t%4d\t", scDto.getScKor(), scDto.getScEng(), scDto.getScMath(),
					scDto.getScMusic(), scDto.getScArt());
			
			int scTotal =
					scDto.getScKor() +
					scDto.getScEng() +
					scDto.getScMath() +
					scDto.getScMusic() +
					scDto.getScArt();
			float avgTotal = (float)scTotal / 5;
			
			//총점, 평균 출력
			System.out.printf("%4d\t%.2f\n", scTotal, avgTotal);
		}
		System.out.println(Line.dLINE(120));
	}
}

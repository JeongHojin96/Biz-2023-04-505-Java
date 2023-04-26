package com.callor.classes.arrays;

import com.callor.classes.model.ScoreDto;
import com.callor.classes.service.ScoreServiceA;

public class arrayS {

	public static void main(String[] args) {

		ScoreDto[] scores = new ScoreDto[10];
		for (int index = 0; index < scores.length; index++) {
			scores[index] = new ScoreDto();
		}

		ScoreServiceA scoreService = new ScoreServiceA();

		scores[0].stName = "가길동";
		scores[1].stName = "나길동";
		scores[2].stName = "다길동";
		scores[3].stName = "라길동";
		scores[4].stName = "마길동";
		scores[5].stName = "바길동";
		scores[6].stName = "사길동";
		scores[7].stName = "아길동";
		scores[8].stName = "자길동";
		scores[9].stName = "차길동";

		System.out.println("=".repeat(70));
		System.out.println("학번	이름	국어	영어	수학	총점	평균");

		for (int i = 0; i < scores.length; i++) {
			scores[i].stNum = 1000 + i;
			scores[i].scKor = scoreService.getScore();
			scores[i].scEng = scoreService.getScore();
			scores[i].scMath = scoreService.getScore();
		}
		for (int i = 0; i < scores.length; i++) {
			scoreService.scoreprint(scores[i]);
		}

		System.out.println("=".repeat(70));

		int sumKor = 0;
		int sumEng = 0;
		int sumMath = 0;
		for (int i = 0; i < scores.length; i++) {
			sumKor += scores[i].scKor;
			sumEng += scores[i].scEng;
			sumMath += scores[i].scMath;
		}
		
		System.out.print("		" + sumKor + "	" + sumEng + "	" + sumMath + "	" + (sumKor + sumEng + sumMath));
		
	}
}

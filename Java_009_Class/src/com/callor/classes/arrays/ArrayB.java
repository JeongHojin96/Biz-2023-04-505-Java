package com.callor.classes.arrays;

import com.callor.classes.model.ScoreDto;
import com.callor.classes.service.ScoreServiceA;

public class ArrayB {



	public static void main(String[] args) {
		ScoreServiceA scoreService = new ScoreServiceA();
		ScoreDto 홍길동 = new ScoreDto();
		ScoreDto 이몽룡 = new ScoreDto();
		ScoreDto 성춘향 = new ScoreDto();

		홍길동.stName = "홍길동";
		홍길동.stNum = "0001";
		홍길동.scKor = scoreService.getScore();
		홍길동.scEng = scoreService.getScore();
		홍길동.scMath = scoreService.getScore();
		
		이몽룡.stName = "이몽룡";
		이몽룡.stNum = "0002";
		이몽룡.scKor = scoreService.getScore();
		이몽룡.scEng = scoreService.getScore();
		이몽룡.scMath = scoreService.getScore();
		
		성춘향.stName = "성춘향";
		성춘향.stNum = "0003";
		성춘향.scKor = scoreService.getScore();
		성춘향.scEng = scoreService.getScore();
		성춘향.scMath = scoreService.getScore();
		
		
		System.out.println("학번	이름	국어	영어	수학	총점	평균");
		System.out.println("----------------------------------------------------");
		scoreService.scoreprint(홍길동);
		scoreService.scoreprint(성춘향);
		scoreService.scoreprint(이몽룡);

	}
}

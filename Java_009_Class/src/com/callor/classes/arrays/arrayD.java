package com.callor.classes.arrays;

import com.callor.classes.model.ScoreDto;
import com.callor.classes.service.ScoreServiceA;

public class arrayD {

	/*
	 * class type 의 객체(변수) 배열 만들기
	 * ClassName[] object = new ClassName[10]
	 * class type 의 배열은 일반 변수 배열과 달리
	 * 즉시 사용할 수 없다. 동시에 초기화 되지 않는다.
	 * 별도로 배열 요소를 초기화 시키는 코드가 필요하다.
	 */
	
	public static void main(String[] args) {
		// ScoreDto type 요소 10을 갖는 배열 선언
		ScoreDto[] scores = new ScoreDto[10];
		
		// class type 의 배열 요소 전체를 객체 요소로 생성하기
		for(int index = 0 ; index < scores.length ; index++) {
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
		
		for(int i = 0 ; i < scores.length ; i++ ) {
			scores[i].stNum = 1000 + i;
			scores[i].scKor = scoreService.getScore();
			scores[i].scEng = scoreService.getScore();
			scores[i].scMath = scoreService.getScore();		
		}
		for(int i = 0 ; i < scores.length ; i++ ) {		
			scoreService.scoreprint(scores[i]);
		}
		
		System.out.println("=".repeat(70));
		
		int sumKor = 0;
		int sumEng = 0;
		int sumMath = 0;
		for(int i = 0 ; i < scores.length ; i++) {
		sumKor += scores[i].scKor;
		sumEng += scores[i].scEng;
		sumMath += scores[i].scMath;
		}
		
		System.out.print("		" + sumKor + "	" + sumEng + "	" + sumMath + "	" + (sumKor+sumEng+sumMath));
		
	}
	
	
}

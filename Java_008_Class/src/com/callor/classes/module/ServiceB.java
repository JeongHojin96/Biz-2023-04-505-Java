package com.callor.classes.module;

import com.callor.classes.model.ScoreDto;

public class ServiceB {

	public void score(ScoreDto score) {
		System.out.println("학번 : " + score.stNum );
		System.out.println("이름 : " + score.stName);
		System.out.println("국어 : " + score.intKor);
		System.out.println("영어 : " + score.intEng);
		System.out.println("수학 : " + score.intMat);
		System.out.println("국사 : " + score.intHis);
		System.out.println("음악 : " + score.intMus);
		System.out.println("미술 : " + score.intArt);
		System.out.println("체육 : " + score.intSpo);
		
//		int intTot = score.intKor;
//		intTot += score.intEng;
//		intTot += score.intMat;
//		intTot += score.intHis;
//		intTot += score.intMus;
//		intTot += score.intArt;
//		intTot += score.intSpo;

		int intTot = score.getTotal(); //캡슐화
//		float floAvg = (float)intTot / 3;
		float floAvg = score.getAvg();		
		System.out.println("총점 : " + intTot);
		System.out.printf("평균 : %.1f", floAvg);
	}
}

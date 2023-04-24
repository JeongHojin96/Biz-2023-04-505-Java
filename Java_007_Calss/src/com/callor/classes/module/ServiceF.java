package com.callor.classes.module;

public class ServiceF {
	public ServiceF() {
	}
	public void score(int intKor, int intEng, int intMath, int intguc, int intmu, int intar, int intce) {
		int sNum = intKor+intEng+intMath+intguc+intmu+intar+intce;
		float aNum = (float)(sNum)/7;
		System.out.println(sNum + " : 총점\n" + aNum + " : 평균");
	}
	
}

package com.callor.controller.var;

public class VarA {

	public static void main(String[] args) {
		int intKor = 98;
		int intEng = 90;
		int intMath = 80;

		int intTotal = intKor + intEng + intMath;
		float floatAvg = (float)intTotal / 3f;
		System.out.println("==========");
		System.out.printf("국어 : %3d\n영어 : %3d\n수학 : %3d\n",intKor, intEng, intMath);
		System.out.println("----------");
		System.out.printf("총점 : %3d, 평균 : %5.2f ", intTotal, floatAvg);
	}
}

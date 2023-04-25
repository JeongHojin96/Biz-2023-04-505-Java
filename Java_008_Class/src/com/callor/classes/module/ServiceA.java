package com.callor.classes.module;

public class ServiceA {

	public ServiceA() {
	}

	public void score(int num1, int num2, int num3, int num4, int num5, int num6, int num7) {
		int sumSco = num1 + num2 + num3 + num4 + num5 + num6 + num7;
		float avgSco = (float) (sumSco) / 7;
		System.out.printf("국어 : %d 영어 : %d 수학 : %d 국사 : %d 음악 : %d 미술 : %d 체육 : %d\n",
				num1, num2, num3, num4, num5, num6, num7);
		System.out.printf("총점 : %d 평균 : %2.1f", sumSco, avgSco);

	}
}

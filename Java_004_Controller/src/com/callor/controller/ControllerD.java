package com.callor.controller;

public class ControllerD {

	public static void main(String[] args) {
		int nCnt = 0;
		float nSum = 0;
		for (int i = 0; i < 100; i++) {
			int nRan = (int) (Math.random() * 50 + 51);
			if (nRan % 2 == 0) {
				System.out.println(nRan + " 짝수");
				nCnt++;
				// 누적 : 숫자값을 계속 쌓아서 덧셈
				nSum += nRan;
			}
		}
		float nAvg = nSum/nCnt;
		System.out.printf("개수 : %d  합 : %.1f  평균 : %.1f",nCnt,nSum,nAvg);
	}		
}

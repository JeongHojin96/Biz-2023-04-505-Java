package com.callor.controller;

public class ControllerD {

	public static int prime() {
		int rNum = (int) (Math.random() * 50) + 51;
		for (int i = 2; i < rNum; i++) {
			if (rNum % i == 0) {
				return 0;
			}
		}
		return rNum;
	}

	public static void main(String[] args) {
		int sNum = 0;
		int cNum = 0;
		for (int i = 0; i < 100; i++) {
			int rNum = prime();
			if (rNum > 0) {
				System.out.print(rNum + "\t");
				cNum++;
				sNum += rNum;
			}
		}
		System.out.printf("\n개수 : %d \n합계 : %d", cNum, sNum);
	}

}

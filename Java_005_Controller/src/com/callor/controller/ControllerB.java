package com.callor.controller;

public class ControllerB {

	public static void main(String[] args) {
		int rNum = (int) (Math.random() * 50) + 51;
		int uNum = 0;
		for (int i = 2; i < rNum; i++) {
			if (rNum % i == 0) {
				System.out.println(rNum + " = 소수아님");
				uNum = i; // false 이면 한번도 실행이 되지않아서 nNum에는 아무런 수도 채워지지 않는다.
				break;
			}
		}
		if (uNum == 0) {
			System.out.println(rNum + " = 소수");
		}
	}
}
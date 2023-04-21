package com.callor.controller;

public class ControllerB {

	public static boolean prime() {
		int rNum = (int) (Math.random() * 50) + 51;
		int index = 0;
		for (index = 2; index < rNum; index++) {
			if (rNum % index == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		for(int i = 0 ; i < 100 ; i++) {
			/*
			 * prime(0 method 를 실행하여 
			 * return 값을 yPrime 에 저장하기
			 * 이때 prime() method 의 return type 과
			 * yPrime 의 return type 은 같아야 된다
			 */
			boolean yPrime = prime();
			if(yPrime) {
				System.out.println("소수");
			} else {
				System.out.println("소수 아님");
			}
		}
	}
	
	
}

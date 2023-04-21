package com.callor.controller;

public class ControllerA {
	// String[] args = 매개변수, parameter
	// main -> 시작점 method
	/*
	 * java.exe 도구가 ControllerA.class 파일을 읽어서 메모리에 load하고 제일먼저 호출하는 method()
	 * 시작점 method, 진입점 method
	 */
	public static void main(String[] args) {
		// retrun type 이 void 이므로 단독으로만
		// 호출하여 명령을 실행할 수 있다.
		prime();
		// prime() method 는 return type 이 void 이기 때문에
		// 다른 명령문에 포함되거나
		// if(prime()) {
		// 변수의 값을 생성할 수 없다
		// boolean yPrime = prime();
		// 변수에 대입하는 값도 생성할 수 없다
		// boolean yPrime;
		// yPrime = prime() ;
	}  // end main

	  

	/*
	 * 매개변수도 없고, return type 이 void(없다라고 표현)인 prime() method 선언
	 */
	public static void prime() {
		int rNum = (int) (Math.random() * 50) + 51;
		int index = 0;
		for (index = 2; index < rNum; index++) {
			if (rNum % index == 0) {
				break;
			}
		}
		if (index >= rNum) {
			System.out.println(rNum + " = 소수");
		} else {
			System.out.println(rNum + " = 소수아님");
		}
	}
}

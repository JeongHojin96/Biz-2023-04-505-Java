package com.callor.controller;

public class ControllerG {
	
	
	/*
	 * pirme() method {} 내에서 선언했던 rNum 변수를
	 * 매개변수(Parameter) 로 변경하였다.
	 * 매개변수는 스스로 초기화할 수 없다.
	 * 누군가 prime() method 를 호출하면서
	 * 값을 전달해줘야만 그 값으로 초기화 할 수 있다.
	 * prime (int rndNum = 0) 과 같은 코드 사용불가
	 * 
	 * main(0 에서 prime(55) 와 같은 코드가 실행될때
	 * 매개변수 값이 초기화 된다.
	 */
	// (int rNum) : 매개변수, parameter
	// 변수는 type을 잘지켜야한다.
	public static boolean prime (int rNum)  {
//		int rNum = (int) (Math.random() * 50) + 51;
		int index;
		for (index = 2; index < rNum; index++) {
			if (rNum % index == 0) {
				break;
			}
		}
		boolean yPrime = rNum <= index;
		return yPrime;
	}

	public static void main(String[] args) {

		for (int i = 0; i < 100; i++) {
			
			// main 에서 랜덤수를 만들고 
			int mrNum = (int) (Math.random() * 50) + 51;
			
			// prime() method 에게 전달해주기
			// prime() method 에게 mrNum 변수에 저장된
			// 값을 "전달해 주기" 
			// 이 때 mrNum를 인수, argument 라고 한다
			if(prime( mrNum )) {
				System.out.println(mrNum +" = 소수");
			} else {
				System.err.println(mrNum +" = 소수아님");
			}
		}
	}
}

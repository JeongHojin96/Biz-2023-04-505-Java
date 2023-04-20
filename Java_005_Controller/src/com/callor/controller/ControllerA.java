package com.callor.controller;

public class ControllerA {

	public static void main(String[] args) {
		/*
		 * 큰 실수형 (double) dNum 변수를 선언하고
		 * Math.random() 가 만들어준 값으로 초기화 한다
		 */
		double dNum = Math.random();
		//dNum = dNum * 50;
		dNum *= 50;
		/*
		 * 정수형 intNum 변수를 선언하고
		 * douNum 변수의 값을 정수형으로 변환한 후
		 * 결과 값으로 iNum 변수를 초기화 하였다.
		 */
		int iNum = (int)dNum;
		iNum += 51;
		
		/*
		 * int type (정수형) rNum 변수를 선언하고
		 * 51 ~ 100까지 임의로 생성된 랜덤수로
		 * rNum 변수를 초기화 하였다. 
		 */
		int rNum = (int)(Math.random()*50) + 51;
		
		// rNum 변수에 저장된 값을 읽어서
		// consol에 출력하라
		System.out.println(rNum);
				
	}
}

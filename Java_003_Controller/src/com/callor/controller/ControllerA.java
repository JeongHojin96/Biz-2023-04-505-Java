package com.callor.controller;

public class ControllerA {

	public static void main(String[] args) {
		int index = 0;
		/*
		 * 1. index < 10 비교문 실행
		 * 2. 결과 true
		 * 3. {} 코드 실행
		 * 4. index++ 하여 index 변수값을 1증가
		 * 
		 * 1. index < 10 비교문 실행
		 * 2. 결과 false
		 * 3. 반복문 종료
		 */
		for ( ; index < 10 ; index ++ ) {
			// 현재 이 코드는 index가 0 ~ 9까지
			// 변화되는 동안 실행
			// 총 10회 실행된다.
		}
	}
}

package com.callor.controller;

public class ControllerC {

	public static void main(String[] args) {
		int rNum = (int) (Math.random() * 50) + 51;
		int index;
		for (index = 2; index < rNum; index++) {
			if (rNum % index == 0) {
//				System.out.println(rNum + " 소수아님");
				break;
			}
		}
		System.out.printf("rnd %d , index %d\n", rNum, index);
		/*
		 * for() 반복문에서 최대갓과 index의 관계
		 * 최대값표현 index < 최대값 또는 index <= 최대값으로 표현
		 * for() 반복문이 몇번 반복될 것인가를 결정짓는 연산식
		 * for() 반복문은 중간에 break를 만나서 반복문 실행을 중단할 수 있다.
		 * 또는 그렇지 않고 모든 조건대로 반복문이 실행완료 될 수 있다.
		 * for() 실행 완료되면 rNum <= index 조건이 true 가 된다.
		 * 이 조건을 검사하려면 index 변수를 for() 이전에 선언하여야 한다
		 */
		if(rNum <= index) {
			System.out.println("소수");			
		} else {
			System.out.println("소수아님");
		}
	}
}

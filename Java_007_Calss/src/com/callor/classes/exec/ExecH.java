package com.callor.classes.exec;

import com.callor.classes.module.MyClassC;

public class ExecH {
	/*
	 * 50 ~ 100까지 중의 임의의 랜덤수를 생성하여 MyClassC 의 prime() method 에게 전달하고 소수인지 아닌지 결과를
	 * Console에 출력
	 */

	public static void main(String[] args) {
		int rNum = (int) (Math.random() * 50) + 51;
		// myClassC type 의 myC 객체 생성(선언과 초기화)
		// myC 는 MyClassC 의 대리자 역할을 수행할 것이다
		MyClassC myC = new MyClassC();
		// myC 대리자를 통하여 prime(int) method 를 호출하기
		// 결과를 result 변수에 받기
		if (myC.prime(rNum) > 0) {
			System.out.println(rNum + " = 소수");
		} else {
			System.out.println(rNum + " = 소수아님");
		}
	}
}

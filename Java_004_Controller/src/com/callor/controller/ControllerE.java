package com.callor.controller;

public class ControllerE {

	public static void main(String[] args) {
		/*
		 * 51 ~ 100까지 랜덤수 1개를 만들고
		 * 이 수가 소수(Prime)수 가 아닌지 찾기
		 * Prime : 1과 자신 이외의 약수를 갖지 않는 수
		 * 2 ~ (자신-1) 범위의 정수로 나누었을때
		 * 한번도 나머지가 0이 아닌수
		 * 나머지가 한번이라도 0이 되면 prime 이 아니다.
		 */
		int nRan = (int) (Math.random() * 50 + 51);
		for (int i = 2; i < nRan; i++) {
			// 이 for() 명령에 의해
			// index 값은 2 부터 , rnd -1 까지 연속된
			// 정수로 만들어져 for() {}에서 사용가능하다
			if (nRan % i == 0) {
				System.out.print(nRan + " : ");
				System.out.print(i + "로 나누면 나머지가 ");
				System.out.print(nRan % i);
				System.out.println(" 이므로 수는 소수가 아님");
				// 반복문을 수행하며 연산을 실행하는 과정에서
				// 소수가 아님을 판별하면 더이상 반복문을
				// 진행할 필요가 없으므로 여기서 중단
				// break : for() 반복문을 중단할때
				// ** for() 반복문 밖에서는 사용할 수 없음
				break;
			}
		}
//		System.out.println(nRan);
	}
}

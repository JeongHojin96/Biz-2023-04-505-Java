package com.callor.exam;

public class ExamA {

	public static void main(String[] args) {
		int index = 0;

		for (index = 0; index < 100; index++) {
			int rndNum = (int) (Math.random() * 100) + 1;
			if (rndNum < 1 || rndNum > 100) {
				break;
			}
			
		}
		if(index >= 100) {
			System.out.println("100 번 수행결과 1 ~ 100까지의 랜덤수를 만들어 내고 있습니다");
		} else {
			System.out.println("테스트 횟수 : " + index);
			System.err.println("100 번 수행결과" + index + "번째에서 실패함");
		}
	}
}

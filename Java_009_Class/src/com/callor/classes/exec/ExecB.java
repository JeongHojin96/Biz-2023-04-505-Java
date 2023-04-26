package com.callor.classes.exec;

public class ExecB {

	public static void main(String[] args) {
		// 정수형 배열 nums 를 선언하고,
		// 저장 공간 10개를 생성하라
		int[] nums = new int[10];
		
		// nums 배열의 0 ~ 9 요소까지
		// 순서대로 1 ~ 10까지 값을 저장하기
		for(int index = 0; index < 10 ; index ++) {
			nums[index] = index+1;
		}
		
		for(int index = 0 ; index < 10 ; index ++) {
			nums[index] = (int)(Math.random() * 50) + 51;
		}
	}
}

package com.callor.classes.exec;

public class ExecI {

	public static void main(String[] args) {

		int[] nums = new int[50];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 51) + 50;
		}
		// 거꾸로 가는 for 문
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] % 3 == 0) {
				System.out.println(i + "번째 : " + nums[i]);
				break;
			}
		}
		// ㅁ
		int count = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 3 == 0) {
				count = i;
			}
		}
		if (count > -1) {
			System.out.println(count + "번째 : " + nums[count]);
		}

	}
}

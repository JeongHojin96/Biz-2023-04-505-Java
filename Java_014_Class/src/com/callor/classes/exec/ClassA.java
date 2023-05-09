package com.callor.classes.exec;

public class ClassA {

	public static void main(String[] args) {
		int[] nums = new int[10];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 51) + 50;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0) {
				System.out.println(i + 1 + " 번째 " + nums[i]);
				break;
			}
		}
	}
}

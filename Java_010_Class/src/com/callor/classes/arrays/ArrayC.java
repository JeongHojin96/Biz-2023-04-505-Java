package com.callor.classes.arrays;

public class ArrayC {

	public static void main(String[] args) {

		int[] nums = new int[45];
		int[] lottos = new int[6];
		for (int index = 0; index < nums.length; index++) {
			nums[index] = index + 1;
		}
		for (int index = 0; index < lottos.length; index++) {
			lottos[index] = index + 1;
		}

		for (int i = 0; i < 1000; i++) {
			int index1 = (int) (Math.random() * nums.length);
			int index2 = (int) (Math.random() * nums.length);
			int _tmp = nums[index1];
			nums[index1] = nums[index2];
			nums[index2] = _tmp;
		}

		for (int out = 0; out < 6; out++) {
			for (int in = out + 1; in < 6; in++) {
				if (nums[out] > nums[in]) {
					int _tmp = nums[in];
					nums[in] = nums[out];
					nums[out] = _tmp;
				}
			}
		}
		for (int i = 0; i < 6; i++) {
			lottos[i] = nums[i];
			System.out.printf("%d\t", lottos[i]);
		}
	}
}

package com.callor.classes.arrays;

public class ArrayE {
	public static void main(String[] args) {
		int[] nums = new int[10];
		for (int i = 0; i < 10; i++) {
			nums[i] = i + 1;
		}

		for (int i = 0; i < 10; i++) {
			if (nums[i] % 2 == 0) {
				System.out.println(nums[i]);
			}
		}
		int ix;
		for (int i = 2; i < 10; i++) {
			for (ix = 2; ix < nums[i]; ix++) {
				if (nums[i] % ix == 0) {
					break;
				}
			}
			if (nums[i] <= ix) {
				System.out.println(nums[i] + " = 소수");
			}
		}
	}
}

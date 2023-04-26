package com.callor.classes.exec;

public class ExecJ {

	public static int prime(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return 0;
			}
		}
		return num;
	}

	public static void main(String[] args) {

		int[] nums = new int[50];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 51) + 50;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if(prime(nums[i]) > 0 ){
				System.out.println(i + " 번째 : " + nums[i]);
				break;
			}
		}
		
		for (int i = nums.length - 1; i >= 0; i--) {
			if (prime(nums[i]) > 0) {
				System.out.println(i + "번째 : " + nums[i]);
				break;
			}
		}
		
	}
}

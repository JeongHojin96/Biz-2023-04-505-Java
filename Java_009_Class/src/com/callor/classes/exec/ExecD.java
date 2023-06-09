package com.callor.classes.exec;

public class ExecD {
	public static void main(String[] args) {
		
		/*
		 * 배열 요소의 생성 개수는 그때 그때 상황에 따라 다르다
		 * 배열의 요소를 대상으로 for() 반복문으로 처리를 할때
		 * 배열 요소의 개수를 일일이 숫자로 코딩하는 것은
		 * 배열 요소의 개수가 변경 될 때마다 수정해야하는
		 * 코드 부분이 많아진다.
		 * 그래서 Java에서는 배열을 생성하면 
		 * 배열의 요소 개수를 알수 있는 변수를 자동으로 생성한다.
		 */
		
		int[] nums = new int[22];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 50) + 51;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 5 == 0) {
				System.out.println(nums[i]);
			}
		}
	}
}

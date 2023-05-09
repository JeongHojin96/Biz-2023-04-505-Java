package com.callor.scanner;

import java.util.Scanner;

public class ScannerG {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

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
		for (int i = 0; i < lottos.length; i++) {

			System.out.println(i + 1 + "번째 GAME START");
			while (true) {
				String strNum = scan.nextLine();
				if (strNum.equals("QUIT")) {
					System.out.println("GAME OVER");
					return;
				}
				try {
					int inNum = Integer.valueOf(strNum);
					if (inNum < 1 || inNum > 45) {
						System.out.println("1 ~ 45 까지 범위의 정수만 입력하세요");
					} else if (inNum == lottos[i]) {
						System.out.println("정답");
						break;
					} else if (lottos[i] > inNum) {
						System.out.println("작아요");
					} else if (lottos[i] < inNum) {
						System.out.println("커요");
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("1 ~ 45 정수 입력");
				}
			}
		}
		for (int ii = 0; ii < nums.length; ii++) {
			System.out.print(nums[ii] + "\t");
		}
	}
}

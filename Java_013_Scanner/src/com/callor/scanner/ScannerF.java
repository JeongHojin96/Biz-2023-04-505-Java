package com.callor.scanner;

import java.util.Scanner;

public class ScannerF {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] nums = new int[6];
		for (int i = 0; i < nums.length; i++) {

			System.out.println(i + 1 + "번째 GAME START");

			int rndNum = (int) (Math.random() * 45) + 1;
			for (int u = 0; u < nums.length; u++) {
				if (nums[u] == rndNum) {
					rndNum = (int) (Math.random() * 45) + 1;
					System.out.println("재생성");
					u = -1 ;
				}
			}

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
					} else if (inNum == rndNum) {
						System.out.println("정답");
						nums[i] = rndNum;
						break;
					} else if (rndNum > inNum) {
						System.out.println("작아요");
					} else if (rndNum < inNum) {
						System.out.println("커요");
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("1 ~ 45 정수 입력");
				}
			}
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + "\t");
		}
	}
}

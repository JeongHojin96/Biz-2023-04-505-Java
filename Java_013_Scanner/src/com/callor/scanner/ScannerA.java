package com.callor.scanner;

import java.util.Scanner;

public class ScannerA {
	
	private static int getNum() {
		
		return 0 ;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int num1 = 0;
		while (true) {
			System.out.println("정수 입력");
			System.out.print("정수 >> ");
			num1 = scan.nextInt();
			
			
			int num2 = 0;
			for (int i = 2; i < num1; i++) {
				if (num1 % i == 0) {
					System.out.println(num1 + " = 소수아님\n");
					num2 = i;
					break;
				}
			}
			if (num2 == 0) {
				System.out.println(num1 + " = 소수\n");
			}
		}
	}
}

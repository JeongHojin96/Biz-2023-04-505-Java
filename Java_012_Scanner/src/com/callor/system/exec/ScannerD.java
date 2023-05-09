package com.callor.system.exec;

import java.util.Scanner;

public class ScannerD {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int num1 = 0;
		int num2 = 0;
		
		while (true) {
			
			System.out.println("정수 입력");
			String strNum1 = "";
			String strNum2 = "";
			
			while (true) {
				System.out.print("정수1 (QUIT:종료) >> ");
				strNum1 = scan.nextLine();
				if (strNum1.equalsIgnoreCase("QUIT")) {
					break;
				}
				try {
					num1 = Integer.valueOf(strNum1);
				} catch (Exception e) {
					// TODO: handle exception
					System.err.println("\n정수1은 정수값만 입력");
					continue;
				}
				break;
			}
			
			if (strNum1.equalsIgnoreCase("QUIT")) {
				break;
			}
			
			while (true) {
				System.out.printf("정수2 (QUIT:종료) >> ");
				strNum2 = scan.nextLine();
				if (strNum2.equalsIgnoreCase("QUIT")) {
					break;
				}
				try {
					num2 = Integer.valueOf(strNum2);
				} catch (Exception e) {
					// TODO: handle exception
					System.err.println("\n정수2은 정수값만 입력");
					continue;
				}
				break;
			}
			
			if (strNum2.equalsIgnoreCase("QUIT")) {
				break;
				
			}
			System.out.print("\n--------------------\n");
			System.out.printf("%d + %d = %d\n", num1, num2, num1 + num2);
			System.out.printf("%d - %d = %d\n", num1, num2, num1 - num2);
			System.out.printf("%d * %d = %d\n", num1, num2, num1 * num2);
			System.out.printf("%d / %d = %d\n", num1, num2, num1 / num2);
			System.out.print("--------------------\n\n");
		}
		System.out.println("\nOVER");
	}
}

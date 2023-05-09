package com.callor.system.exec;

import java.util.Scanner;

public class ScannerA {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num1 = 0;
		int num2 = 0;
		while(true) {
			System.out.println("두 개의 정수를 입력하세요");
			System.out.print("정수1>> ");
			num1 = scan.nextInt();
			System.out.printf("정수2>> ");
			num2 = scan.nextInt();
			
			System.out.printf("%d+%d=%d\n",num1,num2,num1+num2);
			
			System.out.println("종료하려면 Quit 를 입력하세요");
			System.out.println("$");
			String str = scan.nextLine();
			if(str=="Quit") {
				break;
			}
			
		}
	}
}

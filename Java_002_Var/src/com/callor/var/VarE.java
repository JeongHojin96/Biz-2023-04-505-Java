package com.callor.var;

public class VarE {

	public static void main(String[] args) {
		int num1 = 0;
		int num2 = 0;
		num1 = 30;
		num2 = 40;
		int plus1;
		int minus1;
		int times1;
		int devide1;
		plus1 = num1 + num2;
		minus1 = num1 - num2;
		times1 = num1 * num2;
		devide1 = num1 / num2;
		System.out.println("덧셈 : " + plus1);
		System.out.println("뺄셈 : " + minus1);
		System.out.println("곱셈 : " + times1);
		System.out.println("나눗셈 : " + devide1);
		
		System.out.printf("%d + %d = %d\n", num1, num2, plus1);
		System.out.printf("%d - %d = %d\n", num1, num2, minus1);
		System.out.printf("%d x %d = %d\n", num1, num2, times1);
		System.out.printf("%d / %d = %d\n", num1, num2, devide1);
	}
}

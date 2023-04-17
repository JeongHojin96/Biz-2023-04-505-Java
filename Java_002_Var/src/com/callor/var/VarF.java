package com.callor.var;

public class VarF {

	public static void main(String[] args) {
		int num1 = 30;
		int num2 = 43;
		// boolean = 참 또는 거짓 구분, == = 맞냐?물어보는것
		// 데이터 type 이 true, false 로만 나타나는 
		boolean bEven1 = num1 % 2 == 0;
		boolean bEven2 = num2 % 2 == 0; 
		//even = 짝수 , odd = 홀수
		System.out.println(bEven1); 
		System.out.println(bEven2);
	}
}

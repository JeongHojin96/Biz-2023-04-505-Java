package com.callor.classes.module;

public class ServiceB {
	public ServiceB () {
	}
	
	public void score(String name, int num1, int num2, int num3) {
		int sNum = num1 + num2 + num3;
		float avgNum = (float)(sNum) / 3;
		System.out.println("================================");
		System.out.println("이름	국어 영어 수학 총점 평균");
		System.out.println("--------------------------------");
		System.out.println(name +"   "+  num1 +"   "+  num2 + "   "+  num3 +"  "+ sNum +"  "+ avgNum);
		System.out.println("================================");
		
	}
}
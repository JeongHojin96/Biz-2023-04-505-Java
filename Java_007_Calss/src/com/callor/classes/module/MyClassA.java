package com.callor.classes.module;

public class MyClassA {

	/*
	 * public 키워드만을 가진 method
	 * 클래스와 이름이 같은 method
	 */
	
	public MyClassA ()	{
	
		/*
		 * MyClassA 클래스의 생성자
		 */
		
	}
	
	// static 키워드가 없는 method()
	// 두개의 정수형 매개변수를 갖고, 전달 받아 , 정수형 변수값을 return한다.
	/*
	 * 2개의 매개변수를 통하여 정수 2개를 전달받고
	 * 전달받은 정수를 덧셈하여 return 하는 add() method
	 */
	public int add(int num1, int num2) {
		return num1 + num2;
	}
	
}

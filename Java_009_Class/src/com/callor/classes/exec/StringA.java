package com.callor.classes.exec;

public class StringA {

	public static void main(String[] args) {
		String str = "Republic of Korea";
		System.out.println(str.substring(10));
		
		System.out.printf("%d\nf",20);
		
		String view = String.format("%d",20);
		System.out.println(view);
		
		/*
		 * String.format()
		 * 문자열을 fomat 형식 문자열로 변환하는 method
		 * System.out.printf() 와 유사한데
		 * .. printf()는 결과를 단순히 Consol에 출력하는 용도
		 * String.format() 은 결과를 다른 변수에 저장할 수 있다.
		 * 
		 * print() 는 아마도 void printf() 일 것이고
		 * format() 은 아마도 String format() 이고 return 이 있을 것이다.
		 * 
		 */
		int num = 3;
		// num 변수에 저장된 값을 문자열로 변환하여
		// result 문자열 변수에 저장하기
		String result = String.format("%d", num);
		result = String.format("값 : %d", num);
		
		System.out.println(result);
		
		result = String.format("값 :%d", num);
		System.out.println(result);
		
		// %5d : 전체 5개의 자릿수를 확보하고
		// 숫자를 오른쪽 정렬하는 문자열 생성하기
		result = String.format("값 :%5d", num);
		System.out.println(result);

		result = String.format("값 :%05d", num);
		System.out.println(result);
		
		result = String.format("값 :S%05d", num);
		System.out.println(result);
		
		//result = System.out.printf("값 :S%05d", num);
		// printf() 사용하여 문자열 format을 지정하고 싶은데
		// printf() 단순히 console에 출력하는 일만 할 수 있다.
		// printf() method 는 void return type 이기 때문이다.
		// pirntf() method 를 대신하여 결과를 변수에 저장하고 싶을때는
		// String.format() 을 사용한다.
	}
}

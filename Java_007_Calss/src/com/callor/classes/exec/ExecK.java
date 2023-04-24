package com.callor.classes.exec;

import com.callor.classes.module.ServiceB;

public class ExecK {

	public static void main(String[] args) {
		int koNum = (int) (Math.random() * 50) + 51 ;
		int enNum = (int) (Math.random() * 50) + 51 ;
		int maNum = (int) (Math.random() * 50) + 51 ;
		String name = "홍길동";
		ServiceB serB = new ServiceB();
		
		serB.score(name, koNum, enNum, maNum);
		
	}
}

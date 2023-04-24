package com.callor.classes.exec;

import com.callor.classes.module.ServiceA;

public class ExecJ {

	public static void main(String[] args) {
		ServiceA serA = new ServiceA();
		int rNum1 = (int) (Math.random() * 50) + 51;
		int rNum2 = (int) (Math.random() * 50) + 51;
		int result = serA.add(rNum1, rNum2);
		System.out.println(result);
	}
}

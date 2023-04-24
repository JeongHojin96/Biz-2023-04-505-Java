package com.callor.classes.exec;

import com.callor.classes.module.ServiceD;

public class ExecM {

	public static void main(String[] args) {
		ServiceD serD = new ServiceD();
		int rNum1 = (int) (Math.random() * 50) + 51;
		int rNum2 = (int) (Math.random() * 50) + 51;
		serD.add(rNum1, rNum2);
	}
}

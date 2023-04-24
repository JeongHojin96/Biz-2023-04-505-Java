package com.callor.classes.exec;

import com.callor.classes.module.MyClassC;

public class ExecI {

	public static void main(String[] args) {
		MyClassC myC = new MyClassC();
		int cNum = 0;
		for (int i = 0; i < 100; i++) {
			int rNum = (int) (Math.random() * 50) + 51;
			if (myC.prime(rNum) > 0) {
				cNum++;
			}
		}
		System.out.println(cNum + " 개");
	}

}

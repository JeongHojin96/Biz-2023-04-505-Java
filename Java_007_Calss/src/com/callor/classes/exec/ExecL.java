package com.callor.classes.exec;

import com.callor.classes.module.ServiceC;

public class ExecL {
	public static void main(String[] args) {
		int rNum = (int) (Math.random() * 10);
		ServiceC serC = new ServiceC();
		if (rNum >= 2 && rNum <=9) {
			serC.guguDan(rNum);
		}
	}
}

package com.callor.classes.exec;

import com.callor.classes.module.ServiceF;

public class ExecO {

	public static void main(String[] args) {
		
		int intKor = (int) (Math.random() * 50) + 51;
		int intEng = (int) (Math.random() * 50) + 51;
		int intMath = (int) (Math.random() * 50) + 51;
		int intguc = (int) (Math.random() * 50) + 51;
		int intmu = (int) (Math.random() * 50) + 51;
		int intar = (int) (Math.random() * 50) + 51;
		int intce = (int) (Math.random() * 50) + 51;
		ServiceF serF = new ServiceF();
		serF.score(intKor,intEng,intMath, intguc, intmu, intar, intce);
	}
}

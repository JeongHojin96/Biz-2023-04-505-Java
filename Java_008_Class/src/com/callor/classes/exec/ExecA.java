package com.callor.classes.exec;

import com.callor.classes.module.ServiceA;

public class ExecA {

	public static void main(String[] args) {
		int korSco = (int) (Math.random() * 50) + 51;
		int engSco = (int) (Math.random() * 50) + 51;
		int matSco = (int) (Math.random() * 50) + 51;
		int hisSco = (int) (Math.random() * 50) + 51;
		int musSco = (int) (Math.random() * 50) + 51;
		int artSco = (int) (Math.random() * 50) + 51;
		int phySco = (int) (Math.random() * 50) + 51;

		ServiceA serA = new ServiceA();
		serA.score(korSco, engSco, matSco, hisSco, musSco, artSco, phySco);
	}
}

package com.callor.scanner;

import com.callor.scanner.service.PrimeServiceV1;

public class ScannerC {

	public static void main(String[] args) {
		
		PrimeServiceV1 pSer1 = new PrimeServiceV1();
		
		while (true) {
			int num = pSer1.getNum();
			if (num < 0) {
				System.out.println("GAME OVER");
				return;
			}
			int result = pSer1.primeYesNo(num);
			if (result > 0) {
				System.out.println(num + " 는 소수");
			} else {
				System.out.println(num + " 는 소수가 아님");
			}		
		}
	}
}

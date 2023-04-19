package com.callor.controller;

public class ControllerB {

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			int iran = (int) (Math.random() * 50 + 51);
//			if (iran % 2 == 0) {
//				System.out.println(iran + " 짝수");
//			} else {
//				System.err.println(iran + " 짝수아님");
			if (iran % 2 == 0) {
				System.out.println(iran + " 짝수");
			} else if (iran % 2 == 1) {
				System.out.println(iran + " 홀수");
			}
		}
	}
}

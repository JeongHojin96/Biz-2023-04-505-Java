package com.callor.controller;

public class ControllerE {

	public static void main(String[] args) {

		// for(int intScore = 0;;intScore = (int)(Math.random() * 50 + 51)) {
		// System.out.println(intScore);

		for (int i = 0; i < 1000; i++) {
			int intScore = (int) (Math.random() * 50) + 51;
			// if(intScore < 51 || intScore > 100) {
			if (!(intScore >= 51 && intScore <= 100)) {
				System.out.println(intScore);
			}
		}
		System.out.println("Test End");

		int num1 = 100;
		int num2 = 100;

		if (++num1 > 100 || ++num2 > 100) {
			System.out.println("OK");
		}
		System.out.println(num2);

		if (--num1 > 100 && --num2 > 100) {
			System.out.println("Hello");
		}
		System.out.println(num2);
	}
}

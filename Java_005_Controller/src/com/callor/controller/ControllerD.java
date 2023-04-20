package com.callor.controller;

public class ControllerD {

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			int rNum = (int) (Math.random() * 50) + 51;
			int index;
			for (index = 2; index < rNum; index++) {
				if (rNum % index == 0) {
					break;
				}
			}
			if (rNum <= index) {
				System.out.println(rNum + " = 소수");
			}
		}
	}
}

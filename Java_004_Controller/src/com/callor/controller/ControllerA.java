package com.callor.controller;

import java.util.Random;

public class ControllerA {

	public static void main(String[] args) {

		for (int i = 0; i < 100; i++) {
			int iran = (int) (Math.random() * 50 + 51);
			if (iran < 51 || iran > 100) {
				System.err.println("err");
			} else {
				System.out.println(iran + " 확인");
			}
			//if (iran >= 51 && iran <= 100) {
			//	System.out.println(iran + " 확인");
		}
	}
}

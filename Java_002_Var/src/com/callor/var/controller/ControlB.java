package com.callor.var.controller;

public class ControlB {

	public static void main(String[] args) {
		double douRnd = Math.random();
		douRnd = douRnd * 10;
		// (int), (float) 강제형변환
		int intRnd = (int)douRnd;
		
		System.out.println(douRnd);
		System.out.println(intRnd);
		//random = 난수
		intRnd = (int)(Math.random() * 10);
		
	}
}

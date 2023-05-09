package com.callor.classes.exec;

import java.util.ArrayList;
import java.util.List;

public class NumbersD {

	public static void main(String[] args) {
		List<Integer> numList = new ArrayList<>();
		for (int i = 0; i < 45; i++) {
			numList.add(i + 1);
		}
		for (int i = 0; i < 1000; i++) {
			int index1 = (int) (Math.random() * numList.size());
			int index2 = (int) (Math.random() * numList.size());
			int tmp = numList.get(index1);
			numList.set(index1, numList.get(index2));
			numList.set(index2, tmp);
		}
		for (int i = 0 ; i < 5 ; i++) {
		System.out.println( numList.get(i));
		}
	}
}

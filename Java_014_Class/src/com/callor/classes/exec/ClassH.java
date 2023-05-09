package com.callor.classes.exec;

import java.util.ArrayList;
import java.util.List;

public class ClassH {
	public static void main(String[] args) {
		// java 1.7 이후 버전에서는 생성자에는 Generic을 생략해도 된다.
		List<Integer> numList = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			numList.add((int) (Math.random() * 51) + 50);
		}
		for (int out = 0; out < 10; out++) {
			for (int in = out + 1; in < 10; in++) {
				if (numList.get(out) > numList.get(in)) {
					numList.add(out, numList.get(in));
					numList.add(in, numList.get(out + 1));
					numList.remove(out + 1);
					numList.remove(in + 1);
				}
			}
		}
		// List type 의 객체변수에는 to(String() method 가 포함되고
		// 단순히 List 의 값들을 출력 해 볼 수 있다.
		System.out.println(numList.toString());

	}
}

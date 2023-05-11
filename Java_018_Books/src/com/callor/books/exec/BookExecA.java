package com.callor.books.exec;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class BookExecA {

	// ISBN 도서명 출판사 저자 발행일 페이지 가격
	// 0 1 2 3 4 5 6
	/*
	 * 도서정보.txt 파일을 열어서 각 line 을 읽어 들인 후 index 0 부터 index 8번까지 데이터를 console 에 출력해 보기
	 */

	public static void main(String[] args) {

		String bookFile = "src/com/callor/books/data/도서정보(2023-05-11).txt";
		InputStream is = null;
		Scanner scan = null;
		try {
			is = new FileInputStream(bookFile);
		} catch (FileNotFoundException e) {
			System.out.println(bookFile + " 이 없습니다.");
			return;
		}
		int rows = 0;
		scan = new Scanner(is);
		System.out.println("=".repeat(100));
		System.out.println("ISBN\t도서명\t출판사\t저자\t발행일\t페이지\t가격");
		System.out.println("=".repeat(100));
		while (scan.hasNext()) {
			// 한줄씩 파일에서 읽어 line 에 저장
			String line = scan.nextLine();
			String[] book = line.split(",");
			rows ++;
			if (book.length < 7) {
				System.err.printf("%d 번째 데이터 문제 ",rows);
				System.out.println(line);
				
			} else {
				System.out.printf("%s\t", book[0]);
				System.out.printf("%s\t", book[1]);
				System.out.printf("%s\n", book[2]);
				System.out.println();
			}
		}
		scan.close();

	}
}

package com.callor.books.exec;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class BookExecB {

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
		scan = new Scanner(is);
		while (scan.hasNext()) {
			// 한줄씩 파일에서 읽어 line 에 저장
			String line = scan.nextLine();
			String[] book = line.split(",");

			for (String bkString : book) {
				System.out.print(bkString + "\t");
			}
			System.out.println();
		}
		scan.close();

	}
}

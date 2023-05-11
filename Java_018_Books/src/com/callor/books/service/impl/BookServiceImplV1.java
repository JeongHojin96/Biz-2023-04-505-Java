package com.callor.books.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.books.models.BookDto;
import com.callor.books.service.BookService;

public class BookServiceImplV1 implements BookService {

	protected List<BookDto> bkList;

	public BookServiceImplV1() {
		bkList = new ArrayList<>();
	}

	public void loadBook() {
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
			String line = scan.nextLine();
			String[] book = line.split(",");

			BookDto bkDto = new BookDto();

			bkDto.setbIsbn(book[0]);
			bkDto.setbTitle(book[1]);
			bkDto.setbPublisher(book[2]);
			bkDto.setbAuthor(book[3]);
			bkDto.setbPublishDate(book[4]);
			bkDto.setbPages(Integer.valueOf(book[5]));
			bkDto.setbPrice(Integer.valueOf(book[6].trim()));

			bkList.add(bkDto);
		}
		scan.close();
	}

	public void printBookList() {
		int rows = 0;
		System.out.println("=".repeat(100));
		System.out.println("ISBN\t\t도서명\t\t\t\t\t\t출판사\t저자\t발행일\t\t페이지\t가격");
		System.out.println("=".repeat(100));
		for (BookDto dto : bkList) {
			System.out.printf("%12s\t", dto.getbIsbn());
			if (dto.getbTitle().length() > 16) {
				System.out.printf("%-20s\t\t", dto.getbTitle());
			} else {
				System.out.printf("%-20s\t\t\t", dto.getbTitle());
			}
			System.out.printf("%s\t", dto.getbPublisher());
			System.out.printf("%s\t", dto.getbAuthor());
			System.out.printf("%-10s\t", dto.getbPublishDate());
			System.out.printf("%d\t", dto.getbPages());
			System.out.printf("%d\n", dto.getbPrice());
			if (++rows % 5 == 0) {
				System.out.println("-".repeat(100));
			}
		}
	}

	public BookDto getBook(String isbn) {
		return null;
	}

	public List<BookDto> getBookList() {
		return null;
	}

	public void updateBook(BookDto bookDto) {

	}

	public void deleteBook(String isbn) {

	}

}

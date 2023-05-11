package com.callor.books.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.books.config.DataIndex;
import com.callor.books.config.Utils;
import com.callor.books.models.BookDto;
import com.callor.books.service.BookService;

public class BookServiceImplV2 implements BookService {

	// 도서정보.txt 파일을 읽어와서
	// List<BookDto> type 리스트 데이터로 변환하는 method
	protected List<BookDto> bookList;

	public BookServiceImplV2() {
		bookList = new ArrayList<>();
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
			String line = scan.nextLine(); // 한줄을 읽어오기
			String[] book = line.split(","); // "," 기준으로 잘라서 book[]에 저장하기
			BookDto bkDto = new BookDto();

			bkDto.setbIsbn(book[DataIndex.BOOK.ISBN]);
			bkDto.setbTitle(book[DataIndex.BOOK.TITLE]);
			bkDto.setbPublisher(book[DataIndex.BOOK.PUBLISHER]);
			bkDto.setbAuthor(book[DataIndex.BOOK.AUTHOR]);
			bkDto.setbPublishDate(book[DataIndex.BOOK.PDATE]);
			bkDto.setbPages(Integer.valueOf(book[DataIndex.BOOK.PAGES]));
			bkDto.setbPrice(Integer.valueOf(book[DataIndex.BOOK.PRICE].trim()));

			bookList.add(bkDto);
		}
		scan.close();
	}

	public void printBookList() {
		
		String[] printTitle = "ISBN,도서명,출판사,저자,출판일,페이지,가격".split(",");
		
		int rows = 0;
		System.out.println(Utils.dLine(100));
		System.out.printf("%-13s\t",printTitle[DataIndex.BOOK.ISBN]);
		System.out.printf("%-30s\t",printTitle[DataIndex.BOOK.TITLE]);
		System.out.printf("%s\t",printTitle[DataIndex.BOOK.PUBLISHER]);
		System.out.printf("%s\t",printTitle[DataIndex.BOOK.AUTHOR]);
		System.out.printf("%-10s\t",printTitle[DataIndex.BOOK.PDATE]);
		System.out.printf("%s\t",printTitle[DataIndex.BOOK.PAGES]);
		System.out.printf("%s\n",printTitle[DataIndex.BOOK.PRICE]);
		
		
		System.out.println(Utils.dLine(100));
		for (BookDto dto : bookList) {
			System.out.printf("%13s\t", dto.getbIsbn());
			String bTitle = dto.getbTitle();
			if (bTitle.length()>10) {
				System.out.printf("%-30s\t", dto.getbTitle().substring(0,10));
			} else {
				System.out.printf("%-30s\t", dto.getbTitle());
			}
			System.out.printf("%s\t", dto.getbPublisher());
			System.out.printf("%s\t", dto.getbAuthor());
			System.out.printf("%-10s\t", dto.getbPublishDate());
			System.out.printf("%dp\t", dto.getbPages());
			System.out.printf("%d\n", dto.getbPrice());
			if (++rows % 5 == 0) { 
				System.out.println(Utils.sLine(100));
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

package com.callor.books.exec;

import com.callor.books.service.BookService;
import com.callor.books.service.impl.BookServiceImplV2;

public class BookEsecC {
	public static void main(String[] args) {
		BookService bkSerV1 = new BookServiceImplV2();
		bkSerV1.loadBook();
		bkSerV1.printBookList();
	}
}

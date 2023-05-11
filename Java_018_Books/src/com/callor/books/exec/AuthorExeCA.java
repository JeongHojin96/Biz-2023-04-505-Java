package com.callor.books.exec;

import com.callor.books.service.AuthorService;
import com.callor.books.service.impl.AuthorServiceImplV1;

public class AuthorExeCA {

	public static void main(String[] args) {
		AuthorService atSerV1 = new AuthorServiceImplV1();
		
		atSerV1.loadAuthor();
		atSerV1.printAuthorList();
		
	}
}

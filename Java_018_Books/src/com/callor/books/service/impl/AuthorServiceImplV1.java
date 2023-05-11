package com.callor.books.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.books.config.DataIndex;
import com.callor.books.models.AuthorDto;
import com.callor.books.models.BookDto;
import com.callor.books.service.AuthorService;
import com.callor.books.service.BookService;
import com.callor.classes.models.StudentDto;

public class AuthorServiceImplV1 implements AuthorService {

	protected List<AuthorDto> authorList;

	public AuthorServiceImplV1() {
		authorList = new ArrayList<>();
	}
	
	public void loadAuthor() {
		String AuthorFile = "src/com/callor/books/data/저자정보(2023-05-11).txt";
		InputStream is = null;
		Scanner scan = null;

		try {
			is = new FileInputStream(AuthorFile);
		} catch (FileNotFoundException e) {
			System.out.println(AuthorFile + " 이 없습니다.");
			return;
		}

		scan = new Scanner(is);

		while (scan.hasNext()) {
			String line = scan.nextLine(); // 한줄을 읽어오기
			String[] author = line.split(","); // "," 기준으로 잘라서 book[]에 저장하기
			AuthorDto atDto = new AuthorDto();

			atDto.setAuCode(author[DataIndex.AUTHOR.CODE]);
			atDto.setAuName(author[DataIndex.AUTHOR.NAME]);
			atDto.setAuTel(author[DataIndex.AUTHOR.TEL]);
			atDto.setAuAddress(author[DataIndex.AUTHOR.ADDRESS]);
			
			authorList.add(atDto);
		}
		scan.close();
	}

	public void printAuthorList() {
		
		System.out.println("=".repeat(100));
		System.out.println("저자코드\t저자명\t전화번호\t주소");
		System.out.println("=".repeat(100));
		for (AuthorDto dto : authorList) {
		System.out.printf("%-5s\t\t",dto.getAuCode());
		System.out.printf("%-3s\t",dto.getAuName().substring(0,3));
		System.out.printf("%-13s\t",dto.getAuTel());
		System.out.printf("%-20s\n",dto.getAuAddress());
		}
		
	}

	public AuthorDto getAuthor(String code) {
		if (authorList.isEmpty()) {
			this.loadAuthor();
		}
		for (AuthorDto dto : authorList) {
			if (dto.getAuCode().equals(code)) {
				return dto;
			}
		}
		return null;
	}

	public List<AuthorDto> getAuthorList() {
		if (authorList.isEmpty()) {
			this.loadAuthor();
		}
		return authorList;
	}

}

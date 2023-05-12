package com.callor.books.service.impl;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.books.config.DataIndex;
import com.callor.books.config.Utils;
import com.callor.books.models.PubliserDto;
import com.callor.books.service.PubliserService;

public class PubliserServiceImplV1 implements PubliserService {

	protected List<PubliserDto> pubList;

	public PubliserServiceImplV1() {
		pubList = new ArrayList<>();
	}

	public void loadPubliser() {
		String pubFile = "src/com/callor/books/data/출판사정보(2023-05-11).txt";
		InputStream is = null;
		Scanner scan = null;

		try {
			is = new FileInputStream(pubFile);
		} catch (Exception e) {
			System.out.println(pubFile + " 이 없습니다");
			return;
		}

		scan = new Scanner(is);

		while (scan.hasNext()) {
			String line = scan.nextLine();
			String[] publiser = line.split(",");
			PubliserDto pubDto = new PubliserDto();

			pubDto.setPubCode(publiser[DataIndex.PUBLISER.PCODE]);
			pubDto.setPubName(publiser[DataIndex.PUBLISER.PNAME]);
			pubDto.setPubCeo(publiser[DataIndex.PUBLISER.PCEO]);
			pubDto.setPubTel(publiser[DataIndex.PUBLISER.PTEL]);
			pubDto.setPubAddress(publiser[DataIndex.PUBLISER.PADDRESS]);

			pubList.add(pubDto);
		}
		scan.close();
	}

	public void printPubliserList() {
		System.out.println(Utils.dLine(100));
		System.out.println("출판사코드\t출판사명\t대표\t전화번호\t주소");
		System.out.println(Utils.sLine(100));
		for (PubliserDto dto : pubList) {
			System.out.printf("%s\t", dto.getPubCode());
			System.out.printf("%s\t", dto.getPubName());
			System.out.printf("%s\t", dto.getPubCeo());
			System.out.printf("%s\t", dto.getPubTel());
			System.out.printf("%s\n", dto.getPubAddress());
		}
		System.out.println(Utils.dLine(100));
	}

	public PubliserDto getPubliser(String code) {
		if (pubList.isEmpty()) {
			this.loadPubliser();
		}
		for (PubliserDto dto : pubList) {
			if (dto.getPubCode().equals(code)) {
				return dto;
			}
		}
		return null;
	}

	public List<PubliserDto> getPubliserList() {
		if (pubList.isEmpty()) {
			this.loadPubliser();
		}
		return pubList;
	}

	public PubliserDto getPubliserListByName(String name) {
		List<PubliserDto> serList = new ArrayList<>();

		if (pubList.isEmpty()) {
			this.loadPubliser();
		}

		for (PubliserDto dto : pubList) {
			if (dto.getPubName().contains(name)) {
				serList.add(dto);
			}
		}
		System.out.println(serList);
		return null;
	}
}

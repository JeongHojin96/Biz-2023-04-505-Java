package com.callor.bank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.bank.models.BuyerDto;

public class BuyerServiceImplV1 implements BuyerService {

	protected List<BuyerDto> buList;

	protected Scanner scan;

	public BuyerServiceImplV1() {
		buList = new ArrayList<>();
		scan = new Scanner(System.in);
	}

	public void inputBuyer() {
		while (true) {

			System.out.println("고객정보 입력 / 종료[QUIT]");
			System.out.println("-".repeat(60));

			BuyerDto buDto = new BuyerDto();
			String buId = "";
			while (true) {
				System.out.printf("고객 ID(%s) >> ",buId);
				buId = scan.nextLine();
				if (buId.equals("QUIT"))
					break;
				else if (buId.equals("")) {
					buId = String.valueOf(buList.size() + 1);
				}
					
				try {
					int intbuId = Integer.valueOf(buId);
					buId = String.format("%04d", intbuId);
					System.out.println("고객 ID("+buId+") >> ");
				} catch (Exception e) {
					System.out.println("정수로 입력하세요.");
					continue;
				}
				break;
			}
			if (buId.equals("QUIT"))
				break;

			for (BuyerDto dto : buList) {
				if (dto.buId.equals(buId)) {
					System.out.println("-".repeat(60));
					System.out.println("동일 ID 존재, 데이터 수정 / 그대로두기[Enter]");
					System.out.println("-".repeat(60));
					buDto = dto;
				}
			}

			System.out.printf("고객이름(%s) >> ", buDto.buName == null ? "신규" : buDto.buName);
			String buName = scan.nextLine();
			if (buName.equals("QUIT"))
				break;
			else if (buName.equals(""))
				buName = buDto.buName;

			System.out.printf("전화번호(%s) >> ", buDto.buTel == null ? "신규" : buDto.buTel);
			String buTel = scan.nextLine();
			if (buTel.equals("QUIT"))
				break;
			else if (buTel.equals(""))
				buTel = buDto.buTel;

			System.out.printf("주소(%s) >> ", buDto.buAddr == null ? "신규" : buDto.buAddr);
			String buAddr = scan.nextLine();
			if (buAddr.equals("QUIT"))
				break;
			else if (buAddr.equals(""))
				buAddr = buDto.buAddr;

			System.out.printf("생년월일(%s) >> ", buDto.buBirth == null ? "신규" : buDto.buBirth);
			String buBirth = scan.nextLine();
			if (buBirth.equals("QUIT"))
				break;
			else if (buBirth.equals(""))
				buBirth = buDto.buBirth;

			System.out.printf("직업(%s) >> ", buDto.buJob == null ? "신규" : buDto.buJob);
			String buJob = scan.nextLine();
			if (buJob.equals("QUIT"))
				break;
			else if (buJob.equals(""))
				buJob = buDto.buJob;

			buDto.buId = buId;
			buDto.buName = buName;
			buDto.buTel = buTel;
			buDto.buAddr = buAddr;
			buDto.buBirth = buBirth;
			buDto.buJob = buJob;
			buList.add(buDto);
		}
		System.out.println(buList.toString());
	}

	public void loadBuyer() {

	}

	public void printBuyerList() {

	}

	public BuyerDto getBuyer(String buId) {
		return null;
	}

}

package com.callor.bank.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.callor.bank.config.DBContract;
import com.callor.bank.models.AccDto;
import com.callor.bank.models.AccListDto;
import com.callor.bank.models.BuyerDto;
import com.callor.bank.service.impl.AccListServiceImplV1;
import com.callor.bank.service.impl.AccServiceImplV1;
import com.callor.bank.service.impl.BuyerServiceImplV1;
import com.callor.bank.service.utils.Line;

public class BankService {

	protected final Scanner scan;
	protected List<BuyerDto> buyerList;
	protected final BuyerService buyerService;
	protected final AccService accService;
	protected final AccListServiceImplV1 accListService;

	public BankService() {
		accService = new AccServiceImplV1();
		buyerService = new BuyerServiceImplV1();
		scan = new Scanner(System.in);
		accListService = new AccListServiceImplV1();
	}

	public void printBuyerList() {
		buyerList = buyerService.selectAll();
		System.out.println("=".repeat(100));
		System.out.println("대한은행 고객 리스트");
		System.out.println("=".repeat(100));
		System.out.println("ID\t이름\t전화번호\t주소\t생년월일\t직업");
		System.out.println("-".repeat(100));
		for (BuyerDto buyerDto : buyerList) {
			System.out.printf("%s\t", buyerDto.buId);
			System.out.printf("%s\t", buyerDto.buName);
			System.out.printf("%s\t", buyerDto.buTel);
			System.out.printf("%s\t", buyerDto.buAddr);
			System.out.printf("%s\t", buyerDto.buBirth);
			System.out.printf("%s\n", buyerDto.buJob);
		}
		System.out.println("=".repeat(100));
	}

	public void findByBuyer() {
		System.out.println("=".repeat(100));
		System.out.println("조회하고자 하는 고객ID 를 입력하세요");
		System.out.println("ID >> ");
		String strId = scan.nextLine();

		BuyerDto buyerDto = buyerService.findById(strId);
		if (buyerDto == null) {
			System.out.println("조회한 고객ID는 없는 데이터 입니다.");
		} else {
			System.out.println(buyerDto.toString());
		}
	}

	public void insertBuyer() {
		System.out.println("=".repeat(100));
		System.out.println("고객정보 등록");
		System.out.println("=".repeat(100));

		System.out.println("고객 >> ");
		String strBuId = scan.nextLine();
		System.out.println("고객명 >> ");
		String strBuName = scan.nextLine();
		System.out.println("전화번호 >> ");
		String strBuTel = scan.nextLine();

		BuyerDto buyerDto = new BuyerDto();
		buyerDto.buId = strBuId;
		buyerDto.buName = strBuName;
		buyerDto.buTel = strBuTel;

		buyerService.insert(buyerDto);
	}

	public void delete() {
		System.out.println("=".repeat(100));
		System.out.println("삭제할 고객ID 를 입력하세요");
		System.out.print("고객ID >> ");
		String strBuId = scan.nextLine();

		BuyerDto buyerDto = buyerService.findById(strBuId);
		if (buyerDto == null) {
			System.out.printf("%s 고객ID는 없는 정보입니다", strBuId);
		} else {
			System.out.println(buyerDto.toString());
			System.out.println("고객정보를 정말 삭제할까요?");
			String yesNo = scan.nextLine();
			if (yesNo.equals("YES")) {

				int result = buyerService.delete(strBuId);
				if (result > 0) {
					System.out.println("고객정보 삭제 완료");
				} else {
					System.out.println("고객정보 삭제 실패");
				}
			} else {
				System.out.println("삭제 취소");
			}
		}
	}

	public void update() {
		while (true) {
			System.out.println("수정할 고객 ID 를 입력하세요");
			String strBuId = scan.nextLine();

			BuyerDto buyerDto = buyerService.findById(strBuId);
			if (buyerDto == null) {
				System.out.printf("고객 정보가 없습니다(%s)", strBuId);
				continue;
			}
			System.out.println(buyerDto.toString());
			System.out.printf("고객Id : %s", buyerDto.buId);
			System.out.printf("고객이름(%s)", buyerDto.buName);
			String strBuName = scan.nextLine();
			if (!strBuName.equals(""))
				buyerDto.buName = strBuName;

			System.out.printf("전화번호(%s)", buyerDto.buTel);
			String strBuTel = scan.nextLine();
			if (!strBuTel.equals(""))
				buyerDto.buTel = strBuTel;

			int result = buyerService.update(buyerDto);
			if (result > 0)
				System.out.println("변경 성공");
			else
				System.out.println("변경 실패");
			break;

		}
	}

	public void insertAccList() {
		this.findUserInfo();
		AccListDto accListDto = new AccListDto();
		
		System.out.print("계좌번호 입력 >> ");
		String strAcNum = scan.nextLine();
		accListDto.acNum = strAcNum;

		while (true) {
			System.out.print("1. 입금, 2. 출금 >> ");
			String strAioDiv = scan.nextLine();
			accListDto.aioDiv = strAioDiv;
			if (strAioDiv.equals("1")) {
				System.out.print("입금액 입력 >> ");
				String strAioInput = scan.nextLine();
				accListDto.aioInput = Integer.valueOf(strAioInput);
				accListDto.aioOutput = 0;
				break;
			} else if (strAioDiv.equals("2")) {
				System.out.print("출금액 입력 >> ");
				String strAioOutput = scan.nextLine();
				accListDto.aioOutput = -Integer.valueOf(strAioOutput);
				accListDto.aioInput = 0;
				break;
			} else continue;
		}
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat today = new SimpleDateFormat("YYYY-MM-dd");
		accListDto.aioDate = today.format(date);
		SimpleDateFormat nowTime = new SimpleDateFormat("HH:mm:ss");
		accListDto.aioTIme = nowTime.format(date);
		accListService.insert(accListDto);
		
	}

	public void findUserInfo() {
		this.printBuyerList();

		System.out.println("조회할 고객ID를 입력하세요");
		System.out.print("고객ID >> ");
		String strBuId = scan.nextLine();

		BuyerDto buyerDto = buyerService.findById(strBuId);

		if (buyerDto == null) {
			System.out.println("고객ID 가 없습니다");
			return;
		} else {
			System.out.println(Line.sLine(100));
			System.out.printf("고객ID :  %s\n", buyerDto.buId);
			System.out.printf("이름 :  %s\n", buyerDto.buName);
			System.out.printf("전화번호 :  %s\n", buyerDto.buTel);
			System.out.printf("주소 :  %s\n", buyerDto.buAddr);
			System.out.println(Line.sLine(100));
		}

		List<AccDto> accList = accService.findByBuId(strBuId);
		if (accList.isEmpty()) {
			System.out.println("고객의 계좌정보가 없습니다");
			return;
		} else {
			System.out.println(Line.sLine(100));
			System.out.println("계좌번호\t구분\t잔액");
			System.out.println(Line.sLine(100));
			for (AccDto accDto : accList) {
				System.out.printf("%s\t", accDto.acNum);

				int intDiv = 0;
				try {
					intDiv = Integer.valueOf(accDto.acDiv);

					System.out.printf("%s\t", DBContract.ACC_DIV[intDiv - 1]);

				} catch (Exception e) {
					System.out.printf("%s\t", "종류불명");
				}
				System.out.printf("%d\n", accDto.acBalance);
			}
			System.out.println(Line.sLine(100));
		}


	}

	public void makeAcout() {
		while (true) {
			System.out.println("ID 를 입력하세요");
			String strBuId = scan.nextLine();

			BuyerDto buyerDto = buyerService.findById(strBuId);
			if (buyerDto == null) {
				System.out.printf("고객 정보가 없습니다(%s)", strBuId);
				continue;
			}
			Date date = new Date(System.currentTimeMillis());
			SimpleDateFormat today = new SimpleDateFormat("YYYYMMdd");

			String todayString = today.format(date);

			int maxNum = Integer.valueOf(accService.maxAcNum(todayString)) + 1;
			String acNum = String.format("%s%02d", todayString, maxNum);
			System.out.println("계좌번호 : " + acNum);

			AccDto accDto = new AccDto();

			while (true) {
				System.out.print("1.입출금계좌, 2.적금계좌, 3.대출계좌");
				String selNum = scan.nextLine();

				if (selNum.equals("1")) {
					accDto.acDiv = Integer.toString(1);
					break;
				} else if (selNum.equals("2")) {
					accDto.acDiv = Integer.toString(2);
					break;
				} else if (selNum.equals("3")) {
					accDto.acDiv = Integer.toString(3);
					break;
				} else
					System.out.println("잘못 입력하셨습니다.");
				continue;
			}
			accDto.acNum = acNum;
			accDto.acBalance = 10000;
			accDto.acBuId = strBuId;
			accService.insert(accDto);
			break;
		}

	}

//		int numBank;
//		int maxBank = 0;
//		String fTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
//		AccDto accDto = new AccDto();
//		System.out.print("고객 ID 입력 >> ");
//		String strId = scan.nextLine();
//		BuyerDto buyerDto = buyerService.findById(strId);
//		List<AccDto> accList = accService.selectAll();
//		if (buyerDto == null) {
//			System.out.println("조회한 고객 ID는 없는 데이터 입니다.");
//		} else if (buyerDto.buId == strId) {
//			for (AccDto dto : accList) {
//				numBank = Integer.valueOf(dto.acNum.substring(8, 2));
//				if (maxBank < numBank) {
//					maxBank = numBank;
//				}
//			}
//			String newNum = fTime + String.format(%s%02d,maxBank + 1);
//			System.out.println("생성할 계좌번호 : " + newNum);
//			
//			while (true) {
//				System.out.print("1.입출금계좌, 2.적금계좌, 3.대출계좌");
//				String selNum = scan.nextLine();
//				if (selNum.equals("1")) {
//					accDto.acDiv = Integer.toString(1);
//					break;
//				} else if (selNum.equals("2")) {
//					accDto.acDiv = Integer.toString(2);
//					break;
//				} else if (selNum.equals("3")) {
//					accDto.acDiv = Integer.toString(3);
//					break;
//				} else
//					System.out.println("잘못 입력하셨습니다.");
//			}
//			accDto.acBalance = 10000;
//			accDto.acBuId = strId;
//			accService.insert(accDto);
//		}
//	}
//	

}

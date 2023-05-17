package com.callor.bank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.bank.models.AccDto;

public class AccServiceImplV1 implements AccService {

	protected List<AccDto> accList;
	protected Scanner scan;

	public AccServiceImplV1() {
		accList = new ArrayList<>();
		scan = new Scanner(System.in);
	}

	@Override
	public void accInit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inout() {
		String accNum = "0001";
		String inout = "";
		int acInput = 0;
		int acOutput = 0;
		while(true) {
			System.out.println("계좌 번호 : "+ accNum);
			System.out.print("1. 입금 2. 출금 0. 종료");
			inout = scan.nextLine();
			if(inout.equals("1")) {
				System.out.print("입금액 >> ");
				String inputMoney = scan.nextLine();
				acInput = Integer.valueOf(inputMoney);
			} else if (inout.equals("2") ) {
				System.out.println("출금액 >> ");
				String outputMoney = scan.nextLine();
				acOutput = Integer.valueOf(outputMoney);
			} else if (inout.equals("0")) 
				break;
			
			AccDto acDto = new AccDto();
			if(!(acInput == 0))
			acDto.acInput = acInput;
			if(!(acOutput ==0))
			acDto.acOutput = acOutput;
			accList.add(acDto);
		}
		
	}

	@Override
	public void printAccList() {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveAccList() {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadAccList() {
		// TODO Auto-generated method stub

	}

}

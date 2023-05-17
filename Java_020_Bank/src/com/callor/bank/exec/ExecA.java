package com.callor.bank.exec;

import com.callor.bank.service.BuyerService;
import com.callor.bank.service.BuyerServiceImplV1;

public class ExecA {

	public static void main(String[] args) {
		BuyerService buSer = new BuyerServiceImplV1();
		buSer.inputBuyer();
	}
}

package com.callor.bank.exec;

import com.callor.bank.service.AccService;
import com.callor.bank.service.impl.AccServiceImplV1;

public class AccExecA {

	public static void main(String[] args) {
		AccService accSer = new AccServiceImplV1();
		accSer.selectAll();
	}
}

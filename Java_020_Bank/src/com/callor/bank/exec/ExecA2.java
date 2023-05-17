package com.callor.bank.exec;

import java.io.PrintWriter;

import com.callor.bank.service.BuyerService;
import com.callor.bank.service.BuyerServiceImplV1a;

public class ExecA2 {

	public static void main(String[] args) {
		BuyerService buSer = new BuyerServiceImplV1a();
		buSer.inputBuyer();
		
		/*
		 * pirntBuyerList() 에 전달할 출력방향을 화면으로 지정하여 전달
		 * PrintWriter out = new PrintWriter(System.out);
		 * 
		 * OutputStream os = new FileOutputStream("내파일");
		 * PrintWriter out = new PrintWriter(os);
		 */
		buSer.printBuyerList();
		PrintWriter out = new PrintWriter(System.out);
		buSer.printBuyerList(out);
		out.close();
	}
}

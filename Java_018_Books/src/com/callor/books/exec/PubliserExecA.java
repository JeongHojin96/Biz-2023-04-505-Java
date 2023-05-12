package com.callor.books.exec;

import com.callor.books.service.PubliserService;
import com.callor.books.service.impl.PubliserServiceImplV1;

public class PubliserExecA {

	public static void main(String[] args) {
		PubliserService pubSer = new PubliserServiceImplV1();
		
		pubSer.loadPubliser();
		pubSer.printPubliserList();
		pubSer.getPubliserListByName("미디어");
	}
}

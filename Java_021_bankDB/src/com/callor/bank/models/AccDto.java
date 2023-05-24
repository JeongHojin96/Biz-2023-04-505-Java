package com.callor.bank.models;

/*
 * 데이터 클래스는
 * 각 method 간에 데이터를 묶음으로 담아 전달하기 위한 목적의 객체
 */
public class AccDto {

	public String acNum; // VARCHAR2(10)
	public String acDiv; // VARCHAR2(1)
	public String acBuId; // VARCHAR2(5)
	public int acBalance; // NUMBER
	
	public AccDto() {
		super();
	}

	public AccDto(String acNum, String acDiv, String acBuId, int acBalance) {
		super();
		this.acNum = acNum;
		this.acDiv = acDiv;
		this.acBuId = acBuId;
		this.acBalance = acBalance;
	}

	public String toString() {
		return " ID : " + acBuId + " 계좌번호 : " + acNum + " 계좌구분 : " + acDiv + " 잔액 : " + acBalance + "\n";
	}
}

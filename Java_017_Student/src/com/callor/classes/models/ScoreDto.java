package com.callor.classes.models;

public class ScoreDto {
	
	public String stNum;
	public String stName;
	public	String stDept;
	public int scKor;
	public int scEng;
	public int scMath;
	public int scMusic;
	public int scArt;
	public int scSoftWare;
	public int scDataBase;
	public String set;
	
	
	public ScoreDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ScoreDto(String stNum, String stName, String stDept, int scKor, int scEng, int scMath, int scMusic,
			int scArt, int scSoftWare, int scDataBase) {
		super();
		this.stNum = stNum;
		this.stName = stName;
		this.stDept = stDept;
		this.scKor = scKor;
		this.scEng = scEng;
		this.scMath = scMath;
		this.scMusic = scMusic;
		this.scArt = scArt;
		this.scSoftWare = scSoftWare;
		this.scDataBase = scDataBase;
	}
	public String getStNum() {
		return stNum;
	}
	public void setStNum(String stNum) {
		this.stNum = stNum;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public String getStDept() {
		return stDept;
	}
	public void setStDept(String stDept) {
		this.stDept = stDept;
	}
	public int getScKor() {
		return scKor;
	}
	public void setScKor(int scKor) {
		this.scKor = scKor;
	}
	public int getScEng() {
		return scEng;
	}
	public void setScEng(int scEng) {
		this.scEng = scEng;
	}
	public int getScMath() {
		return scMath;
	}
	public void setScMath(int scMath) {
		this.scMath = scMath;
	}
	public int getScMusic() {
		return scMusic;
	}
	public void setScMusic(int scMusic) {
		this.scMusic = scMusic;
	}
	public int getScArt() {
		return scArt;
	}
	public void setScArt(int scArt) {
		this.scArt = scArt;
	}
	public int getScSoftWare() {
		return scSoftWare;
	}
	public void setScSoftWare(int scSoftWare) {
		this.scSoftWare = scSoftWare;
	}
	public int getScDataBase() {
		return scDataBase;
	}
	public void setScDataBase(int scDataBase) {
		this.scDataBase = scDataBase;
	}
	@Override
	public String toString() {
		return "ScoreDto [stNum=" + stNum + ", stName=" + stName + ", stDept=" + stDept + ", scKor=" + scKor
				+ ", scEng=" + scEng + ", scMath=" + scMath + ", scMusic=" + scMusic + ", scArt=" + scArt
				+ ", scSoftWare=" + scSoftWare + ", scDataBase=" + scDataBase + "]";
	}
	
	
}

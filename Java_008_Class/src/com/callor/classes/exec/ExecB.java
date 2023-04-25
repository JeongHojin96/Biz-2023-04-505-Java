package com.callor.classes.exec;

import com.callor.classes.model.ScoreDto;
import com.callor.classes.module.ServiceB;

public class ExecB {

	public static void main(String[] args) {
		/*
		 * ScoreDto 클래스를 사용하여 scoreDto 객체를 선언하고
		 * 생성자 method( ScoreDto() )를 사용하여
		 * 객체를 초기화(new) 한다.
		 * 
		 * scoreDto 객체를 초기화 하여
		 * 사용할 준비가 되면
		 * 
		 * scoreDto 객체를 초기화 하는 순간
		 * scoreDto 클래스에서 선언한 변수들(여기서는 9가지)을
		 * 모두 사용할 수 있도록 동시에 초기화 된다.
		 * 
		 */
		ScoreDto scoreDto = new ScoreDto();
		scoreDto.intKor = (int)(Math.random()*50)+51;
		scoreDto.intEng = (int)(Math.random()*50)+51;
		scoreDto.intMat = (int)(Math.random()*50)+51;
		scoreDto.intHis = (int)(Math.random()*50)+51;
		scoreDto.intMus = (int)(Math.random()*50)+51;
		scoreDto.intArt = (int)(Math.random()*50)+51;
		scoreDto.intSpo = (int)(Math.random()*50)+51;
		
		scoreDto.stNum = "0001";
		scoreDto.stName = "홍길동";
		ServiceB serB = new ServiceB();
		serB.score(scoreDto);
		
	}
}

package com.callor.classes.service;

import com.callor.classes.model.ScoreDto;

public class ScoreServiceA {

	public void scoreprint(ScoreDto score) {
		System.out.printf("%s	%s	%d	%d	%d	%d	%.2f\n",
				score.stNum, score.stName, score.scKor, score.scEng,
				score.scMath, score.getTotal(), score.getAvg());
	}

	public int getScore() {
		int score = (int) (Math.random() * 51) + 50;
		return score;
	}
//	public void add(ScoreDto subCode,ScoreDto name1, ScoreDto name2, ScoreDto name3) {
//		add += name1.subCode;
//		add += name2.subCode;
//		add += name2.subCode;
	

}

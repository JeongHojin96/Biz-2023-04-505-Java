package com.callor.score;

public class ScoreService {

	public void scoreprint(ScoreDto score) {
		System.out.printf("%5d	%5d	%5d	%5d	%5d	%5d	%5d	%5.2f\n", score.stNum, score.scKor, score.scEng, score.scMath,
				score.scMusic, score.scArt, score.getTotal(), score.getAvg());
	}

	public int getScore() {
		int score = (int) (Math.random() * 51) + 50;
		return score;
	}

}

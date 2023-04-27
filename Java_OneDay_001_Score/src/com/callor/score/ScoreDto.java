package com.callor.score;

public class ScoreDto {

	public int stNum;
	
	public int scKor;
	public int scEng;
	public int scMath;
	public int scMusic;
	public int scArt;
	
	public int getScore() {
		int score = (int) (Math.random() * 51) + 50;
		return score;
	}
	
	public int getTotal() {
		int total = this.scKor;
		total += this.scEng;
		total += this.scMath;
		total += this.scMath;
		total += this.scArt;
		return total;
	}
	
	public float getAvg() {
		float avg = (float)this.getTotal() / 5 ;
		return avg;
	}
	
	public void scoreprint(ScoreDto score) {
		System.out.printf("%5d	%5d	%5d	%5d	%5d	%5d	%5d	%5.2f\n",
				score.stNum, score.scKor, score.scEng,
				score.scMath, score.scMusic, score.scArt, score.getTotal(), score.getAvg());
	}
}

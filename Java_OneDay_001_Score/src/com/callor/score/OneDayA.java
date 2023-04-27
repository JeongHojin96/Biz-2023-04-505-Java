package com.callor.score;

public class OneDayA {
	public static void main(String[] args) {

		ScoreDto[] sDto = new ScoreDto[10];
		ScoreService scSer = new ScoreService();

		for (int i = 0; i < sDto.length; i++) {
			sDto[i] = new ScoreDto();
		}

		System.out.println("=".repeat(61));
		System.out.println("* 한울 고교 성적 리스트 *");
		System.out.println("=".repeat(61));
		System.out.println("학 번\t국 어\t영 어\t수 학\t음 악\t미 술\t총 점\t평 균");

		int sumKor = 0;
		int sumEng = 0;
		int sumMath = 0;
		int sumMusic = 0;
		int sumArt = 0;
		int sumSum = 0;
		for (int i = 0; i < sDto.length; i++) {
			sDto[i].stNum = 23001 + i;
			sDto[i].scKor = scSer.getScore();
			sDto[i].scEng = scSer.getScore();
			sDto[i].scMath = scSer.getScore();
			sDto[i].scMusic = scSer.getScore();
			sDto[i].scArt = scSer.getScore();
			scSer.scoreprint(sDto[i]);
			sumKor += sDto[i].scKor;
			sumEng += sDto[i].scEng;
			sumMath += sDto[i].scMath;
			sumMusic += sDto[i].scMusic;
			sumArt += sDto[i].scArt;
		}

		sumSum = sumKor + sumEng + sumMath + sumMusic + sumArt;
		float avgKor = (float) sumKor / 10;
		float avgEng = (float) sumEng / 10;
		float avgMath = (float) sumMath / 10;
		float avgMusic = (float) sumMusic / 10;
		float avgArt = (float) sumArt / 10;
		float avgAvg = (float) (sumSum) / 50;

		System.out.println("-".repeat(61));
		System.out.printf("총 점\t%5d\t%5d\t%5d\t%5d\t%5d\t%5d\n",
				sumKor, sumEng, sumMath, sumMusic, sumArt, sumSum);
		System.out.printf("평 균\t%5.2f\t%5.2f\t%5.2f\t%5.2f\t%5.2f\t\t%5.2f\n",
				avgKor, avgEng, avgMath, avgMusic, avgArt, avgAvg);
		System.out.println("=".repeat(61));

	}
}

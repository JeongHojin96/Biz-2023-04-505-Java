
import java.util.List;

public class PrintString {
	private final int BLACK_JACK_NUM = 21;
	private final int WINRATE = 2;
	private final double BLACK_JACK_WINRATE = 1.5;
	private final String BLACK_JACK = "BlackJack!";
	
	// 유저가 이긴 경우
	public void userWin(int userSum, int dealerSum, List<Integer> userCntCard, List<Integer> dealerCntCard, int money) {
		System.out.println("현재 카드 합 : " + userSum + "\t현재 보유 카드 : " + userCntCard);
		if (dealerSum > this.BLACK_JACK_NUM) {
			System.out.println("딜러 카드 합 : " + dealerSum + "\t딜러 보유 카드 : " + dealerCntCard + "(Bust!)");
		} else {
			System.out.println("딜러 카드 합 : " + dealerSum + "\t딜러 보유 카드 : " + dealerCntCard);
		}
		System.out.println("당신이 승리하였습니다.\t획득 금액 : " + (money * WINRATE));
	}
	
	// 유저가 진 경우
	public void userLose(int userSum, int dealerSum, List<Integer> userCntCard, List<Integer> dealerCntCard) {
		if (userSum > this.BLACK_JACK_NUM) {
			System.out.println("현재 카드 합 : " + userSum + "\t현재 보유 카드 : " + userCntCard + "(Bust!)");
		} else {
			System.out.println("현재 카드 합 : " + userSum + "\t현재 보유 카드 : " + userCntCard);
		}
		System.out.println("딜러 카드 합 : " + dealerSum + "\t딜러 보유 카드 : " + dealerCntCard);
		System.out.println("당신이 패배하였습니다.\t돈을 잃으셨습니다.");
	}
	
	// 유저가 비긴 경우
	public void userDraw(int userSum, int dealerSum, List<Integer> userCntCard, List<Integer> dealerCntCard,
			int money) {
		System.out.println("현재 카드 합 : " + userSum + "\t현재 보유 카드 : " + userCntCard);
		System.out.println("딜러 카드 합 : " + dealerSum + "\t딜러 보유 카드 : " + dealerCntCard);
		System.out.println("비겼습니다. 돈을 돌려드리겠습니다.\t획득 금액 : " + money);
	}
	
	// 현재 보유 카드 체크
	public void currentCheck(int userSum, int dealerSum, List<Integer> userCntCard, List<Integer> dealerCntCard) {
		System.out.println("현재 카드 합 : " + userSum + "\t현재 보유 카드 : " + userCntCard);
		System.out.println("딜러 카드 합 : " + dealerSum + "\t딜러 보유 카드 : " + dealerCntCard);
	}
	
	// 딜러 혹은 유저 BlackJack 여부 체크
	public void checkBlackJack(int userSum, int dealerSum, List<Integer> userCntCard, List<Integer> dealerCntCard, int money) {
		if ((userCntCard.contains(1) && userCntCard.contains(10))
				&& (dealerCntCard.contains(1) && dealerCntCard.contains(10))) {
			System.out.println("현재 카드 합 : " + this.BLACK_JACK + "\t현재 보유 카드 : " + userCntCard);
			System.out.println("딜러 카드 합 : " + this.BLACK_JACK + "\t딜러 보유 카드 : " + dealerCntCard);
			System.out.println("극악의 확률이네요. 비겼습니다.\t돈을 돌려드리겠습니다. 획득 금액 : " + money);
		} else if (userCntCard.contains(1) && userCntCard.contains(10)) {
			System.out.println("현재 카드 합 : " + this.BLACK_JACK + "\t현재 보유 카드 : " + userCntCard);
			System.out.println("딜러 카드 합 : " + dealerSum + "\t\t딜러 보유 카드 : " + dealerCntCard);
			System.out.println("BlackJack! 당신의 승리입니다.\t획득 상금 : " + (int)(money * BLACK_JACK_WINRATE));
		} else {
			System.out.println("현재 카드 합 : " + userSum + "\t\t현재 보유 카드 : " + userCntCard);
			System.out.println("딜러 카드 합 : " + this.BLACK_JACK + "\t딜러 보유 카드 : " + dealerCntCard);
			System.out.println("BlackJack! 당신의 패배입니다.\t돈을 잃으셨습니다.");
		}
	}
}

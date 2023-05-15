package blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BlackjackGame2 {
	private List<String> deck;
	private List<String> playerHand;
	private List<String> dealerHand;
	private int playerScore;
	private int dealerScore;
	private int playerCoin;
	private int dealerCoin;
	private Scanner scanner;

	public BlackjackGame2() {
		deck = new ArrayList<>();
		playerHand = new ArrayList<>();
		dealerHand = new ArrayList<>();
		playerScore = 0;
		dealerScore = 0;
		playerCoin = 5;
		dealerCoin = 5;
		scanner = new Scanner(System.in);
	}

	public void startGame() {
		System.out.println("* BlackJack *");

		boolean tokenOver = false;

		while (!tokenOver) {
			initializeDeck();
			shuffleDeck();
			initialDeal();

			boolean gameOver = false;

			System.out.println("-".repeat(30));
			while (!gameOver) {
				System.out.println("유저 손패 : " + playerHand + ", 점수: " + playerScore);
				System.out.println("딜러 손패 : " + dealerHand.get(0) + ", ?");

				if (playerScore == 21 || dealerScore == 21) {
					gameOver = true;
					showResult();
					break;
				}

				System.out.print("\n카드 받기 (Y/N/Q) ");
				String input = scanner.nextLine();

				if (input.equalsIgnoreCase("Y")) {
					hit(playerHand);
					calculateScore();
					if (playerScore > 21) {
						gameOver = true;
						showResult();
					}
				} else if (input.equalsIgnoreCase("N")) {
					gameOver = true;
					while (dealerScore < 17) {
						hit(dealerHand);
						calculateScore();
					}
					showResult();
				} else if (input.equalsIgnoreCase("Q")) {
					System.out.print("\n종료시 모든 코인을 잃습니다. (Y/N) ");
					input = scanner.nextLine();
					if (input.equalsIgnoreCase("Y")) {
						playerCoin = 0;
						gameOver = true;
						tokenOver = true;

					} else if (input.equalsIgnoreCase("N")) {

						gameOver = true;
						System.out.println("게임을 재시작 합니다");
					}
				}
			}
			if (playerCoin == 0) {
				System.out.println("\n유저 토큰 0\n");
				System.out.println("Game Over");
				tokenOver = true;

			} else if (dealerCoin == 0) {
				System.out.println("\n딜러 토큰 0\n");
				System.out.println("승리를 축하합니다.");
				tokenOver = true;
			}
			deck.clear();
			playerScore = 0;
			dealerScore = 0;
			playerHand.clear();
			dealerHand.clear();
		}
	}

	private void initializeDeck() {
		String[] suits = { "♠", "♥", "♦", "♣" };
		String[] ranks = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

		for (String suit : suits) {
			for (String rank : ranks) {
				deck.add(rank + suit);
			}
		}
	}

	private void shuffleDeck() {
		Random rand = new Random();
		for (int i = 0; i < deck.size(); i++) {
			int j = rand.nextInt(deck.size());
			String temp = deck.get(i);
			deck.set(i, deck.get(j));
			deck.set(j, temp);
		}
	}

	private void initialDeal() {
		hit(playerHand);
		hit(dealerHand);
		hit(playerHand);
		hit(dealerHand);
		calculateScore();
	}

	private void hit(List<String> hand) {
		String card = deck.remove(deck.size() - 1);
		hand.add(card);
	}

	private void calculateScore() {
		playerScore = calculateHandScore(playerHand);
		dealerScore = calculateHandScore(dealerHand);
	}

	private int calculateHandScore(List<String> hand) {
		int score = 0;
		int aceCount = 0;

		for (String card : hand) {
			String rank = card.substring(0, card.length() - 1);
			if (rank.equals("A")) {
				score += 11; // Ace는 일단 11로 계산합니다.
				aceCount++;
			} else if (rank.equals("K") || rank.equals("Q") || rank.equals("J")) {
				score += 10; // K, Q, J는 10으로 계산합니다.
			} else {
				score += Integer.parseInt(rank); // 숫자 카드는 해당 숫자로 계산합니다.
			}
		}

		// Ace가 있고 합이 21을 초과하면 Ace의 값을 1로 변경합니다.
		while (aceCount > 0 && score > 21) {
			score -= 10;
			aceCount--;
		}

		return score;
	}

	private void showResult() {
		System.out.println("유저 손패: " + playerHand + ", 점수: " + playerScore);
		System.out.println("딜러 손패: " + dealerHand + ", 점수: " + dealerScore);

		if (playerScore > 21) {
			playerCoin += -1;
			dealerCoin += 1;
			System.err.println("\n유저가 21을 넘겼습니다. 딜러 승!\n");
			System.out.println("남은 코인\n유저 : " + playerCoin + "\n딜러 : " + dealerCoin);
		} else if (dealerScore > 21) {
			playerCoin += 1;
			dealerCoin += -1;
			System.err.println("\n딜러가 21을 넘겼습니다. 유저 승리!\n");
			System.out.println("남은 코인\n유저 : " + playerCoin + "\n딜러 : " + dealerCoin);
		} else if (playerScore == dealerScore) {
			System.err.println("\n무승부입니다.\n");
			System.out.println("남은 코인\n유저 : " + playerCoin + "\n딜러 : " + dealerCoin);
		} else if (playerScore > dealerScore) {
			playerCoin += 1;
			dealerCoin += -1;
			System.err.println("\n유저 승리!\n");
			System.out.println("남은 코인\n유저 : " + playerCoin + "\n딜러 : " + dealerCoin);
		} else if (playerScore < dealerScore) {
			playerCoin += -1;
			dealerCoin += 1;
			System.err.println("\n딜러 승리!\n");
			System.out.println("남은 코인\n유저 : " + playerCoin + "\n딜러 : " + dealerCoin);
		}

	}

	public static void main(String[] args) {
		BlackjackGame2 game = new BlackjackGame2();
		game.startGame();
	}
}

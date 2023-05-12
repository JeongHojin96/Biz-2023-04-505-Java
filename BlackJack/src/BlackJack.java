import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BlackJack {
	// 싱글톤 시작
	private static BlackJack current;

	public static BlackJack getInstance() {
		if (current == null) {
			current = new BlackJack();
		}

		return current;
	}

	public static void freeInstance() {
		current = null;
	}

	private BlackJack() {
		super();
	}
	// 싱글톤 끝

	private Random random = new Random();
	private Scanner scan = new Scanner(System.in);
	private List<Integer> deck = new LinkedList<>();
	private List<Integer> userCntCard = new LinkedList<>();
	private List<Integer> dealerCntCard = new LinkedList<>();
	private int userSum = 0;
	private int dealerSum = 0;
	private int money = 0;
	private final int BLACK_JACK_NUM = 21;
	private final int DEALER_MIN_NUM = 17;

	// 게임 진행
	public void playGame() {
		int selectNum = 0;
		int outCount = 0;
		PrintString printResult = new PrintString();

		System.out.println("블랙잭에 오신 것을 환영합니다.");

		makeDeck();

		while (true) {
			System.out.println("1.게임 시작  2.게임 종료");
			selectNum = selectInput();
			if (selectNum == 1) {
				money = batting();
				System.out.println("★☆★☆★☆★☆게임을 시작합니다.☆★☆★☆★☆★");
				System.out.println("카드 두 장을 드리겠습니다.");
				drawTwoCard();
				if ((userCntCard.contains(1) && userCntCard.contains(10))
						|| (dealerCntCard.contains(1) && dealerCntCard.contains(10))) {
					printResult.checkBlackJack(userSum, dealerSum, userCntCard, dealerCntCard, money);
					break;
				}
				printResult.currentCheck(userSum, dealerSum, userCntCard, dealerCntCard);
				while (true) {
					System.out.println("1.hit  2.stay  3.도망간다");
					selectNum = selectInput();
					if (selectNum == 1 || selectNum == 2) {
						if (selectNum == 1) {
							hit();
							if (userSum > BLACK_JACK_NUM || dealerSum > BLACK_JACK_NUM) {
								hitResult(printResult);
								break;
							}
							printResult.currentCheck(userSum, dealerSum, userCntCard, dealerCntCard);
							continue;
						} else if (selectNum == 2) {
							stay();
							stayResult(printResult);
							break;
						}
					} else if (selectNum == 3) {
						System.out.println("들어올 땐 맘대로지만 나갈 땐 아니란다 ^.^");
						continue;
					} else {
						System.out.println("올바른 번호를 입력해 주세요.");
						continue;
					}
				}
				break;
			} else if (selectNum == 2) {
				if (outCount == 0) {
					System.out.println("나갈 수 없을껄요..? 게임을 진행해 주세요.");
				} else if (outCount == 1) {
					System.out.println("나갈 수 없다니까요! 순순히 플레이 하시죠.");
				} else if (outCount == 2) {
					System.out.println("정말 나가시려구요..?");
				} else {
					System.out.println("알았어요.. 잘 들어가세요.");
					break;
				}
				outCount++;
				continue;
			} else {
				System.out.println("올바른 번호를 입력해 주세요.");
				continue;
			}
		}
		scan.close();
	}

	// 카드 덱 만들기
	private void makeDeck() {
//		for (int i = 0; i < 30; i++) {
//			deck.add(i % 10 + 1);
//		}

//		블랙잭 확인용
		for (int i = 0; i < 2; i++) {
			deck.add(1);
			deck.add(10);
			deck.add(1);
		}

	}

	// scanner 입력값 메서드
	private int selectInput() {
		int selectNum;
		while (true) {
			try {
				selectNum = Integer.parseInt(scan.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("에러 원인 = " + e.getMessage());
				System.out.println("입력은 숫자로 하셔야 합니다! 번호를 다시 입력해 주세요.");
				continue;
			} catch (Exception e) {
				System.out.println("알 수 없는 입력이에요. 정확한 번호를 입력해 주세요.");
				continue;
			}
		}
		return selectNum;
	}

	// 돈 배팅
	private int batting() {
		while (true) {
			System.out.println("얼마를 배팅하시겠습니까? (최소 배팅액은 1000원입니다.)");
			try {
				money = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("에러 원인 = " + e.getMessage());
				System.out.println("입력은 숫자로 하셔야 합니다! 다시 입력해 주세요.");
				continue;
			} catch (Exception e) {
				System.out.println("알 수 없는 입력이에요. 숫자로 입력해 주세요.");
				continue;
			}
			if (0 < money && money < 1000) {
				System.out.println("최소 배팅액 이상을 입력해 주세요.");
				continue;
			} else if (money == 0) {
				System.out.println("배팅을 하셔야 참여하실 수 있습니다.");
				continue;
			} else if (money < 0) {
				System.out.println("돈 주시게요? ㅋㅋ 올바른 배팅액을 입력해 주세요.");
				continue;
			} else
				break;
		}
		return money;
	}

	// 게임 시작시 카드 2장을 먼저 뽑는 메서드
	private void drawTwoCard() {
		for (int i = 0; i < 2; i++) {
			int rand1 = deck.remove(random.nextInt(deck.size()));
			int rand2 = deck.remove(random.nextInt(deck.size()));
			userSum += rand1;
			dealerSum += rand2;
			userCntCard.add(rand1);
			dealerCntCard.add(rand2);
		}
	}

	// hit 구현
	private void hit() {
		int rand1 = deck.remove(random.nextInt(deck.size()));
		userCntCard.add(rand1);
		userSum += rand1;
		if (dealerSum < DEALER_MIN_NUM) {
			int rand2 = deck.remove(random.nextInt(deck.size()));
			dealerSum += rand2;
			dealerCntCard.add(rand2);
		}
	}

	// hit로 게임이 끝났을 경우 결과 출력 메서드
	private void hitResult(PrintString printResult) {
		if (userSum > BLACK_JACK_NUM) {
			printResult.userLose(userSum, dealerSum, userCntCard, dealerCntCard);
		} else if (dealerSum > BLACK_JACK_NUM) {
			printResult.userWin(userSum, dealerSum, userCntCard, dealerCntCard, money);
		}
	}

	// stay 구현
	private void stay() {
		while (dealerSum < DEALER_MIN_NUM) {
			int randCard = deck.remove(random.nextInt(deck.size()));
			dealerCntCard.add(randCard);
			dealerSum += randCard;
		}
	}

	// stay시 결과 출력 메서드
	private void stayResult(PrintString printResult) {
		if (dealerSum > BLACK_JACK_NUM) {
			printResult.userWin(userSum, dealerSum, userCntCard, dealerCntCard, money);
		} else if (userSum > dealerSum) {
			printResult.userWin(userSum, dealerSum, userCntCard, dealerCntCard, money);
		} else if (userSum == dealerSum) {
			printResult.userDraw(userSum, dealerSum, userCntCard, dealerCntCard, money);
		} else if (userSum < dealerSum) {
			printResult.userLose(userSum, dealerSum, userCntCard, dealerCntCard);
		}
	}
}

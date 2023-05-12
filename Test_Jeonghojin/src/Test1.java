
public class Test1 {

	public static void main(String[] args) {
		int testNum;
		for (testNum = 0; testNum < 100; testNum++) {
			int random = (int) (Math.random() * 100) + 1;
			if (random < 1 || random > 100) {
				System.out.println("테스트 횟수 : " + testNum);
				System.err.println("100 번 테스트를 수행하려고 하였으나 " + testNum + "번째에서 테스트를 실패함");
				break;
			}
		}
		System.out.println("테스트 횟수 : " + testNum);
		System.out.println("100 번 테스트 수행 결과 1 ~ 100까지 범위의 랜덤수를 만들어 내고 있음");
	}
}

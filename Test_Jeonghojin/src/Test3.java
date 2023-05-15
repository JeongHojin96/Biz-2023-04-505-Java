import java.util.ArrayList;
import java.util.List;

public class Test3 {

	public static void main(String[] args) {
		List<Integer> numList = new ArrayList<>();
		List<Integer> primeList = new ArrayList<>();
		int pCount = 0;
		int tCount = 0;
		int sPrime = 0;
		int[] nList = new int[30];
		for (int i = 0; i < 30; i++) {
			numList.add((int) (Math.random() * 51) + 50);
			nList[i] = numList.get(i);
		}
		for (int list : numList) {
			for (int i = 2; i < numList.size(); i++) {
				if (list % i == 0) {
					tCount = i;
				}
			}
			if (tCount == 0) {
				sPrime += list;
				pCount++;
				primeList.add(list);
			}
		}
		System.out.println("소수 개수 : " + pCount);
		System.out.println("소수의 합 : " + sPrime);
	}
}

package memo.exec;

import java.util.Scanner;

import memo.service.impl.MemoService;

public class MemoExec {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		MemoService memoService = new MemoService();
		System.out.println("	메모장");
		System.out.println("=".repeat(100));
		while (true) {
			System.out.println("	1. 작성메모 조회");
			System.out.println("	2. 일련번호로 작성글 조회");
			System.out.println("	3. 작성자로 작성글 조회");
			System.out.println("	4. 날짜로 작성글 조회");
			System.out.println("	5. 메모 작성");
			System.out.println("	6. 메모 수정");
			System.out.println("	7. 메모 삭제");
			System.out.println("	9. 종료");
			System.out.print("	업무 선택 >> ");
			String strSelect = scan.nextLine();

			int intSelect = 0;

			try {
				intSelect = Integer.valueOf(strSelect);
			} catch (Exception e) {
				System.out.printf("업무 선택을 잘못 하였습니다(%s).", strSelect);
				continue;
			}
			if (intSelect == 9)
				break;
			else if (intSelect == 1)
				memoService.printMemoList();
			else if (intSelect == 2)
				memoService.findBySeq();
			else if (intSelect == 3)
				memoService.findByWriter();
			else if (intSelect == 4)
				memoService.findByDate();
			else if (intSelect == 5)
				memoService.insertMemo();
			else if (intSelect == 6)
				memoService.update();
			else if (intSelect == 7)
				memoService.Delete();
		}
		System.out.println("업무종료");

	}
}

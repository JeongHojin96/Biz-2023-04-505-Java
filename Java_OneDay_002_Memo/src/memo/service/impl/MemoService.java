package memo.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import memo.models.MemoDto;

public class MemoService {

	protected final Scanner scan;
	protected final MemoSqlServiceImplV1 memoService;
	protected List<MemoDto> memoList;

	public MemoService() {
		scan = new Scanner(System.in);
		memoService = new MemoSqlServiceImplV1();
	}

	public void printMemoList() {
		memoList = memoService.selectAll();
		System.out.println("메모장 리스트");
		System.out.println("=".repeat(100));
		System.out.println("일련번호\t작성자\t작성일자\t제목\t내용");
		System.out.println("-".repeat(100));
		for (MemoDto dto : memoList) {
			System.out.printf("%s\t", dto.m_seq);
			System.out.printf("%s\t", dto.m_writer);
			System.out.printf("%s\t", dto.m_date);
			System.out.printf("%s\t", dto.m_subject);
			System.out.printf("%s\n", dto.m_content);
		}
		System.out.println("-".repeat(100));
	}

	public void findBySeq() {
		System.out.print("조회 일련번호 입력 >>");
		String strSeq = scan.nextLine();
		MemoDto memoDto = memoService.findBySeq(strSeq);
		if (memoDto == null) {
			System.out.println("일련번호 없음");
		} else {
			System.out.println(memoDto.toString());
		}
	}

	public void findByWriter() {
		System.out.print("조회 작성자 입력 >>");
		String strWriter = scan.nextLine();
		MemoDto memoDto = memoService.findByWriter(strWriter);
		if (memoDto == null) {
			System.out.println("작성자 없음");
		} else {
			System.out.println(memoDto.toString());
		}
	}

	public void findByDate() {
		while (true) {
			System.out.print("조회 날짜 입력 >>");
			String strDate = scan.nextLine();
			MemoDto memoDto = memoService.findBySeq(strDate);
			if (memoDto == null) {
				System.out.println("날짜 없음");
				continue;
			} else {
				System.out.println(memoDto.toString());
				break;
			}
		}
	}

	// m_seq, m_writer, m_date, m_subject, m_content
	public void insertMemo() {

		MemoDto memoDto = new MemoDto();

		System.out.println("메모 작성");
		System.out.println("=".repeat(100));

		System.out.println("작성자 >> ");
		String strWriter = scan.nextLine();
		memoDto.m_writer = strWriter;

		while (true) {
			System.out.println("제목(20자) >> ");
			String strSubject = scan.nextLine();
			if (strSubject.length() > 20)
				continue;
			else {
				memoDto.m_subject = strSubject;
				break;
			}
		}

		while (true) {
			System.out.println("내용(400자) >> ");
			String strContent = scan.nextLine();
			if (strContent.length() > 400)
				continue;
			else {
				memoDto.m_content = strContent;
				break;
			}
		}

		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat today = new SimpleDateFormat("YYYY-MM-dd");
		memoDto.m_date = today.format(date);

		memoService.insert(memoDto);

		System.out.println("작성완료");
	}

	public void update() {
		while (true) {
			System.out.println("수정할 글의 일련번호 입력 >> ");
			String strSeq = scan.nextLine();

			MemoDto memoDto = memoService.findBySeq(strSeq);
			if (memoDto == null) {
				System.out.printf("작성 정보 없음(%s)", strSeq);
				continue;
			}
			System.out.printf("일련번호 : %s\n", memoDto.m_seq);
			memoDto.m_seq = Integer.valueOf(strSeq);

			while (true) {
				System.out.printf("작성자 : %s  >> ", memoDto.m_writer);
				String strWriter = scan.nextLine();
				if (!strWriter.equals("")) {
					memoDto.m_writer = strWriter;
					break;
				} else if (strWriter.length() > 20) {
					System.out.println("20자 초과 다시 입력");
					continue;
				}
			}

			while (true) {
				System.out.printf("제목 : %s >>  ", memoDto.m_subject);
				String strSubject = scan.nextLine();
				if (!strSubject.equals("")) {
					memoDto.m_writer = strSubject;
					break;
				} else if (strSubject.length() > 20) {
					System.out.println("20자 초과 다시 입력");
					continue;
				}
			}

			while (true) {
				System.out.printf("내용 : %s >> ", memoDto.m_content);
				String strContent = scan.nextLine();
				if (!strContent.equals("")) {
					memoDto.m_writer = strContent;
					break;
				} else if (strContent.length() > 400) {
					System.out.println("400자 초과 다시 입력");
					continue;
				}
			}
			int result = memoService.update(memoDto);
			if (result > 0)
				System.out.println("완료");
			else
				System.out.println("실패");
			break;
		}
	}

	public void Delete() {

		while (true) {
			System.out.println("수정할 글의 일련번호 입력 >> ");
			String strSeq = scan.nextLine();

			MemoDto memoDto = memoService.findBySeq(strSeq);
			if (memoDto == null) {
				System.out.printf("작성 정보 없음(%s)", strSeq);
				continue;
			} else {
				System.out.println(memoDto.toString());
				System.out.println("정말 삭제?? [YES / NO] >> ");
				String yesNo = scan.nextLine();
				if (yesNo.equals("YES")) {
					int result = memoService.delete(strSeq);
					if (result > 0) {
						System.out.println("완료");
						break;
					} else
						System.out.println("실패");
				} else {
					System.out.println("취소");
					break;
				}
			}
		}
	}

}
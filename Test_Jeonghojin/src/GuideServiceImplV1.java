import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GuideServiceImplV1 implements GuideService {

	protected List<GuideDto> guideList;

	public GuideServiceImplV1() {
		guideList = new ArrayList<>();
	}

	public void loadGuid() {
		String guideFile = "src/guide.txt";
		InputStream is = null;
		Scanner scan = null;
		try {
			is = new FileInputStream(guideFile);
		} catch (FileNotFoundException e) {
			System.out.println(guideFile + " 이 없습니다.");
			return;
		}
		scan = new Scanner(is);
		while (scan.hasNext()) {
			String line = scan.nextLine();
			String[] guide = line.split(",");

			GuideDto guDto = new GuideDto();

			guDto.setId(guide[0]);
			guDto.setList(guide[1]);
			guDto.setSEQ(guide[2]);
			guDto.setGuid(guide[3]);

			guideList.add(guDto);
		}
		scan.close();
	}

	public void printGuideList() {
		System.out.println("=".repeat(150));
		System.out.println("id\t종목명\t순서\t방법");
		for (GuideDto dto : guideList) {
			if(Integer.valueOf(dto.getSEQ()) == 1) {
				System.out.println("-".repeat(150));
			}
			System.out.printf("%s\t", dto.getId());
			System.out.printf("%s\t", dto.getList());
			
			System.out.printf("%s 회\t", dto.getSEQ());
			System.out.printf("%s\n", dto.getGuid());
			
		}
		System.out.println("=".repeat(150));
	}

}

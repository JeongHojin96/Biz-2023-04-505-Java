
public class Test2 {
public static void main(String[] args) {
	GuideService gsi = new GuideServiceImplV1();
	gsi.loadGuid();
	gsi.printGuideList();
}
}

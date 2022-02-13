
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainEntry {
	static String title, category, lendName;
	static String lendDate;
	static boolean lend;

	public static void main(String[] args) {
		VideoController vc = new VideoController();
		 Scanner input = new Scanner(System.in);

		try {
			while (true) {
				menu();
				int num = input.nextInt();

				try {
					switch (num) {
					case 1:
						insertVideo();

						if (lend) { // 대여여부가 true일 경우
							insertLendInfo();
							vc.addVideo2(title, category, lend, lendName, lendDate);
						} else {
							vc.addVideo1(title, category, lend);
						}
						break;

					case 2:
						System.out.print("수정할 비디오 제목을 입력하세요: ");
						String oldTitle = inputTitle();
						if(vc.getVideoInfo(oldTitle)) {
							insertVideo();
							if (lend) { // 대여여부가 true일 경우
								insertLendInfo();
								vc.modifyVideo2(oldTitle,title, category, lend, lendName, lendDate);
							} else {
								vc.modifyVideo1(oldTitle,title, category, lend);
							}
						}
						
						break;
					case 3:
						System.out.print("삭제할 비디오 제목을 입력하세요: ");
						String target = inputTitle();
						if(vc.getVideoInfo(target)) {
							vc.removeVideo(target);
							System.out.println("삭제되었습니다. ");
						}
						
						break;
					case 4:
						vc.print();
						break;

					case 5:
						System.out.println("시스템을 종료합니다.");
						System.exit(0);
						break;
					}
				} catch (Exception e) {
					System.out.println("유효하지 않는 정보입니다. 시스템을 종료합니다.");
				}
			}
		} catch (Exception e) {
			System.out.println("에러! 시스템을 종료합니다.");
		}

	}

	public static void menu() {
		System.out.println("\n ---- [ 비디오 정보 관리 ] ----");
		System.out.println(" 1. 추가 |  2. 수정 | 3. 삭제 | 4. 출력 | 5. 종료");
	}

	public static void insertVideo() {
		Scanner sc = new Scanner(System.in);

		System.out.print("제목 = ");
		title = sc.nextLine();
		System.out.print("장르 = ");
		category = sc.nextLine();
		System.out.print("대여 여부(T/F)= ");
		String temp = sc.nextLine();
		lend = temp.equals("T") ? true : false;

	}

	public static void insertLendInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.print("대여자 이름 = ");
		lendName = sc.nextLine();
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		lendDate = sdf.format(today);
		System.out.print("대여 날짜 = " + lendDate);
		System.out.println();
	}
	
	public static String inputTitle() {
		Scanner sc = new Scanner(System.in);
		String find = sc.nextLine();
		return find;
	}
}

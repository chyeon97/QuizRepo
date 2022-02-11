

import java.util.Scanner;

public class MainEntry {
	static String name, sex;
	static double tall, weight;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		BMIController bc = new BMIController();

		
		try {
			while(true) {
				try {
					menu();
					int num = sc.nextInt();
					
					switch(num) {
					case 1:
						insertInfo();
						bc.addInfo(name, sex, tall, weight);
						break;
					case 2:
						System.out.print("삭제할 ID: ");
						int targetId = sc.nextInt();
						bc.rmvInfo(targetId);
						System.out.println(targetId + "번 정보를 삭제합니다.");
						break;
					case 3:
						bc.print();
						break;
					
					case 4:
						bc.storeFile();	
						break;
						
					case 5:
						bc.readFile();
						break;
					case 6:
						System.out.println("시스템을 종료합니다.");
						System.exit(0);

						break;
					}
					
				}catch(Exception e) {
					System.out.println("유효하지 않는 정보입니다. ");
					
				}
			}
			
		}catch(Exception e) {
			System.out.println("에러발생! 시스템을 종료합니다. ");
			
		}
		
	}
	
	
	private static void insertInfo() {
		System.out.println(" ----- 정보 입력 -----");
		System.out.print("이름: "); name = sc.next();
		System.out.print("성별(남/여): "); sex = sc.next();
		System.out.print("신장(cm): "); tall = sc.nextDouble();
		System.out.print("체중(kg): "); weight = sc.nextDouble();
	}


	public static void menu() {
		System.out.println("\n ---- [ 상태 정보 관리 ] ----");
		System.out.println(" 1. 추가 |  2. 삭제 | 3. 출력 | 4. 파일 저장 | 5. 파일 불러오기 | 6. 종료");
	}
}

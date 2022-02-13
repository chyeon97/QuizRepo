


public class Video {
	String title;
	String category;
	boolean lend;
	String lendName;
	String lendDate; 
	
	
	Video(){
		
	}
	
	Video(String title, String category, boolean lend){
		this.title = title;
		this.category = category;
		this.lend = lend;
	}
	
	Video(String title, String category, boolean lend,String lendName, String lendDate){
		this(title,category,lend);
		this.lendName = lendName;
		this.lendDate = lendDate;
	}
	
	public String state(boolean lend) {
		String result = "";
		result = lend ? "대여중" : "미대여";
		return result;
	}
	
	public void display() {
		System.out.println(" ---------- ---------- ----------");
		System.out.print("비디오 제목:" + title + " " + "장르: " + category + " " + "대여여부: " + state(lend));
		System.out.println();
		
		// 대여중이라면 출력되는 요소
		if(lend) {
			System.out.print("대여자 이름: " + lendName + " " + "대여 날짜: "+ lendDate);
		}
		System.out.println();
	}
}

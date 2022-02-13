

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class VideoController extends Video {
	HashMap<String, Video> map = new HashMap<String, Video>();
	
	// 추가(미대여)
	public void addVideo1(String title, String category, boolean lend) {
		Video v = new Video(title,category,lend);
		map.put(title, v);
	}
	
	// 추가(대여)
	public void addVideo2(String title, String category, boolean lend, String lendName, String lendDate) {
		Video v= new Video(title, category, lend, lendName, lendDate);
		map.put(title, v);
	}
	
	// key 포함 여부 판단 메서드
	public boolean getVideoInfo(String title) {
		if(map.containsKey(title)) {
			System.out.println(title + "의 비디오 정보를 변경합니다.");
			return true;
		}else {
			System.out.println("입력하신 비디오를 찾을수 없습니다.");
			return false;
		}
	}
	
	// 수정(미대여)
	public void modifyVideo1(String oldTitle, String title, String category, boolean lend) {
		Video v = new Video(title, category, lend);
		map.replace(oldTitle, v);
		
	}
	// 수정(대여)
	public void modifyVideo2(String oldTitle, String title, String category, boolean lend, String lendName, String lendDate) {
		Video v = new Video(title, category, lend, lendName, lendDate);
		map.replace(oldTitle, v);
		
	}
	
	// 삭제 
	public void removeVideo(String target) {
		map.remove(target);
	}


	// 출력 
	public void print() {
		System.out.printf(" === << 모든 비디오 정보(%d) >> === \n",map.size());

		Set set = map.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			map.get(e.getKey()).display();
		}
		System.out.println();
		System.out.println(" ===================================");
	}
}

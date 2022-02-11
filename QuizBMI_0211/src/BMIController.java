

import java.io.*;
import java.util.ArrayList;

public class BMIController extends BMI {
	ArrayList<BMI> list = new ArrayList<BMI>();
	
	// 추가
	public void addInfo(String name, String sex, double tall, double weight) {
		double bmi = calcBMI(sex, tall, weight);
		BMI b = new BMI(list.size()+1, name, sex,tall, weight, bmi, calcState(bmi));
		list.add(b);
	}
		
	// BMI 수치 계산
	public double calcBMI(String sex, double tall, double weight) {
		if(sex.equals("남")) return (weight / ((tall /100.0) * (tall /100.0))) * 0.9; 
		else  return (weight / ((tall /100.0) * (tall /100.0))) * 0.85;
		
	}
	
	// 상태 계산
	public String calcState(double bmi) {
		if(bmi >= 25.0) return "비만";
		else if(bmi >=23.0 && bmi <25) return "과체중";
		else if(bmi >= 18.5 && bmi < 23) return "정상";
		else return "저체중";
	}
	
	// 삭제
	public void rmvInfo(int targetId) {
		list.remove(targetId-1);
	}
	
	// 출력
	public void print() {
		System.out.printf(" === << 모든 상태 정보(%d) >> === \n",list.size());
		for(int i=0; i<list.size(); i++) {
			list.get(i).display();
		}
		System.out.println();
	}
	
	
	// File에 저장  
	public void storeFile(){
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("BMI.txt"));
			oos.writeObject(list);
			oos.close();
			System.out.println("파일 저장 완료!");
			
		}catch(Exception e) {
			System.out.println("에러발생!");
		}

	}
	
	// File 불러오기
	public void readFile() {
		try {
			ObjectInputStream oos = new ObjectInputStream(new FileInputStream("BMI.txt"));
			
			ArrayList<BMI> tmp = (ArrayList)oos.readObject();
			for(int i =0; i<tmp.size(); i++) {
				tmp.get(i).display();
			}
			oos.close();
		}catch(Exception e) {
			System.out.println("에러발생!");
		}
	}

}

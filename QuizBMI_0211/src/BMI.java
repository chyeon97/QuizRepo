

import java.io.Serializable;

public class BMI implements Serializable {
	protected int id;
	protected String name, state, sex ; // 성명, 상태, 성별
	protected double tall, weight, bmi =0; // 키, 몸무게, bmi수치
	
	public double getTall() {
		return tall;
	}

	public void setTall(double tall) {
		this.tall = tall;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	BMI(){}
	
	BMI(int id, String name, String sex, double tall, double weight, double bmi, String state) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.tall = tall;
		this.weight = weight;
		this.bmi = bmi;
		this.state = state;
	}
	
	public void display() {
		System.out.print("ID = " + id + ", 이름 = " + name + ", 성별 = " +sex+", BMI = " + String.format("%.2f", bmi) + ", 상태 = " +state +"\n");
		
	}
	
	
	
}

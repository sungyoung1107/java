package oop1;

public class Car {
	
	public String name;
	public String color;
	public int size;
	
	// 생성자(클래스의 명칭과 동일하게) --> 리턴타입은 존재하지 않는다! 
	
	public Car(){
		this.name = "k1";
		this.color = "red";
		this.size = 1000;
	}
	
	public Car(String name, String color, int size){
		this.name = name;
		this.color = color;
		this.size = size;
	}
	
	public void go() {
//		System.out.println(this.name + " Go Car ...");
		System.out.printf("%s, %s Go Car ...\n", this.name, this.color);
	}
	
	public void stop() {
//		System.out.println(this.name + " Stop Car ...");
		System.out.printf("%s, %s Stop Car ...\n", this.name, this.color);
	}

}

package statics;

public class Test {
	
	public static void main(String []args) {
		Car c1= new Car("k1", "kia");
		System.out.println(c1); //static 필드 없음
		
		Car c2= new Car("k1", Car.makerName);
		System.out.println(c2); //static은 클래스 것이지 객체가 관여하는 것이 아니다
	}
}

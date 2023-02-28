package oop1;

public class App2 {

	public static void main(String[] args) {
		
		Car car1 = new Car("k2", "blue", 2000); // 오른쪽 실행되어서 왼쪽으로 들어간다.
		// 특정 자동차 초기화
		
		car1.go();
		car1.stop();
//		System.out.println("car1는 "+ car1.name + ", " + car1.color +", " + car1.size);
		System.out.print(System.identityHashCode(car1));
		
		System.out.println("------------------------");
		
		Car car2= new Car("k3", "white", 3000);
		car2.go();
		car2.stop();
		car2.color="green";
//		System.out.println("car2는 "+ car2.name + ", " + car2.color +", " + car2.size);
		System.out.print(System.identityHashCode(car2));
		
		System.out.println("------------------------");
//		
//		car1.go();
//		car1.stop();
		

	}

}

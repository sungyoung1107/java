package aggregation;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human human = new Human("James");
		System.out.println(human);
		
		Car car = new Car("k1", "red", 1000);
		human.setCar(car);
		System.out.println(human);
		
		human.drive(); // 사람에게 자동차 운전 시키기
		human.stopCar(); // 사람에게 자동차 멈추게 하기
		
	}

}

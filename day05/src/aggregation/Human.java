package aggregation;

public class Human {

	private String name;
	private Car car ; // 사람은 car를 가지고 있다. 없는 사람도 있다.
	
	public Human() {
	}
	
	public Human(String name) {
		this.name = name;
	}

	public Human(String name, Car car) {
		this.name = name;
		this.car = car;
	}
	
	@Override
	public String toString() {
		return "Human [name=" + name + ", car=" + car + "]";
	}
	
	/// aggregation
	
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
	public void drive() {
		car.go();
	}
	
	public void stopCar() {
		car.stop();
	}


}

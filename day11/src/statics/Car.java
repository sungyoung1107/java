package statics;

public class Car {
	
	private String name;
	private String maker;
	public static String makerName = "HD"; // 객체가 생성될 때 관여하지 않음
	
	public Car() {
		
	}
	
	public Car(String name) {
		this.name = name;
	}
	
	public Car(String name, String maker) {
		this.name = name;
		this.maker = maker;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Car [name=").append(name).append(", maker=").append(maker).append("]");
		return builder.toString();
	}

}

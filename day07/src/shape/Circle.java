package shape;

public class Circle extends Shape{
	
	double radius;

	public Circle() {
	}

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return radius * radius * Math.PI;
	}

	@Override
	public double getCircumn() {
		// TODO Auto-generated method stub
		return Math.PI * radius * 2;
	}

}

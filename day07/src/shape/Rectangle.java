package shape;

public class Rectangle extends Shape {

	double width;
	double height;
	
	public Rectangle() {
	}

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	public Rectangle(int x, int y, double width, double height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return width * height;
	}

	@Override
	public double getCircumn() {
		// TODO Auto-generated method stub
		return (width + height) * 2;
	}
	
	

}

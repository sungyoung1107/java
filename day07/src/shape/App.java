package shape;

public class App {

	public static void main(String[] args) {
		// shape는 객체 생성 불가 (abstract)
		
		// abstract 자식으로부터 객체 생성 가능
		Shape s1 = new Rectangle(10, 20, 100, 80); 
		System.out.println(s1.getXY());
		System.out.println(s1.getArea());
		System.out.println(s1.getCircumn());

	}

}

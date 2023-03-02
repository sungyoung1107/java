package overLoading;

import access.Employee;

public class App {

	public static void main(String[] args) {
		Calculator c = new Calculator();
		System.out.println(c.sum2(10, 20));
		System.out.println(c.sum3(10, 20, 30));
		System.out.println(c.sum3(10, 20, 30, 40));
		
		Employee e = new Employee();
		
	}

}

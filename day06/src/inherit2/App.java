package inherit2;

public class App {

	public static void main(String[] args) {
		Employee e = new Employee("100", "james", 500);
		System.out.println(e);
		System.out.println(e.getAnnSalary());
		
		Manager m = new Manager("200","Kim", 500, 50);
		System.out.println(m);
		System.out.println(m.getAnnSalary());
	
	}

}

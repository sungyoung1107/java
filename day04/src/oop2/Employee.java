package oop2;

//import java.util.Calendar;
import java.util.Random;

public class Employee {
	private String id; // 초기 생성자 만들 때만 할당할 수 있음
	private String name; // 초기 생성자 만들 때만 할당할 수 있음
	private int salary; // 초기 생성자 만들 때만 할당할 수 있음
	
	//default constructor
	public Employee() {};
	
//	public Employee() {
//		this.id = "temp0001";
//		this.name = "temp";
//		this.salary = 10000000;
//	}
	
	public Employee(String name, int salary) {
		this("0000", name, salary); // 다른 생성자를 호출한다. 다만 argument는 정확하게 써줘야 한다.
//		Random r = new Random();
//		this.id = String.valueOf(r.nextInt(100)+1);
		this.name = name;
		this.salary = salary;
		
	
	}

	public Employee(String id, String name, int salary) {	
		this.id = id;
		this.name = name;
		
		if (salary < 0) {
			this.salary = 0;
		}else {
			this.salary = salary;
		}
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAnnSalary() {
		return this.salary*12;
	}
	
	public double getTax() {
		return this.salary*0.175;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
}

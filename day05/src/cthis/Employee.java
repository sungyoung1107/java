package cthis;

import java.util.Calendar;

public class Employee {
	private String id;
	private String name;
	private int salary;
	
	public Employee() {
		Calendar cal = Calendar.getInstance();
		this.id = ""+cal.get(Calendar.YEAR) + cal.get(Calendar.MILLISECOND); // INT->String
//		this.id = String.valueOf(cal.get(Calendar.YEAR));
	}
	
	public Employee(String name, int salary) {
		this(); // 위에 생성자 호출, 맨 위에만!!!!!
		this.name = name;
		this.salary = salary;
	}

	public Employee(String id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	//getter & setter
	public double getTax() {
		double result = 0.0;
		result = this.salary * 0.17;
		return result;
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

	public int getSalary() {
		return salary;
	}

	public int getAnnSalary() {
		int result = 0;
		result = this.salary*12;
		return result;
	}
	
	public double getAnnTax() {
		double result = 0.0;
		result = this.getAnnSalary()*0.17;
		return result;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	

}

package ws0228;

public class Employee {

	private String name ;
	private int salary ;
	
	public Employee() {
		
	}
	
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	// 이름 반환
	public String getName() {
		return name;
	}
	
	// 급여 반환
	public int getSalary() {
	     return salary;
	}
	
	// 연봉 반환
	public double getAnnSalary() {
		return (salary*12);
	}
	
	// 세금 반환
	public double getTax() {
		return ((salary*12) * 0.175);
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}
	
}

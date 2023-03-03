package inherit2;

public class Manager extends Employee{
	// 필드와 메소드가 상속되었다!
	
	private double bonus = 0.0;

	public Manager(double bonus) {
		this.bonus = bonus;
	}

	public Manager(String id, String name, double salary, double bonus) {
		super(id, name, salary);
		this.bonus = bonus;
	}

	public Manager() {
		super(); // 위에 있는 것 상속
		// TODO Auto-generated constructor stub
	}

	public Manager(String id, String name, double salary) {
		super(id, name, salary); // 위에 있는 것 상속
		// TODO Auto-generated constructor stub
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	// 함수의 재정의(overriding)
	@Override // annotation
	public double getAnnSalary() {
		// TODO Auto-generated method stub
		double result = 0.0;
//		result = (this.getSalary() + this.bonus) *12 ;
		result = super.getAnnSalary() + (this.bonus * 12);
		return result;
	}

//	@Override
//	public String toString() {
//		return "Manager [bonus=" + bonus + ", toString()=" + super.toString() + "]";
//	}
	
	public String toString() {
		return super.toString()+ " " + bonus;
	}
	
	
}

package ws0228;

public class Manager {
	
	private String name;
	private int salary;
	private int bonus;
	
	public Manager() {
		
	}
	
	public Manager(String name, int salary, int bonus) {
		this.name = name;
		this.salary = salary;
		this.bonus = bonus;
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
		return (salary * 12) + bonus;
	}

	// 보너스 반환
	public int getBonus() {
		return bonus;
	}

	// 세금 반환
	public double getTax() {
		return ((salary*12) + (bonus)) * 0.175; // 정수 * 실수 = 실수
	}

	@Override
	public String toString() {
		return "Manager [name=" + name + ", salary=" + salary + ", bonus=" + bonus + "]";
	}

}

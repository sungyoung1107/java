package com.kbstar.hrd;

public class Manager {
	String id;
	String name;
	int salary;
	int bonus;
	
	public Manager() {
	}

	public Manager(String id, String name, int salary, int bonus) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.bonus = bonus;
	}
	
	public double getTax() {
		double result;
		result = (this.salary + this.bonus)*0.17;
		return result;
	}
	
	public int getAnnsSalary() {
		int result;
		result = (this.salary + this.bonus)*12;
		return result;
	}
	
	public double getAnnTax() {
		double result;
		result = this.getAnnsSalary()*0.17;
		return result;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", salary=" + salary + ", bonus=" + bonus + "]";
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

	public int getBonus() {
		return bonus;
	}
	
	
}

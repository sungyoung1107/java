package com.kbstar.hrd.app;
import java.util.Scanner;

import com.kbstar.hrd.Employee;
import com.kbstar.hrd.Manager;

public class App {

	public static void main(String[] args) {
		Employee e = new Employee("100", "이말숙", 500);
		System.out.println(e);
		System.out.println(e.getSalary());
		System.out.println(e.getTax());
		System.out.println(e.getAnnSalary());
		System.out.println(e.getAnnTax());
		
		System.out.println("========================================");
		
//		Employee emps[] = new Employee[3];
		Employee emps[];
		emps = new Employee[3];
		
		emps[0] = new Employee("200", "홍말자", 400); // 배열 안에 Employee 자료형
		emps[1] = new Employee("202", "정말자", 450);
		emps[2] = new Employee("203", "장말자", 480);
		
		for (Employee data : emps) {
			System.out.println(data);
			System.out.println(data.getTax());
			System.out.println(data.getAnnSalary());
			System.out.println(data.getAnnTax());
		}
	
	}

}

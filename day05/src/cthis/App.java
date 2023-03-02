package cthis;

import java.util.Date;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1 = new Employee("이종석", 500);
		System.out.println(e1);
		Employee e2 = new Employee("이말자", 900);
		System.out.println(e2);
		
		Date d = new Date();
		java.sql.Date dd = new java.sql.Date(0);
	}

}

package ws0228;

public class App {

	public static void main(String[] args) {

		Manager mgr[] = new Manager[5];  // Manager 객체 생성
		Employee em[] = new Employee[5]; // Employee 객체 생성
		
		double manager_annSalary_sum = 0;
		double employee_annSalary_sum = 0;
		
		mgr[0] = new Manager("김진희", 1000000, 100000);
		mgr[1] = new Manager("이성영", 2000000, 200000);
		mgr[2] = new Manager("정인보", 3000000, 300000);
		mgr[3] = new Manager("조현손", 4000000, 400000);
		mgr[4] = new Manager("김국민", 5000000, 500000);
		
		em[0] = new Employee("이뭉치", 1000000);
		em[1] = new Employee("송혜교", 2000000);
		em[2] = new Employee("아이유", 3000000);
		em[3] = new Employee("박서준", 4000000);
		em[4] = new Employee("김넛지", 5000000);

		System.out.println("Manager 기본 정보를 출력합니다. ");
		for (Manager data : mgr) {
			System.out.printf("매니저 이름은 %s 월급은 %d원 보너스는 %d원입니다. \n", data.getName(), data.getSalary(), data.getBonus());
		}
		
	    System.out.println();
	    System.out.println("Manager 상세 정보를 출력합니다. ");
		for (Manager data2 : mgr) {
			System.out.printf("매니저 이름은 %s \t", data2.getName());
			System.out.printf("연봉(보너스 포함)은 %.0f원 \t", data2.getAnnSalary()); // 연봉 계산식 호출
			System.out.printf("연봉에 대한 세금은 %.0f원입니다. \n", data2.getTax()); // 세금 계산식 호출 (반올림)
		}
		
	    System.out.println();
	    System.out.println("Manager 연봉 합계를 출력합니다. ");
	    for(Manager data2 : mgr) {
	    	manager_annSalary_sum+=data2.getAnnSalary();  // 연봉 계산식 호출
	    }
	    System.out.printf("Manager 연봉 합계는 %.0f원입니다. \n", manager_annSalary_sum);
		
	    ///////////////////////////////////////////////////////////////////////
	    
	    System.out.println();
	    System.out.println("Employee 기본 정보를 출력합니다. ");
	    for(Employee data: em) {
	    	System.out.printf("직원 이름은 %s 월급은 %d원입니다.\n", data.getName(), data.getSalary());
	    }
	    
	    System.out.println();
	    System.out.println("Employee 상세 정보를 출력합니다. ");
	    for(int i=0; i < em.length; i++) {
	    	System.out.printf("직원의 이름은 %s \t", em[i].getName());
	    	System.out.printf("연봉은 %.0f원 \t", em[i].getAnnSalary());  // 연봉 계산식 호출
	    	System.out.printf("연봉에 대한 세금은 %.0f원입니다. \n", em[i].getTax());    // 세금 계산식 호출 (반올림)
	    }
	    
	    System.out.println();
	    System.out.println("Employee 연봉 합계를 출력합니다. ");
	    for(int i=0; i < em.length; i++) {
	    	employee_annSalary_sum+=em[i].getAnnSalary();  // 연봉 계산식 호출
	    }
	    System.out.printf("Employee 연봉 합계는 %.0f원입니다. \n", employee_annSalary_sum);

	}
}

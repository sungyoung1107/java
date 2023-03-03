package inherit2;

public class App2 {

	public static void main(String[] args) {
			
		// 중요함
		Employee e = new Manager("100", "james", 500, 50); // 매니저는 직원이다.
//		Manager m = new Employee("100", "james", 500); // type mismatch
		
		Employee[] ea = new Employee[5]; // Employee들이 들어가는 배열
		ea[0] = new Employee("100", "james", 500);
		ea[1] = new Employee("101", "james", 500);
		ea[2] = new Manager("102", "james", 500, 50); // 다형성
		ea[3] = new Manager("103", "james", 500, 50); // 다형성
		ea[4] = new Sales("104", "jacob", 500, "seoul", 0.35);
		
		for(Employee data : ea) {
			System.out.println(data);
			System.out.println(data.getAnnSalary());
			System.out.println("인센티브는 "+ data.getIncentive());
		}
		
		System.out.println("-----------------------------");
		TaxCal t = new TaxCal();
		double result = t.getTax(ea[0]); //employee를 넣어서 해당 고객의 tax 반환
		System.out.println(result);
		
		result = t.getTax(ea[3]); // argument에 employee를 안넣고 manager를 넣어도 가능...!!!! 왜냐면 매니저는 직원이기 때문!
		System.out.println(result);
		
		result = t.getTax(ea[4]);
		System.out.println(result);
		
	}
				
//		Employee[4] emp ;		
//		emp = new Employee();

}

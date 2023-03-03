package inherit;

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
			
			// 상위 클래스를 잘 설계해야 하위 클래스에서 메소드를 재정의 할 수 있다.
			// 상위 클래스에 없는데, 하위 클래스에만 메소드를 추가하면 다형성을 사용할 수 없다.
			// 따라서 아래와 같이 해줘야 하위 클래스를 활용할 수 있다.
			if(data instanceof Sales) { // 배열에서 끄집어낸 객체가 Sales 타입이면
				Sales s = (Sales)data;
				System.out.println("인센티브는 "+ s.getIncentive());
			}
		}
	}
				
//		Employee[4] emp ;		
//		emp = new Employee();

}

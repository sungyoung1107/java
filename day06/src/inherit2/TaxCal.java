package inherit2;

public class TaxCal {
	
	public double getTax(Employee e) {
		double result = 0.0;
		result = e.getAnnSalary() * 0.17;
		return result;
	}
	
	// Employee가 Manager과 Sales를 다 포함
	
//	public double getTax(Manager e) {
//		double result = 0.0;
//		result = e.getAnnSalary() * 0.17;
//		return result;
//	}
//	
//	public double getTax(Sales e) {
//		double result = 0.0;
//		result = e.getAnnSalary() * 0.17;
//		return result;
//	}
	
	

}

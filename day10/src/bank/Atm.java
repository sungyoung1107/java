package bank;

public class Atm {

	public static void main(String[] args) {
		
		Account acc1 = null;
		
		try {
			acc1 = new Account(10000);
			System.out.println(acc1);
			acc1.widthdraw(-10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(MakeMessage.makeMessage(e.getMessage()));
		}
		
	}
}

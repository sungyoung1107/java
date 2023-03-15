package ws0302;

public class App {
	
	public static void main(String[] args) {
			
		double balanceVip = 0; // vip 잔액
		double avgVip = 0.0; // vip 평균
		int countVip = 0; // vip 카운팅
		
		Account[] acc = new Account[6]; // 6개의 Account 객체 배열 생성 
		acc[0] = new Account("james1", 10000, 0.35, "VIP");
		acc[1] = new Account("james2", 10000, 0.45, "GOLD");
		acc[2] = new Account("james3", 10000, 0.55, "SIVER");
		acc[3] = new Account("james4", 10000, 0.15, "GOLD");
		acc[4] = new Account("james5", 10000, 0.28, "SIVER");
		acc[5] = new Account("james6", 10000, 0.31, "VIP");
	
		System.out.println("== 안녕하십니까 고객님, KB국민은행에 오신 것을 환영합니다! ==");
		
		// 6개의 계좌 정보 출력
		for (Account data: acc) {
			System.out.println(data);
		}
		
		// 모든 계좌의 잔액과 현재 이자금액 출력
		for (Account data: acc) {
			System.out.printf("%s님 계좌 \'%s\'의 현재 잔액은 %.0f 입니다. ", 
					data.getAccName(), data.getAccNum(), data.getBalance());
			System.out.printf("%s님 계좌 \'%s\'의 연이자율은 %.2f 이고, 연이자금액(이자소득세제외)은 %.0f 입니다. \n",
					data.getAccName(), data.getAccNum(), data.getRate(), data.getInterest());
		}
		
		// vip들의 잔액의 합과 평균을 출력
		for (Account data: acc) {
			if (data.getGrade().equals("VIP")) {
				balanceVip+=data.getBalance();
				countVip++;
			}	
		}
		avgVip = balanceVip / countVip;	
		System.out.printf("VIP의 잔액의 합은 %.0f 이고, 평균은 %.2f 입니다.", balanceVip, avgVip);
	}

}

package ws0302;

import java.util.Random;

public class MakeAccountNumber {
	
	// KB국민은행 입출금계좌
	// 지점(4자리) + 02 + "-" + 01 + "-" + 임의숫자(6자리)
	public static String makeAccNum() {
		
		Random rd = new Random();
		
		String accNum = "";
		accNum = String.format("%04d", rd.nextInt(10000)) + 
				"02" + "-" + "01" + "-" + String.format("%06d", rd.nextInt(1000000)); 
		
		return accNum;
	}
}

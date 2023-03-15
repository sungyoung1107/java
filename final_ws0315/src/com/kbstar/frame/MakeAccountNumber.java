package com.kbstar.frame;

import java.util.Calendar;
import java.util.Random;

public class MakeAccountNumber {

	// KB국민은행 수신계좌: 지점(4자리) + 02 + "-" + 01 + "-" + 임의숫자(6자리)
	public static String makeAccNum() {

		Random rd = new Random();

		String accNum = "";
		accNum = String.format("%04d", rd.nextInt(10000)) + "02" + "-" + "01" + "-"
				+ String.format("%06d", rd.nextInt(1000000));
		return accNum;

	}
	//계좌이체 발생 시 건마다 발생할 id번호
	public static int cnt = 100;
	public static String makeTransIdNum() { //이체거래 id번호 생성 키워드
		
		String accNum = "";
		Calendar cal = Calendar.getInstance();
		accNum = "" + cal.get(Calendar.YEAR)
		            + (cal.get(Calendar.MONTH)+1)
		            + cal.get(Calendar.DAY_OF_MONTH)
		            + cal.get(Calendar.MILLISECOND)
		            + cnt;
		cnt++;
		return accNum;
	}

}
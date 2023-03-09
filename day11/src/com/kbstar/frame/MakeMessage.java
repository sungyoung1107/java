package com.kbstar.frame;

public class MakeMessage {
	
	public static String makeMessage(String code) {
		
		String result = "";
		
		switch(code) {
		
		case "ER0001": result = "계좌개설 실패..."; break;
		case "EX0002": result = "음수 입력.."; break;
		case "Ex0003": result = "잔액 부족.."; break;
		case "EX001" : result = "잘못된 상품 ID 입니다."; break;
		case "EX002" : result = "상품명은 10자리를 넘을 수 없습니다."; break;
		case "EX003" : result = "상품 가격은 0보다 커야 합니다."; break;
		case "EX004" : result = "상품 갯수는 0보다 커야 합니다."; break;
		
		
		default: result = "고객센터에 문의 하세요";
		
		}
		
		return result;
	}
		
}
package com.kbstar.app;

import com.kbstar.DAO.AccountMariaDBDAO;
import com.kbstar.DAO.AccountOracleDAO;
import com.kbstar.DAO.UserMariaDBDAO;
import com.kbstar.DTO.AccountDTO;
import com.kbstar.DTO.UserDTO;
import com.kbstar.frame.DAO;

public class App {
	
	public static void main(String[] args) {
		
//		DAO dao = new UserOracleDAO(); // 왼쪽 인터페이스 = 오른쪽 인터페이스를 상속한 클래스
//		UserDTO user = new UserDTO("id01", "pwd01", "james");
//		dao.insert(user); // UserDTO 객체를 넣어서 insert 한다.
		
//		DAO dao = new AccountOracleDAO();
//		AccountDTO account = new AccountDTO("100", "자유저축", 1000);
//		dao.insert(account);
		
		DAO account = new AccountMariaDBDAO();
		DAO user = new UserMariaDBDAO();
		
		AccountDTO account_dto = new AccountDTO("1", "2", 3);
		UserDTO user_dto = new UserDTO("1", "2", "3");
		
		account.insert(account_dto);
		user.insert(user_dto);
		
		
		
	}
}

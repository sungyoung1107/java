package com.kbstar.service;

import com.kbstar.DAO.UserDAO;
import com.kbstar.DTO.UserDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Service;

public class UserService implements Service<String, UserDTO> {
	
	DAO<String, UserDTO> dao;
	
	public UserService() {
		dao = new UserDAO();
	}

	@Override
	public void register(UserDTO v) throws Exception{
		System.out.println("Security Check...");
		try {
			dao.insert(v);
		} catch (Exception e) {
			throw e; // 다시 던지겠다!
		}
		System.out.println("Send mail..");
		System.out.println("Send SNS..");
	}
	
	@Override
	public void remove(String k) throws Exception { // 로그를 못찍음......
		try {
			dao.delete(k); // 여기서 exception 되면 밑에 실행 안됨
		} catch (Exception e) {
			throw e; // 다시 던지겠다!
		}
		
		System.out.println("Send SNS..");
		
	}
	
	@Override
	public void modify(UserDTO v) {
		try {
			dao.update(v);
		} catch (Exception e) {
			// 로그 찍기!!
			e.printStackTrace();
		}
		System.out.println("Send SNS..");	
	}
}
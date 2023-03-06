package com.kbstar.DAO;

import com.kbstar.frame.DAO;

public class UserMariaDBDAO implements DAO {

	@Override
	public void insert(Object obj) {
		System.out.println("마리아DB에 USER정보 INSERT... ");
		
	}

	@Override
	public void delete(Object obj) {
		System.out.println("마리아DB에 USER정보 DELETE... ");
		
	}

	@Override
	public void update(Object obj) {
		System.out.println("마리아DB에 USER정보 UPDATE... ");
		
	}

}

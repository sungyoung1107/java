package com.kbstar.DAO;

import com.kbstar.DTO.UserDTO;
import com.kbstar.frame.DAO;

// 상속받을 때 < > 안에 자료형을 넣는다.
public class UserDAO implements DAO<String, UserDTO>{

	@Override // UserDTO에 getId가 있음.
	public void insert(UserDTO v) {
		System.out.println(v.getId()+"님이 저장 되었습니다.");
	}

	@Override
	public void delete(String k) {
		System.out.println(k+"님이 삭제되었습니다.");
	}

	@Override
	public void update(UserDTO v) {
		System.out.println(v.getId()+"님의 정보가 수정되었습니다.");
		
	}


}

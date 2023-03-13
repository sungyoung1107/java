package com.kbstar.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.DAO;

public class UserDAO implements DAO<String, UserDTO>{
	
	HashMap<String, UserDTO> db;

	// 비즈니스 로직은 없고, 무조건 DB에 넣는 행위만 하는 함수이다 !!!
	
	public UserDAO() { // constructor에서 생성한다.
		db = new HashMap<String, UserDTO>();
//		db = new HashMap<>(); // 이것도 가능하다
	}
	
	@Override
	public void insert(UserDTO v) throws Exception {
		if(db.containsKey(v.getId())) {
			throw new Exception("DB error");
		}
		db.put(v.getId(), v);
	}

	@Override
	public void delete(String k) throws Exception {
		if(!db.containsKey(k)) {
			throw new Exception("");
		}
		db.remove(k);
	}

	@Override
	public void update(UserDTO v) throws Exception {
		if(!db.containsKey(v.getId())) {
			throw new Exception("");
		}
		db.put(v.getId(), v);
	}

	@Override
	public UserDTO select(String k) throws Exception {
		UserDTO obj = null;
		obj = db.get(k);
		return obj;
	}

	@Override
	public List<UserDTO> select() throws Exception {
		List<UserDTO> list = new ArrayList<UserDTO>(); //리스트 중 ArrayList에 담기 위해 객체를 생성한다.
		Collection<UserDTO> col = db.values(); // UserDTO 객체가 Collection 형태로 반환된다.
		for(UserDTO obj : col) { // UserDTO data를 한개씩 꺼낸다.
			list.add(obj); // ArrayList에 UserDTO를 한개씩 넣는다.
		}
		return list;
	}

	@Override
	public List<UserDTO> search(Object obj) throws Exception {
		List<UserDTO> list = new ArrayList<>();
		Collection<UserDTO> col = db.values();
		
		for(UserDTO user : col) {
			if (user.getId().equals(obj)) {
				list.add(user);
			}
		}
		
		return list;
	}
	

}

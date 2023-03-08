package com.kbstar.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.DAO;

public class UserDAO implements DAO<String, UserDTO>{
	
	// DB 선언
	HashMap<String, UserDTO> db = null;
	
	public UserDAO() {
		db = new HashMap();	
	}

	@Override
	public void insert(UserDTO v) throws Exception {
		
		if(db.containsKey(v.getId())){
			throw new Exception("ID "+v.getId() + "는 데이터가 이미 있습니다");
		}
		
		db.put(v.getId(), v); // id, UserDTO 객체 put
		
	}

	@Override
	public void update(UserDTO v) throws Exception {
		
		if(!db.containsKey(v.getId())){
			throw new Exception("ID "+v.getId() + "가 존재하지 않습니다");
		}
		
		UserDTO updateData = v;
		db.put(v.getId(), updateData);	
	}

	@Override
	public void delete(String k) throws Exception {
		
		if(!db.containsKey(k)) {
			throw new Exception("ID "+ k + "가 존재하지 않습니다");
		}
		
		db.remove(k);
		System.out.println("ID "+ k + "가 데이터가 삭제되었습니다. ");
	}

	@Override
	public UserDTO select(String k) throws Exception {
		
		if(!db.containsKey(k)) {
			throw new Exception("ID "+ k + "가 존재하지 않습니다");
		}
		
		UserDTO user = null;
		user = db.get(k);
		return user;
	}

	@Override
	public List<UserDTO> select() throws Exception {
		
		if(db.size()==0) {
			throw new Exception("데이터가 없습니다.");
		}
		
		List<UserDTO> list = new ArrayList<UserDTO>();
		Collection<UserDTO> col = db.values(); // Collection<UserDTO> 반환이 되며 이는 list와 set의 조상임	
		for(UserDTO u : col) {
			list.add(u);
		}
		return list;
	}


}

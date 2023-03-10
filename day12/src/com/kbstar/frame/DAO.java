package com.kbstar.frame;

import java.util.List;

public interface DAO <K, V>{
//	public void insert(UserDTO ut) throws Exception; 이렇게 하면 객체로 UserDTO밖에 안들어오니 class 옆에 제네릭으로 생성 
	// 데이터베이스의 입력, 삭제, 수정, 보기를 정의한 것이 DAO
	public void insert(V v) throws Exception;
	public void delete(K k) throws Exception;
	public void update(V v) throws Exception;
	public V select(K k) throws Exception;
	public List<V> select() throws Exception;	
	public List<V> search(Object obj) throws Exception;

}

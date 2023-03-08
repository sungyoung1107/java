package com.kbstar.frame;

import java.util.List;

public interface DAO<K, V> {
	
	// CRUD (Create, Read, Update, Delete)
	public void insert(V v) throws Exception;
	public void update(V v) throws Exception;
	public void delete(K k) throws Exception;
	public V select(K k) throws Exception; // 키 값 넣으면 객체 타입 반환해라!
	public List<V> select() throws Exception; // List에 담아 던질 것인데 V 객체 타입으로!!! 
	
}

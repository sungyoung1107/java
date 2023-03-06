package com.kbstar.frame;

// 제네릭으로 선언
public interface DAO <K, V> {
	
	public void insert(V v); // abstract 메소드 
	public void delete(K k); // abstract 메소드
	public void update(V v); // abstract 메소드

}

package com.kbstar.frame;

public interface DAO<K, V> {

	public static final String IP = "127.0.0.1"; // 인터페이스 안에 필드는 무조건 public static final 붙는다. 상수
	
	// 기능
	public void insert(V v); // abstract 생략되어 있는 것으로 { } 사용 불가
	public void delete(K k); // abstract 생략되어 있는 것으로 { } 사용 불가
	public void update(V v); // abstract 생략되어 있는 것으로 { } 사용 불가
	
	default void connect() {
		System.out.println(IP+"에 접속하였습니다. ");
	}
	
	default void close() {
		System.out.println(IP+"에 접속을 해제하였습니다. ");
	}
	
}

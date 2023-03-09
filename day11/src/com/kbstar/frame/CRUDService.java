package com.kbstar.frame;

import java.util.List;

public interface CRUDService<K, V> {
	// 사용자가 가입하고 탈퇴하고 하는 서비스를 정의
	public void register(V v) throws Exception;
	public void remove(K k) throws Exception;
	public void modify(V v) throws Exception;
	public V get(K k) throws Exception;
	public List<V> get() throws Exception;
}

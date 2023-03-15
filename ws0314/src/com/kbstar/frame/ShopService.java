package com.kbstar.frame;

import java.util.List;

public interface ShopService<V, C> {
	public V login(String id, String pwd) throws Exception; // 로그인

	public void register(V v) throws Exception; // 가입하기

	public List<C> myCart(String id) throws Exception; // 나의 카트조회
}

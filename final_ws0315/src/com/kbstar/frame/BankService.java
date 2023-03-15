package com.kbstar.frame;

import java.util.List;

public interface BankService<V1, V2, V3, K, P> { // UserDTO, AccountDTO, TransactionDTO

	public void register(V1 v) throws Exception;

	public V1 login(K k, P p) throws Exception;

	public V1 getUserInfo(K k) throws Exception;

	public void makeAccount(K k, double balance) throws Exception;

	public List<V2> getAllAccount(K k) throws Exception;

	public List<V3> getAllTr(String accNum) throws Exception;

	public void transaction(String sendAcc, double money, String type, String rAcc) throws Exception;

}

package com.kbstar.service;

import java.util.List;

import com.kbstar.dao.AccountDAO;
import com.kbstar.dto.AccountDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Notification;
import com.kbstar.frame.CRUDService;
import com.kbstar.noti.NotificationImpl;

public class AccountService implements CRUDService<String, AccountDTO>{

	DAO<String, AccountDTO> accDao;
	Notification notification;
	
	public AccountService() {
		accDao = new AccountDAO();
		notification = new NotificationImpl();
	}

	@Override
	public void register(AccountDTO v) throws Exception {		
		
		try {
			accDao.insert(v);
		}catch(Exception e){
			throw new Exception("(서비스) id가 없습니다.");
		}
		
	}

	@Override
	public void remove(String k) throws Exception {
		
		try {
			accDao.delete(k);
		}catch(Exception e){
			throw new Exception("(서비스) id가 없습니다.");
		}
		
	
	}

	@Override
	public void modify(AccountDTO v) throws Exception {
		
		try {
			accDao.update(v);
		}catch(Exception e){
			throw new Exception("(서비스) id가 없습니다.");
		}
		
		
	}

	@Override
	public AccountDTO get(String k) throws Exception {
		
		AccountDTO obj ;
		try {
			obj = accDao.select(k);
		}catch(Exception e){
			throw new Exception("(서비스) id가 없습니다.");
		}
		
		return obj;
	}

	@Override
	public List<AccountDTO> get() throws Exception {
		List<AccountDTO> list = null;
		
		try {
			list = accDao.select();
		}catch(Exception e) {
			throw new Exception("(서비스) 조회할 내용이 없습니다.");
		}
		return list;
	}

}

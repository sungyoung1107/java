package com.kbstar.service;

import java.util.List;

import com.kbstar.dao.TransactionDAO;
import com.kbstar.dto.TransactionDTO;
import com.kbstar.frame.CRUDService;

public class TransactionService implements CRUDService<String, TransactionDTO>{
	
	TransactionDAO td ;
	
	public TransactionService() {
		td = new TransactionDAO();
	}	

	@Override
	public void register(TransactionDTO v) throws Exception{
	
		try {
			td.insert(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("고객님 거래 오류입니다. 나중에 다시 거래해주시기 바랍니다");
		}
		
	}

	@Override
	public void remove(String k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(TransactionDTO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TransactionDTO get(String k) throws Exception {
		TransactionDTO obj = null;
		
		try {
			obj = td.select(k);
		} catch (Exception e) {
			throw new Exception("고객님 거래 조회에 실패하였습니다. 거래일자를 다시 확인해주시기 바랍니다");
		}
	
		return obj;
	}

	@Override
	public List<TransactionDTO> get() throws Exception {
		List<TransactionDTO> list = null;
		
		try {
			list = td.select();
		} catch(Exception e) {
			throw new Exception("고객님 거래내역이 없습니다");
		}
		return list;
	}
	
	

}

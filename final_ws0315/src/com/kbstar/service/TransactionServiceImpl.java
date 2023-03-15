package com.kbstar.service;

import java.sql.SQLRecoverableException;
import java.util.List;

import com.kbstar.dao.TransactionDaoImpl;
import com.kbstar.dto.TransactionDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.frame.DAO;
import com.kbstar.frame.MakeAccountNumber;

public class TransactionServiceImpl implements CRUDService<String, TransactionDTO> {
	DAO<String, TransactionDTO> transactionDao;

	public TransactionServiceImpl() {
		transactionDao = new TransactionDaoImpl();
	}

	@Override
	public void register(TransactionDTO v) throws Exception {

		String id = MakeAccountNumber.makeTransIdNum();
		v.setTransdate(id); // 4가지 입력되면 계좌이체건 id 자동생성한다.
		transactionDao.insert(v);

	}

	@Override
	public void remove(String k) throws Exception {
		// 삭제기능없음

	}

	@Override
	public void modify(TransactionDTO v) throws Exception {
		// 수정기능없음
	}

	@Override
	public TransactionDTO get(String k) throws Exception {
		TransactionDTO obj = null;

		try {
			obj = transactionDao.select(k);
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("시스템 장애입니다. 잠시 후 다시 시도 해주세요.");
			} else {
				throw e;
			}
		}

		return obj;
	}

	@Override
	public List<TransactionDTO> get() throws Exception {
		List<TransactionDTO> list = null;

		try {
			list = transactionDao.select();
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("시스템 장애입니다. 잠시 후 다시 시도 해주세요.");
			} else {
				throw e;
			}
		}
		return list;
	}
}
package com.kbstar.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLRecoverableException;
import java.util.List;

import com.kbstar.dao.AccountDaoImpl;
import com.kbstar.dao.UserDaoImpl;
import com.kbstar.dto.AccountDTO;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.frame.DAO;
import com.kbstar.frame.MakeAccountNumber;

public class AccountServiceImpl implements CRUDService<String, AccountDTO> {

	DAO<String, AccountDTO> accDao;
	DAO<String, UserDTO> userDao;

	public AccountServiceImpl() {
		accDao = new AccountDaoImpl();
		userDao = new UserDaoImpl();
	}

	@Override
	public void register(AccountDTO v) throws Exception {
		try 
		{
			String acc = MakeAccountNumber.makeAccNum();
			v.setAccNum(acc);
			accDao.insert(v);
		} catch (Exception e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				throw new Exception("ID가 중복되었습니다");
			} else {
				throw new Exception("시스템 장애입니다. 잠시 후 다시 시도 해주세요.");
			}
		}

	}

	@Override
	public void remove(String k) throws Exception {
		try {
			accDao.delete(k);
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("시스템 장애입니다. 잠시 후 다시 시도 해주세요.");
			} else {
				throw new Exception("해당 ID는 존재하지 않습니다.");
			}
		}

	}

	@Override
	public void modify(AccountDTO v) throws Exception {
		try {
			accDao.update(v);
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("시스템 장애입니다. 잠시 후 다시 시도 해주세요.");
			} else {
				throw new Exception("해당 ID는 존재하지 않습니다.");
			}
		}

	}

	@Override
	public AccountDTO get(String k) throws Exception {
		AccountDTO accountdto;
		try {
			accountdto = accDao.select(k);
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("시스템 장애입니다. 잠시 후 다시 시도 해주세요.");
			} else {
				throw new Exception("해당 ID는 존재하지 않습니다.");
			}
		}

		return accountdto;
	}

	@Override
	public List<AccountDTO> get() throws Exception {
		return null;
	}

}

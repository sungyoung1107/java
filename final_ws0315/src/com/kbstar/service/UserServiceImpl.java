package com.kbstar.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLRecoverableException;
import java.util.List;

import com.kbstar.dao.UserDaoImpl;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.frame.DAO;

public class UserServiceImpl implements CRUDService<String, UserDTO> {
	DAO<String, UserDTO> userDao;

	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public void register(UserDTO v) throws Exception {
		try {
			userDao.insert(v);
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
			userDao.delete(k);
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("시스템 장애입니다. 잠시 후 다시 시도 해주세요.");
			} else {
				throw new Exception("해당 ID는 존재하지 않습니다.");
			}
		}

	}

	@Override
	public void modify(UserDTO v) throws Exception {
		try {
			userDao.update(v);
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("시스템 장애입니다. 잠시 후 다시 시도 해주세요.");
			} else {
				throw new Exception("해당 ID는 존재하지 않습니다.");
			}
		}
	}

	@Override
	public UserDTO get(String k) throws Exception {
		UserDTO user = null;
		try {
			user = userDao.select(k);
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("시스템 장애입니다. 잠시 후 다시 시도 해주세요.");
			} else {
				throw new Exception("해당 ID는 존재하지 않습니다.");
			}
		}
		return user;
	}

	public List<UserDTO> get() throws Exception {
		List<UserDTO> list = null;
		try {
			list = userDao.select();
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
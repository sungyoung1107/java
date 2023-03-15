package com.kbstar.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLRecoverableException;
import java.util.List;

import com.kbstar.dao.CartDaoImpl;
import com.kbstar.dao.DAO;
import com.kbstar.dto.Cart;
import com.kbstar.frame.CRUDService;
import com.kbstar.frame.MakeItemNumber;

public class CartCRUDServiceImpl implements CRUDService<String, Cart> {

	DAO<String, String, Cart> dao;

	public CartCRUDServiceImpl() {
		dao = new CartDaoImpl();

	}

	@Override
	public void register(Cart v) throws Exception {
		// 데이터 검증
		// DB 입력
		try {
			String id = MakeItemNumber.makeCartNum(); // 카트넘버 자동생성
			v.setId(id);

			dao.insert(v);
		} catch (Exception e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				throw new Exception("카드 번호 오류입니다.");
			} else {
				throw new Exception("고객센터로 문의하세요.");
			}
		}

	}

	@Override
	public void modify(Cart v) throws Exception {
		try {
			dao.update(v);
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("고객센터로 문의하세요.");
			} else {
				throw new Exception("카드 번호 오류입니다.");
			}
		}
	}

	@Override
	public void remove(String k) throws Exception {

		try {
			dao.delete(k);
		} catch (Exception e) {

			if (e instanceof SQLRecoverableException) {
				throw new Exception("고객센터로 문의하세요.");
			}
			throw new Exception("카드 번호 오류입니다.");
		}

	}

	@Override
	public Cart get(String k) throws Exception {
		Cart cart = null;

		try {
			cart = dao.select(k);
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("고객센터로 문의하세요.");
			}
			throw new Exception("카드 번호 오류입니다.");
		}
		return cart;
	}

	@Override
	public List<Cart> get() throws Exception {
		List<Cart> list = null;

		try {
			list = dao.selectAll();
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("고객센터로 문의하세요.");
			}
			throw new Exception("카드 번호 오류입니다.");
		}

		return list;
	}

}

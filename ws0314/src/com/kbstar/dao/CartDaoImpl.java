package com.kbstar.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kbstar.dto.Cart;
import com.kbstar.frame.Sql;

public class CartDaoImpl implements DAO<String, String, Cart> {

	public CartDaoImpl() {

		try {
			Class.forName("oracle.jdbc.OracleDriver"); // 클래스를 불러온다. 클래스 이름은 ORACLE DRIVER
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading 실패하였습니다...");
		}
		System.out.println("Driver Loading 성공하였습니다...");
	}

	@Override
	public void insert(Cart v) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.cartinsertSql);) {
			pstmt.setString(1, v.getId()); // 상품id set
			pstmt.setString(2, v.getUser_id()); // userId set
			pstmt.setString(3, v.getItem_id()); // itemId set
			pstmt.setInt(4, v.getCnt()); // 상품갯수 set
			int result = pstmt.executeUpdate();
			System.out.println(result);

			if (result == 0) {
				throw new Exception("카트 id 중복입니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void delete(String k1) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.cartdeleteSql);) {
			pstmt.setString(1, k1); // id를 셋
			int result = pstmt.executeUpdate(); // 실행하고 반환 값을 result에 받는다.
			if (result == 0) {
				throw new Exception("일치하는 카트 번호가 없습니다.");
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void update(Cart v) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.cartupdateSql);) {

			pstmt.setString(1, v.getItem_id()); // itemId set
			pstmt.setInt(2, v.getCnt()); // 상품갯수 set
			pstmt.setString(3, v.getId()); // 카트번호

			int result = pstmt.executeUpdate();
			if (result == 0) {
				throw new Exception("일치하는 카트 번호가 없습니다.");
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Cart select(String k1) throws Exception {
		Cart cart = null;

		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.cartselectSql);) {

			pstmt.setString(1, k1);

			try (ResultSet rset = pstmt.executeQuery()) {
				rset.next(); // 키값 한번 이동시켜야 함

				String id = rset.getString("id");
				String user_id = rset.getString("user_id");
				String item_id = rset.getString("item_id");
				Integer cnt = rset.getInt("cnt");
				Date regdate = rset.getDate("regdate");

				cart = new Cart(id, user_id, item_id, cnt, regdate);
			} catch (Exception e) { // 여기서 에러가 발생하면 바깥쪽 에러에 던져진다.
				throw new Exception("일치하는 카트 번호가 없습니다.");
			}

		} catch (Exception e) {
			throw e;
		}
		return cart;
	}

	@Override
	public List<Cart> selectAll() throws Exception {
		List<Cart> list = new ArrayList<Cart>();

		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.cartselectAllsSql);) {

			try (ResultSet rset = pstmt.executeQuery();) {

				while (rset.next()) {
					Cart cart = null;

					String id = rset.getString("id");
					String user_id = rset.getString("user_id");
					String item_id = rset.getString("item_id");
					Integer cnt = rset.getInt("cnt");
					Date regdate = rset.getDate("regdate");

					cart = new Cart(id, user_id, item_id, cnt, regdate);
					list.add(cart);

					if (list.size() == 0) {
						throw new Exception("카트가 비어있습니다.");
					}
				}

			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {
			throw e;
		}

		return list;
	}

	@Override
	public List<Cart> search(String k2) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

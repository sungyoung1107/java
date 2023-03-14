package com.kbstar.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kbstar.dto.Item;
import com.kbstar.frame.Sql;

public class ItemDaoImpl implements DAO<String, String, Item> {

	public ItemDaoImpl() {
		try {
			Class.forName("oracle.jdbc.OracleDriver"); // 클래스를 불러온다. 클래스 이름은 ORACLE DRIVER
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading 실패하였습니다...");
		}
		System.out.println("Driver Loading 성공하였습니다...");
	}

	@Override
	public void insert(Item v) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.iteminsertSql);) {
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getName());
			pstmt.setInt(3, v.getPrice());
			pstmt.setDouble(4, v.getRate());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void delete(String k1) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.itemdeleteSql);) {
			pstmt.setString(1, k1); // id를 셋
			int result = pstmt.executeUpdate(); // 실행하고 반환 값을 result에 받는다.
			if (result == 0) {
				throw new Exception("해당 ID 없음");
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public void update(Item v) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.itemupdateSql);) {
			pstmt.setString(1, v.getName());
			pstmt.setInt(2, v.getPrice());
			pstmt.setDouble(3, v.getRate());
			pstmt.setString(4, v.getId());
			int result = pstmt.executeUpdate();
			if (result == 0) {
				throw new Exception("ID 없음");
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Item select(String k1) throws Exception {
		Item item = null;

		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.itemselectSql);) {
			// 3. selectSql 첫번째 ? 표에 k1 값을 인자로 받아 넣겠다!
			pstmt.setString(1, k1);

			// 4. try / catch 한번 더 한다. ResultSet을 자동 close 할 수 있게 try( ) 안에 넣는다.
			try (ResultSet rset = pstmt.executeQuery()) {
				rset.next(); // 키값 한번 이동시켜야 함
				String id = rset.getString("id"); // id 컬럼을 가지고 오겠다.
				String name = rset.getString("name");
				Integer price = rset.getInt("price");
				double rate = rset.getDouble("rate");
				Date date = rset.getDate("regdate");
				item = new Item(id, name, price, rate, date);
			} catch (Exception e) { // 여기서 에러가 발생하면 바깥쪽 에러에 던져진다.
				throw new Exception("id가 없습니다");
			}
		} catch (Exception e) {
			// Connection 에러일 때 예외처리는 여기서 한다.
			throw e;
		}
		return item;
	}

	@Override
	public List<Item> selectAll() throws Exception {
		List<Item> list = new ArrayList<Item>();

		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.itemselectAllsSql);) {

			try (ResultSet rset = pstmt.executeQuery();) {

				while (rset.next()) {
					Item item = null;
					String id = rset.getString("id"); // id 컬럼을 가지고 오겠다.
					String name = rset.getString("name");
					Integer price = rset.getInt("price");
					double rate = rset.getDouble("rate");
					Date date = rset.getDate("regdate");
					item = new Item(id, name, price, rate, date);
					list.add(item);

					if (list.size() == 0) {
						throw new Exception("조회될 내용이 없습니다");
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
	public List<Item> search(String k2) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

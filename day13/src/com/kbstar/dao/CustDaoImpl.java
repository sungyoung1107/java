package com.kbstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kbstar.dto.Cust;
import com.kbstar.frame.Sql;

public class CustDaoImpl implements DAO<String, String, Cust> {

	// 1. constructor에서 JDBC 드라이버 로드 : MySQL을 연결할거니, ORACLE을 연결할거니 ! ORACLE을 연결하겠다.
	public CustDaoImpl() {
		try {
			Class.forName("oracle.jdbc.OracleDriver"); // 클래스를 불러온다. 클래스 이름은 ORACLE DRIVER
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading 실패하였습니다...");
//			e.printStackTrace();
		}
		System.out.println("Driver Loading 성공하였습니다...");
	}

	@Override
	public void insert(Cust v) throws Exception {
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(Sql.insertSql);) { // 우리가																								// 친다.
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getPwd());
			pstmt.setString(3, v.getName());
			pstmt.setInt(4, v.getAge());
			int result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (SQLException e1) {
			throw e1; // app 쪽으로 던지기 위해
//			e1.printStackTrace();
		}
	}

	@Override
	public void delete(String k) throws Exception {
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(Sql.deleteSql);) { 
			pstmt.setString(1, k);

			int result = pstmt.executeUpdate();
			if (result == 0) {
				throw new Exception("ID 없음"); // 여기서 던지는게 아니라 실제로 밑에서 던지는 거다.
			}
			System.out.println(result);
		} catch (SQLException e1) {
			throw e1; // app 쪽으로 던지기 위해 // 시스템 장애
		}
	}

	@Override // 우리가 보낸 내용을 업데이트 친다.
	public void update(Cust v) throws Exception {
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(Sql.updateSql);) { 
			pstmt.setString(1, v.getPwd());
			pstmt.setString(2, v.getName());
			pstmt.setInt(3, v.getAge());
			pstmt.setString(4, v.getId());

			int result = pstmt.executeUpdate();
			if (result == 0) {
				System.out.println("여기왔음");
				throw new Exception("id가 없습니다");
			}
			System.out.println(result);
		} catch (Exception e1) {
			throw e1; // app 쪽으로 던지기 위해
		}

	}

	@Override
	public Cust select(String k) throws Exception {
		// 1. 반환이 Cust 객체이니 준비하자
		// Cust cust = null;
		// return cust;
		Cust cust = null;

		// 2. Connection 자원과 sql을 전송하는 PreparedStatement 자원이 필요하고, 자동 close 할 수 있게 try (
		// ) 안에 넣는다.
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.selectSql)) {
			// 3. selectSql 첫번째 ? 표에 k 값을 인자로 받아 넣겠다!
			pstmt.setString(1, k);

			// 4. try / catch 한번 더 한다. ResultSet을 자동 close 할 수 있게 try( ) 안에 넣는다.
			try (ResultSet rset = pstmt.executeQuery()) {
				rset.next(); // 키값 한번 이동시켜야 함
				String id = rset.getString("id"); // id 컬럼을 가지고 오겠다.
				String pwd = rset.getString("pwd");
				String name = rset.getString("name");
				int age = rset.getInt("age");
				cust = new Cust(id, pwd, name, age);
			} catch (Exception e) { // 여기서 에러가 발생하면 바깥쪽 에러에 던져진다.
				throw e;
			}

		} catch (Exception e) {
			// Connection 에러일 때 예외처리는 여기서 한다.
			throw e;
		}
		return cust;
	}

	@Override
	public List<Cust> selectAll() throws Exception {
		List<Cust> list = new ArrayList<>();

		try(Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(Sql.selectAllsSql);){
			try(ResultSet rset = pstmt.executeQuery();){
				while(rset.next()) {
					Cust cust = null;
					String id = rset.getString("id");
					String pwd = rset.getString("pwd");
					String name = rset.getNString("name");
					int age = rset.getInt("age");
					cust = new Cust(id, pwd, name, age);
					list.add(cust);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				throw e;
			}
		}catch(Exception e) {
			throw e ; //SQLRecoverableException / IO 오류 // 이거는 서비스 영역에서 처리
		}
		return list;
	}

	@Override
	public List<Cust> search(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

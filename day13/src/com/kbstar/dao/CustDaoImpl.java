package com.kbstar.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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

	// 2. Connect : 포트번호 등으로 연결하기. 함수를 한개 만든다. 반환은 Connection 객체를 생성해서 준다.
	// Connection 객체가 필요한 이유는 나중에 PreparedStatement 객체를 생성하기 위함이다.
	// PreparedStatement는 statement를 상속받는 인터페이스로 자체적으로 객체를 생성하지 못하고
	// Connection 객체의 prepareStatement(String query)를 통해 생성할 수 있음
	public Connection getConnection() throws Exception {
		Connection con = null;
		/* 운영시스템에 자바 소스가 없으니 이걸 이용해서 한다. */
		/* ip 주소는 파일 안에서만 바꾸면 됨 */
		Properties props = new Properties();
		String fileName = "db_info.txt";
		FileInputStream in = new FileInputStream(fileName);
		props.load(in);

		String id = props.getProperty("DB_ID");
		String pwd = props.getProperty("DB_PWD");
		String url = props.getProperty("DB_URL");

		con = DriverManager.getConnection(url, id, pwd);
		// IP가 잘못되었을 때 getConnection()에서.... 바로 위에 문장이 에러가 남
		// at com.kbstar.dao.CustDaoImpl.getConnection

		return con;
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
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(Sql.deleteSql);) { // 우리가
																										// 친다.
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

	@Override
	public void update(Cust v) throws Exception {
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(Sql.updateSql);) { // 우리가
																													// 보낸
																													// 내용을
																													// 업데이트
																													// 친다.
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
			}
		}catch(Exception e) {
			throw e ; //SQLRecoverableException / IO 오류 // 이거는 서비스 영역에서 처리
		}
		
		return list;
		
//		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(Sql.selectAllsSql);) { 
//			try (ResultSet rset = pstmt.executeQuery()) {
//
//				while (rset.next()) {
//					String db_id = rset.getString("id"); /* .getString(1); */ /* 인덱스는 1부터 시작 */
//					String db_pwd = rset.getString("pwd"); /* getString(2); */
//					String name = rset.getString("name"); /* getString(3); */
//					int age = rset.getInt("age"); /* getInt(3); */
//					Cust cust = new Cust(db_id, db_pwd, name, age);
//					list.add(cust);
//				}
//			} catch (SQLException e) {
//				throw new Exception("select 오류입니다");
//			}
//
//		} catch (Exception e1) {
//			throw e1; // app 쪽으로 던지기 위해
//		}
//
//		return list;
	}

	@Override
	public List<Cust> search(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

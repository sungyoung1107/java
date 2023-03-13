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

	public CustDaoImpl() { // 객체가 생성되는 시점에 드라이버 로딩
		// 1. JDBC 드라이버 로드 : MySQL에 연결할겁니까, ORACLE에 연결할겁니까
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없습니다.");
			e.printStackTrace();
			return;
		}
		System.out.println("Driver Loading 성공.");
	}

	// Connection 객체를 생성해서 던져주는 역할
	public Connection getConnection() throws Exception {
		Connection con = null;
		/* 운영시스템에 자바 소스가 없으니 이걸 이용해서 한다. */
		Properties props = new Properties();
		String fileName = "db_info.txt";
		FileInputStream in = new FileInputStream(fileName);
		props.load(in);

		String id = props.getProperty("DB_ID");
		String pwd = props.getProperty("DB_PWD");
		String url = props.getProperty("DB_URL");
		
		con = DriverManager.getConnection(url, id, pwd);
		return con;
	}

	@Override
	public void insert(Cust v) throws Exception {
		try(Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(Sql.insertSql);) { // 우리가 보낸 내용을 업데이트 친다.
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getPwd());
			pstmt.setString(3, v.getName());
			pstmt.setInt(4, v.getAge());
			int result = pstmt.executeUpdate();
			System.out.println(result);
		} catch(SQLException e1) {
			throw e1; //app 쪽으로 던지기 위해
//			e1.printStackTrace();
		}
	}

	@Override
	public void delete(String k) throws Exception {
		try(Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(Sql.deleteSql);) { // 우리가 보낸 내용을 업데이트 친다.
			pstmt.setString(1, k); 
			
			int result = pstmt.executeUpdate();
			if(result == 0) {
				throw new Exception("ID 없음"); // 여기서 던지는게 아니라 실제로 밑에서 던지는 거다.
			}
			
			System.out.println(result);
			
		} catch(SQLException e1) {
			throw e1; //app 쪽으로 던지기 위해 // 시스템 장애
		}
	}

	@Override
	public void update(Cust v) throws Exception {
		try(Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(Sql.updateSql);) { // 우리가 보낸 내용을 업데이트 친다.
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
		} catch(Exception e1) {
			throw e1; //app 쪽으로 던지기 위해
		}

	}

	@Override
	public Cust select(String k) throws Exception {
		
		Cust cust = null;
		
		try(Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(Sql.selectSql);) { // 우리가 보낸 내용을 업데이트 친다.
				pstmt.setString(1, k);
				
			try(ResultSet rset = pstmt.executeQuery()) {
				rset.next();
				String db_id = rset.getString("id");  /* .getString(1); */ /* 인덱스는 1부터 시작 */
				String db_pwd = rset.getString("pwd"); /* getString(2); */
				String name = rset.getString("name"); /* getString(3); */
				int age = rset.getInt("age"); /* getInt(3); */
				System.out.println(db_id + " " + name + " " + age);
				cust = new Cust(db_id, db_pwd, name, age);
				
			}catch(SQLException e){
				throw new Exception("select 오류입니다");
			}
						
		} catch(Exception e1) {
			throw e1; //app 쪽으로 던지기 위해
		}
		
		return cust ;
	}

	@Override
	public List<Cust> selectAll() throws Exception {
		List<Cust> list = new ArrayList<>();
			
		try(Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(Sql.selectAllsSql);) { // 우리가 보낸 내용을 업데이트 친다.
				
			try(ResultSet rset = pstmt.executeQuery()) {
				
				while(rset.next()) {
					String db_id = rset.getString("id");  /* .getString(1); */ /* 인덱스는 1부터 시작 */
					String db_pwd = rset.getString("pwd"); /* getString(2); */
					String name = rset.getString("name"); /* getString(3); */
					int age = rset.getInt("age"); /* getInt(3); */
					Cust cust = new Cust(db_id, db_pwd, name, age);
					list.add(cust);
				}				
			}catch(SQLException e){
				throw new Exception("select 오류입니다");
			}
						
		} catch(Exception e1) {
			throw e1; //app 쪽으로 던지기 위해
		}
	
		return list;
	}

	@Override
	public List<Cust> search(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

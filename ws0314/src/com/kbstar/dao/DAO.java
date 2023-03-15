package com.kbstar.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;

public interface DAO<K1, K2, V> {

	public void insert(V v) throws Exception;

	public void delete(K1 k1) throws Exception;

	public void update(V v) throws Exception;

	public V select(K1 k1) throws Exception;

	public List<V> selectAll() throws Exception;

	public List<V> search(K2 k2) throws Exception;

	// 2. Connect : 포트번호 등으로 연결하기. 함수를 한개 만든다. 반환은 Connection 객체를 생성해서 준다.
	// Connection 객체가 필요한 이유는 나중에 PreparedStatement 객체를 생성하기 위함이다.
	// PreparedStatement는 statement를 상속받는 인터페이스로 자체적으로 객체를 생성하지 못하고
	// Connection 객체의 prepareStatement(String query)를 통해 생성할 수 있음
	public default Connection getConnection() throws Exception {
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

}

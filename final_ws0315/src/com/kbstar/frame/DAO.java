package com.kbstar.frame;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;

public interface DAO<K, V> {

	public void insert(V v) throws Exception;

	public void delete(K k) throws Exception;

	public void update(V v) throws Exception;

	public V select(K k) throws Exception;

	public List<V> select() throws Exception;

	public List<V> search(Object obj) throws Exception;

	public default Connection getConnection() throws Exception {
		Connection con = null;
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

}

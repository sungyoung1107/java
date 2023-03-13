package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest3 {
	
	public static void main(String[] args) {
		// 1. JDBC 드라이버 로드 : MySQL에 연결할겁니까, ORACLE에 연결할겁니까
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없습니다.");
			e.printStackTrace();
			return;
		}
		System.out.println("Driver Loading 성공.");
		
		// 2. CONNECT : 포트번호 등
		String id="bank";
		String pwd="111111";
		String url="jdbc:oracle:thin:@ 172.16.20.53:1521:XE";
		String insertSql = "INSERT INTO cust VALUES(?,?,?,?)";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
		
		// 3. STATEMENT 생성
		try(Connection conn = DriverManager.getConnection(url, id, pwd);
				PreparedStatement pstmt = conn.prepareStatement(insertSql);) { // 우리가 보낸 내용을 업데이트 친다.
//			conn = DriverManager.getConnection(url, id, pwd);
//			pstmt = conn.prepareStatement(insertSql);
			pstmt.setString(1, "id01");
			pstmt.setString(2, "pwd22");
			pstmt.setString(3, "이뭉치");
			pstmt.setInt(4, 30);
			int result = pstmt.executeUpdate();
			System.out.println(result);
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		// 4. SQL 전송
		// 5. 결과 받기
		// 6. 연결 해제 : CLOSE 
	}
}

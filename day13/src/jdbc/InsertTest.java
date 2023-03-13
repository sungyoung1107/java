package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
	
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
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, id, pwd);
		} catch (SQLException e) {
			System.out.println("접속 실패!!");
			e.printStackTrace();
			return;
		}
		System.out.println("접속 성공!!");
		// 3. STATEMENT 생성
		String insertSql = "INSERT INTO cust VALUES(?,?,?,?)";
		PreparedStatement pstmt = null;
		try { // 우리가 보낸 내용을 업데이트 친다.
			pstmt = conn.prepareStatement(insertSql);
			pstmt.setString(1, "id20");
			pstmt.setString(2, "pwd20");
			pstmt.setString(3, "이둘리");
			pstmt.setInt(4, 30);
			int result = pstmt.executeUpdate();
			System.out.println(result);
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// 4. SQL 전송
		// 5. 결과 받기
		// 6. 연결 해제 : CLOSE 
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("close 실패!!");
			e.printStackTrace();
		}
		System.out.println("close 성공!!");
	}
}

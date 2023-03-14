package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest2 {
	
	public static void main(String[] args) {
		// 1. JDBC 드라이버 로드 : MySQL에 연결할겁니까, ORACLE에 연결할겁니까
/// 직접 해보기		
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
		String selectSql = "SELECT * from cust WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		// 3. STATEMENT 생성
		try { // 우리가 보낸 내용을 업데이트 친다.
			conn = DriverManager.getConnection(url, id, pwd);
			pstmt = conn.prepareStatement(selectSql);
			pstmt.setString(1, "id01");
			
			try(ResultSet rset = pstmt.executeQuery()) {
				rset.next();
				String db_id = rset.getString("id");  /* .getString(1); */ /* 인덱스는 1부터 시작 */
				String db_pwd = rset.getString("pwd"); /* getString(2); */
				String name = rset.getString("name"); /* getString(3); */
				int age = rset.getInt("age"); /* getInt(3); */
				System.out.println(db_id + " " + name + " " + age);
			}catch(SQLException e){
				e.printStackTrace();
			}
	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try { // 나중에 먼저 한 것(pstmt) close
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		
		// 4. SQL 전송
		// 5. 결과 받기
		// 6. 연결 해제 : CLOSE 
	}
}

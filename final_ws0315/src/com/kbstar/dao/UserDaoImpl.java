package com.kbstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Sql;

public class UserDaoImpl implements DAO<String, UserDTO> {

	// 아래 함수만들 때 필요하므로 미리 선언.
	UserDTO user = new UserDTO();

	// 1. jdbc에서 각각 실행해주던걸, Driver Loading 한번으로 할 수 있다.
	public UserDaoImpl() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없습니다.");
			e.printStackTrace();
			return; // 예외상황 발생 시 종료해줘
		}
	}

	// db에 고객 정보(회원가입, 수정, 삭제) 관련 기능만들기
	@Override // 인터넷뱅킹 가입
	public void insert(UserDTO v) throws Exception {

		try (Connection con = getConnection(); // 커넥션할 때, 한번에 쓰려고 위에서 만든 메소드쓰기!
				PreparedStatement pstmt = con.prepareStatement(Sql.bankuserinsertSql);) {

			pstmt.setString(1, v.getId()); // 자리에 따라 값 세팅.
			pstmt.setString(2, v.getPw());
			pstmt.setString(3, v.getName());
			pstmt.setString(4, v.getContact());
			int result = pstmt.executeUpdate();// 결과 받기
			System.out.println(result);

		} catch (Exception e) {
			throw e; // 예외발생 시 service로 넘김.
		}

	}

	@Override // 인터넷뱅킹 해지
	public void delete(String k) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.bankuserdeleteSql);) {
			pstmt.setString(1, k); // 첫번째 물음표자리에 값 세팅.

			int result = pstmt.executeUpdate();// 결과 받기
			if (result == 0) {
				throw new Exception("삭제할 인터넷뱅킹 id가 존재하지 않습니다.");
			}
		} catch (SQLException e) {
			throw e; // 다른 예외발생 시 service로 넘김.
		}

	}

	@Override // 인터넷뱅킹 회원정보 수정
	public void update(UserDTO v) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.bankuserupdateSql);) {

			// 물음표 자리마다 값 세팅.
			pstmt.setString(1, v.getPw());
			pstmt.setString(2, v.getName());
			pstmt.setString(3, v.getContact());
			pstmt.setString(4, v.getId());

			int result = pstmt.executeUpdate();// 5. 결과 받기
			if (result == 0) {
				throw new Exception("인터넷뱅킹에 등록된 고객정보 중 수정할 내용이 없습니다.");
			}
		} catch (SQLException e) {
			throw e; // 다른 예외발생 시 service로 넘김.
		}

	}

	@Override // 기등록된 뱅킹 회원정보 조회
	public UserDTO select(String k) throws Exception {
		// 셀렉트는 고객정보 담고 있는 userDTO 반환할 값 있기에 선언 필수
		UserDTO user = null;

		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.bankuserselectSql);) {
			pstmt.setString(1, k);

			// 문제발생 시 close 자동으로 하기 위해 한번 더 try안에 try문 입력
			// 참고. executeQuery : 데이터를 가져온다.
			try (ResultSet rset = pstmt.executeQuery()) {
				rset.next(); // 끄집어내기 전 한칸 이동.

				String id = rset.getString("id"); // 끄집어낼 값 : "id"는 컬럼명.
				String pw = rset.getString("pw"); // 끄집어낼 값 : "pw"는 컬럼명.
				String name = rset.getString("name"); // 끄집어낼 값 : "name"는 컬럼명.
				String contact = rset.getString("contact"); // 끄집어낼 값 : "contact"는 컬럼명.

				user = new UserDTO(id, pw, name, contact); // user 객체 생성.
			} catch (Exception e) {
				throw e; // 여긴 조회할 데이터 없을 때 발생 구간 -> 에러는 Service로 던졌다. 거기서 세부문구
			}

		} catch (Exception e) {
			throw e; // 여긴 네트웤오류 발생구간 -> 에러는 Service로 던졌다. 거기서 세부문구
		}
		return user;
	}

	@Override
	public List<UserDTO> select() throws Exception {
		List<UserDTO> list = new ArrayList<>();

		try (Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(Sql.bankuserselectAllSql);) {
			try (ResultSet rset = pstmt.executeQuery();) {
				// 셀렉트 올은 와일문~
				while (rset.next()) {
					UserDTO user = null; // 안에서 초기화 가능
					String id = rset.getString("id"); // 끄집어낼 값 : "id"는 컬럼명.
					String pw = rset.getString("pw"); // 끄집어낼 값 : "pw"는 컬럼명.
					String name = rset.getString("name"); // 끄집어낼 값 : "name"는 컬럼명.
					String contact = rset.getString("contact"); // 끄집어낼 값 : "contact"는 컬럼명.

					user = new UserDTO(id, pw, name, contact); // user 객체 생성.
					list.add(user); // 한바퀴 돌아서나온 값은 list에 넣자.
				}
			} catch (Exception e) {
				throw e;
			}
		} catch (Exception e) {
			throw e;
		}
		return list;
	}

	// 사용x
	@Override
	public List<UserDTO> search(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

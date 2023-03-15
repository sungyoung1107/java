package com.kbstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kbstar.dto.TransactionDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Sql;

public class TransactionDaoImpl implements DAO<String, TransactionDTO> {


	// 1. jdbc에서 각각 실행해주던걸, Driver Loading 한번으로 할 수 있다.
	public TransactionDaoImpl() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없습니다.");
			e.printStackTrace();
			return; // 예외상황 발생 시 종료해줘
		}
	}
	
	//사전참고 : 계좌이체 거래는 delete, update없음. 삭제요망
	//계좌이체 거래를 db로 저장하는 등
	
	@Override //계좌이체 기능
	public void insert(TransactionDTO v) throws Exception {
		try (Connection con = getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(Sql.transactioninsertSql);) {

			pstmt.setString(1, v.getTransdate()); // 자리에 따라 값 세팅.
			pstmt.setString(2, v.getAccNum());
			pstmt.setDouble(3, v.getMoney());
			pstmt.setString(4, v.getType());
			pstmt.setString(5, v.getrAcc());
			pstmt.executeUpdate();// 결과 받기
			

		} catch (Exception e) {
			throw e; // 예외발생 시 service로 넘김.
		}


	}

	
	@Override //'사용자의 특정 계좌번호'를 (list에)집어넣으면, 적합한 계좌내역 전체 정보를 줘.
	public List<TransactionDTO> search(Object obj) throws Exception {

		// 로그인한 사용자가 가지고 있는 계좌번호를 -> 담을 바구니 만들기.
				List<TransactionDTO> list = new ArrayList<>();

				try (Connection con = getConnection();
						PreparedStatement pstmt = con.prepareStatement(Sql.transactionselectSql);) {
					
					//이 조건으로 데이터를 조회해줘~
					pstmt.setString(1, (String) obj); 
					try(ResultSet rset = pstmt.executeQuery();){
						
						if(list.size() == 0) {
							throw new Exception("해당 계좌의 이체내역이 한 건도 존재하지 않습니다.");
						} else {
						while(rset.next()) {
							TransactionDTO trDto = null; 
							
							String transdate = rset.getString("transdate");
							String accNum = rset.getString("accNum");
							Double money = rset.getDouble("money");
							String type = rset.getString("type");
							String rAcc = rset.getString("rAcc");
							
							trDto = new TransactionDTO(transdate, accNum, money, type ,rAcc); // 객체 생성
							list.add(trDto); // 한바퀴 돌아서나온 값은 list에 넣자.
						}
						}
					}catch(Exception e) {
						throw e;
					}
				} catch (Exception e) {
					throw e; // 예외발생 시 서비스로 던진다.
				}
				return list;
	}

	//사용안함
	@Override
	public void delete(String k) throws Exception {
		// TODO Auto-generated method stub
		
	}
	//사용안함
	@Override
	public void update(TransactionDTO v) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override //selectAll 사용안함.
	public List<TransactionDTO> select() throws Exception {
		return null;
	}
	@Override //사용안함
	public TransactionDTO select(String k) throws Exception {
		return null;
	}

}

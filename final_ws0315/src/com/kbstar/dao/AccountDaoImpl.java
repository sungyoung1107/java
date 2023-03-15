package com.kbstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kbstar.dto.AccountDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Sql;

public class AccountDaoImpl implements DAO<String, AccountDTO> {

	public AccountDaoImpl() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver가 없습니다.");
			e.printStackTrace();
			return;
		}
	}

	@Override
	public void insert(AccountDTO v) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.accountinsertSql);) {
			pstmt.setString(1, v.getAccNum());
			pstmt.setString(2, v.getAccHolder());
			pstmt.setDouble(3, v.getBalance());
			pstmt.setString(4, v.getUserId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String k) throws Exception {
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.accountdeleteSql);) {
			pstmt.setString(1, k);
			int result = pstmt.executeUpdate();
			if (result == 0) {
				throw new Exception("일치하는 계좌번호가 없습니다.");
			}
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override

	public void update(AccountDTO v) throws Exception {
		
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.accountupdateSql);) {
			pstmt.setDouble(1, v.getBalance());
			pstmt.setString(2, v.getAccNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public AccountDTO select(String k) throws Exception {
		AccountDTO acc = null;
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.accountselectSql);) {
			pstmt.setString(1, k);
			try (ResultSet rset = pstmt.executeQuery()) {
				rset.next();
				String accNum = rset.getString("accNum");
				String accHolder = rset.getString("accHolder");
				double balance = rset.getDouble("balance");
				String userId = rset.getString("userId");
				acc = new AccountDTO(accNum, accHolder, balance, userId);
			} catch (SQLException e) {
				throw e;
			}
		} catch (Exception e) {
			throw e;
		}
		return acc;
	}

	@Override
	public List<AccountDTO> select() throws Exception {
		List<AccountDTO> list = new ArrayList<>();
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(Sql.accountselectSql);) {
			try (ResultSet rset = pstmt.executeQuery();) {
				while (rset.next()) {
					AccountDTO acc = null;
					String accNum = rset.getString("accNum");
					String accHolder = rset.getString("accHolder");
					double balance = rset.getDouble("balance");
					String userId = rset.getString("userId");
					acc = new AccountDTO(accNum, accHolder, balance, userId);
					list.add(acc);
				}
			} catch (Exception e) {
				throw e;
			}
		} catch (Exception e) {
			throw e;
		}
		return list;
	}

	@Override
	public List<AccountDTO> search(Object obj) throws Exception {

		List<AccountDTO> list = new ArrayList<>();
		try (Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(Sql.myaccountselectAllSql);) {
			pstmt.setString(1, (String) obj);
			try (ResultSet rset = pstmt.executeQuery();) {
				while (rset.next()) {
					AccountDTO acc = null;
					String accNum = rset.getString("accNum");
					String accHolder = rset.getString("accHolder");
					double balance = rset.getDouble("balance");
					String userId = rset.getString("userId");
					acc = new AccountDTO(accNum, accHolder, balance, userId);
					list.add(acc);
				}
			} catch (Exception e) {
				throw e;
			}
		} catch (Exception e) {
			throw e;
		}
		return list;
	}
}

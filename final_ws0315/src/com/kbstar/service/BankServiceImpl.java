package com.kbstar.service;

import java.util.List;

import com.kbstar.dao.AccountDaoImpl;
import com.kbstar.dao.TransactionDaoImpl;
import com.kbstar.dao.UserDaoImpl;
import com.kbstar.dto.AccountDTO;
import com.kbstar.dto.TransactionDTO;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.BankService;
import com.kbstar.frame.DAO;
import com.kbstar.frame.MakeAccountNumber;

public class BankServiceImpl implements BankService<UserDTO, AccountDTO, TransactionDTO, String, String> {
	DAO<String, UserDTO> userDao;
	DAO<String, AccountDTO> accountDao;
	DAO<String, TransactionDTO> transactionDao;

	UserDTO user = null;

	public BankServiceImpl() {
		userDao = new UserDaoImpl();
		accountDao = new AccountDaoImpl();
		transactionDao = new TransactionDaoImpl();

	}

	@Override
	public void register(UserDTO v) throws Exception {
		try {
			userDao.insert(v);
		} catch (Exception e) {
			e.printStackTrace();
//			e.getStackTrace();
			throw new Exception("등록오류");
		}
	}

	@Override
	public UserDTO login(String k, String p) throws Exception {

		user = userDao.select(k);
		if (user != null) {
			if (user.getPw().equals(p)) {
				System.out.println("로그인 OK");
			} else {
				throw new Exception("PWD가 일치하지 않습니다.");
			}
		} else {
			throw new Exception("로그인실패");
		}

		return user;
	}

	@Override
	public UserDTO getUserInfo(String k) throws Exception {
		UserDTO user = null;
		user = userDao.select(k);
		return user;
	}

	@Override
	public void makeAccount(String k, double balance) throws Exception {
	}

	@Override
	public List<AccountDTO> getAllAccount(String k) throws Exception {
		return accountDao.search(k);
	}

	@Override
	public List<TransactionDTO> getAllTr(String accNum) throws Exception {
		return transactionDao.search(accNum);
	}

	@Override
	public void transaction(String sendAcc, double money, String type, String rAcc) throws Exception {
		System.out.println("금융결제원에 정보가 송부되었습니다.");
		// 내 잔액 조회.
		AccountDTO myacc = null;
		AccountDTO racc = null;
		myacc = accountDao.select(sendAcc);
		racc = accountDao.select(rAcc);

		if (money > myacc.getBalance()) {
			throw new Exception("잔액 부족");
		}
		// 내 계좌에서 송금 금액 차감
		double newbalance = myacc.getBalance() - money;
		myacc.setBalance(newbalance);
		accountDao.update(myacc);
		// 받은 계좌 송금 금액 추가
		double newbalance2 = racc.getBalance() + money;
		racc.setBalance(newbalance2);
		accountDao.update(racc);
		// 내 계좌 거래 내역 추가
		TransactionDTO mytr = new TransactionDTO(sendAcc, money, "O", rAcc);
		mytr.setTransdate(MakeAccountNumber.makeTransIdNum());
		transactionDao.insert(mytr);
		System.out.println(mytr);
		// 상대 계좌 거래 내역 추가
		TransactionDTO retr = new TransactionDTO(money, "I");
		retr.setTransdate(MakeAccountNumber.makeTransIdNum());
		retr.setAccNum(rAcc);
		retr.setrAcc(null);
		transactionDao.insert(retr);
		System.out.println(retr);
		System.out.println(
				sendAcc + "에서 " + rAcc + " 계좌로 " + money + "원 이체 완료되었습니다. 잔액은 " + myacc.getBalance() + "원입니다.");
		// 구현 못한것.... 계좌번호 입력 시 우리 db에 있는 것인지 여부
	}
}
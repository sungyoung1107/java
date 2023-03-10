/**
 * 
 */
package com.kbstar.service;

import java.util.ArrayList;
import java.util.List;

import com.kbstar.dao.AccountDAO;
import com.kbstar.dao.TransactionDAO;
import com.kbstar.dao.UserDAO;
import com.kbstar.dto.AccountDTO;
import com.kbstar.dto.TransactionDTO;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.BankService;
import com.kbstar.frame.DAO;
import com.kbstar.frame.MakeAccountNumber;
import com.kbstar.frame.Notification;
import com.kbstar.noti.NotificationImpl;

/**
 * @author 성영
 *
 */
public class BankServiceImpl
implements BankService<UserDTO, AccountDTO,
TransactionDTO, String, String>{
	
	DAO<String, UserDTO> userDao;
	DAO<String, AccountDTO> accountDao;
	DAO<String, TransactionDTO> transactionDao;
	Notification notification;
	UserDTO user ;
	
	public BankServiceImpl() {
		userDao = new UserDAO();
		accountDao = new AccountDAO();
		transactionDao = new TransactionDAO();
		notification = new NotificationImpl();
	}

	@Override
	public void register(UserDTO v) throws Exception {
		try {
			userDao.insert(v);
		}catch(Exception e) {
			throw new Exception("등록 오류");
		}
		notification.sendEmail(v.getEmail(), "축하합니다");
		notification.sendSMS(v.getContact(), "축하합니다");
	}

	@Override
	public UserDTO login(String k, String p) throws Exception {
//		UserDTO user = null;
//		user = userDao.select(k);		
		user = userDao.select(k);
		
		if(user != null) {
			if(user.getPwd().equals(p)) {
				System.out.println("ok");
			}else {
				throw new Exception("로그인 실패");
			}
		}else {
			throw new Exception("로그인 실패");
			
		}
		return user;
	}

	@Override
	public UserDTO getUserInfo(String k) throws Exception {
		UserDTO user = userDao.select(k); // 나의 계좌를 가져와라
		return user;
	}

	@Override
	public void makeAccount(String k, double balance) throws Exception {		
		String accNo = MakeAccountNumber.makeAccNum();
		
		AccountDTO account = 
				new AccountDTO(accNo, balance, k);
		// AccountDTO 사용자 객체를 만든다.
		accountDao.insert(account); // DB에 넣는다.
		
		UserDTO user = userDao.select(k);
		
		notification.sendEmail(user.getEmail(), accNo+" 계좌 생성 완료에요!");
		notification.sendSMS(user.getContact(), accNo+" 계좌 생성 완료에요!");
	
	}

	@Override
	public List<AccountDTO> getAllAccount(String k) throws Exception {
		List<AccountDTO> list = new ArrayList<>();
		list.add(accountDao.select(k));	// accountDao.select(k) 반환 객체 AccountDTO
		return list;
	}

	@Override
	public List<TransactionDTO> getAllTr(String acc) throws Exception {
		List<TransactionDTO> list = new ArrayList<>();
		list.add(transactionDao.select(acc));
		return list;
	}

	@Override
	public void transaction(String sendAcc, String receiceAcc, double balance, String desc) throws Exception {
		System.out.println("금결원 전송");
		//계좌 정보 가져오기
		AccountDTO acc= null;
		acc = accountDao.select(sendAcc);
		
		//계좌 잔액 정보 조회 / 잔액에서 이체하는 금액을 차감한 잔액으로 수정
		double afterBalance = 0;
		if (acc.getBalance() < balance || balance == 0) {
			System.out.println("고객님 잔액이 부족합니다");
			return;
		}		
		afterBalance = acc.getBalance() - balance; // 잔액 추출
		acc.setBalance(afterBalance); // 잔액 SET 
		accountDao.update(acc); // 잔액 업데이트
		
		//거래내역 추가
		TransactionDTO td = new TransactionDTO(MakeAccountNumber.makeTrNum(), sendAcc, balance, "이체", desc, "kb");	
		transactionDao.insert(td); // 거래 완료시 정보를 insert 해준다.
		
		// sms, email 전송
//		notification.sendEmail(user.getEmail(), "축하합니다");
//		notification.sendSMS(user.getContact(), "축하합니다");
		
		// 최신의 정보를 가져오는 것이 좋다. ?_?gg
		String uid = acc.getHolder(); //키값이 id에서 이름으로 바뀜.......!
		UserDTO u = userDao.select(uid);
		notification.sendEmail(u.getEmail(), sendAcc+" 에서 "+balance+"원 출금되었습니다.");
		notification.sendEmail(u.getContact(), sendAcc+" 에서"+balance+"원 출금되었습니다.");
		
		
		System.out.println("계좌 송금이 완료 되었습니다!!!");
	}


}

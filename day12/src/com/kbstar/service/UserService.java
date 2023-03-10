package com.kbstar.service;

import java.util.List;

import com.kbstar.dao.UserDAO;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Msg;
import com.kbstar.frame.Notification;
import com.kbstar.frame.CRUDService;
import com.kbstar.noti.NotificationImpl;

public class UserService implements CRUDService<String, UserDTO>{
	
	// 사용하는 것들을 상단에서 정의
	
	DAO<String, UserDTO> userDao; // DAO 인터페이스 쓸거야
	Notification notification; // Notification 인터페이스 쓸거야
	
	public UserService() {
		userDao = new UserDAO(); // 실제 객체 생성은 인터페이스가 아닌 인터페이스를 상속받은 클래스로 만든다.
		notification = new NotificationImpl();
	}

	@Override
	public void register(UserDTO v) throws Exception {	
		//비밀번호 암호화
		try {	
			userDao.insert(v); // try catch를 안써주면 그냥 화면에 실패 빨간색으로...
		}catch(Exception e) {
			throw new Exception("회원가입 실패하였습니다.(Ex0001)"); // 화면으로 던져줘야 한다. UserDAO에서의 에러문구와 달리 사용자 입장에서 한번 더 에러문구를 수정해준다.
		}
			
		notification.sendEmail(v.getEmail(), Msg.registerMsg1);
		notification.sendSMS(v.getContact(), Msg.registerMsg2);
	}

	@Override
	public void remove(String k) throws Exception {
		UserDTO user = null;
		
		try {
			user = userDao.select(k); // 고객정보 먼저 가져오고
			userDao.delete(k); // 그다음에 고객정보 삭제하고
		}catch(Exception e) {
			throw new Exception("삭제 오류입니다.");
		}
		notification.sendSMS(user.getContact(), Msg.removeMsg1); // 문자 보낸다
		notification.sendEmail(user.getEmail(), Msg.removeMsg2); // 메일 보낸다
 	}

	@Override
	public void modify(UserDTO v) throws Exception {
		
		try {
			userDao.update(v);
		}catch (Exception e) {
			throw new Exception("수정 오류입니다.");
		}
	}

	@Override
	public UserDTO get(String k) throws Exception {
		UserDTO obj = null;
		obj = userDao.select(k);
		return obj;
	}

	@Override
	public List<UserDTO> get() throws Exception {
		List<UserDTO> list = null;
		
		try {	
			list = userDao.select();
		}catch(Exception e) {
			throw new Exception("조회 오류");
		}
		
		return list;
	}
	

}

package com.kbstar.test;

import java.util.List;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.UserService;

public class UserRegisterTest {
	public static void main(String[] args) {
		CRUDService<String, UserDTO> service = new UserService();
		UserDTO obj =
				new UserDTO("id01", "pwd01", "james", "a@naver.com", "010-1234-5678");
//		UserDTO obj2 =
//				new UserDTO("id01", "pwd01", "james", "a@naver.com", "010-1234-5678");
		UserDTO obj2 =
				new UserDTO("id02", "pwd02", "james", "a@naver.com", "010-1234-5678");
		UserDTO obj3 =
				new UserDTO("id03", "pwd03", "james", "a@naver.com", "010-1234-5678");
		
		/** register(v) test **/
		try {
			service.register(obj);
			service.register(obj2);
			service.register(obj3);
			System.out.println("\n--------------");
//			service.register(obj2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
//			e.printStackTrace();
		}
		
		/** remove(k) test **/
		try {
			service.remove("id02");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		/** get(k) test **/
		try {
			UserDTO user = service.get("id01");
			System.out.println(user);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/** get() test **/
		List<UserDTO> list = null;
		try {
			list = service.get();
			for(UserDTO data : list) {
				System.out.println(data);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
//		try {
//			service.remove(obj.getId());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		service.mod
	}
}

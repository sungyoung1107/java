package com.kbstar.app;

import java.util.Scanner;

import com.kbstar.DTO.UserDTO;
import com.kbstar.frame.Service;
import com.kbstar.userservice.UserService;

public class App implements Service<Object, Object>{

	public static void main(String[] args) {

		Service<String, UserDTO> service = new UserService();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Input command(q, i, d, u)");
			String cmd = sc.next();
			if(cmd.equals("q")) {
				System.out.println("Bye");
				break;
			}else if(cmd.equals("i")) {
				System.out.println("Input ID...");
				String id = sc.next();
				System.out.println("Input PWD...");
				String pwd = sc.next();
				System.out.println("Input NAME...");
				String name = sc.next();
				UserDTO user = new UserDTO(id, pwd, name); // id, pwd, name을 운반하는 객체 생성
				service.register(user); // user object를 넣기
			}else if(cmd.equals("d")) {
				System.out.println("Input ID...");
				String id = sc.next();
				service.remove(id); // object에도 string 넣을 수 있다!
			}else if(cmd.equals("u")) {
				System.out.println("Input ID...");
				String id = sc.next();
				System.out.println("Input PWD...");
				String pwd = sc.next();
				System.out.println("Input NAME...");
				String name = sc.next();
				UserDTO user = new UserDTO(id, pwd, name); // id, pwd, name을 운반하는 객체 생성
				service.modify(user); // user object를 넣기
			}
		}
		
		sc.close();

	}

	@Override
	public void register(Object v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Object k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(Object v) {
		// TODO Auto-generated method stub
		
	}
}


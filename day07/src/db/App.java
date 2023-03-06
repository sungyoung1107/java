package db;

import java.util.Scanner;

public class App implements DAO{

	public static void main(String[] args) {

//		DAO dao = new OracleDAO(); // 추상클래스와 인터페이스는 객체생성 못한다. 
//		Oracle->MariaDB 수정해야 할 때
		DAO dao = new MariaDBDAO();
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
				dao.insert(user); // user object를 넣기
			}else if(cmd.equals("d")) {
				System.out.println("Input ID...");
				String id = sc.next();
				dao.delete(id); // object에도 string 넣을 수 있다!
			}else if(cmd.equals("u")) {
				System.out.println("Input ID...");
				String id = sc.next();
				System.out.println("Input PWD...");
				String pwd = sc.next();
				System.out.println("Input NAME...");
				String name = sc.next();
				UserDTO user = new UserDTO(id, pwd, name); // id, pwd, name을 운반하는 객체 생성
				dao.update(user); // user object를 넣기
			}
		}
		
		sc.close();

	}

	@Override
	public void insert(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		
	}

}

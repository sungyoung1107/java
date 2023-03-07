package com.kbstar.app;

import java.util.Scanner;

import com.kbstar.DTO.ItemDTO;
import com.kbstar.frame.Service;
import com.kbstar.service.ItemService;

public class App {
	
	public static void main(String[] args) {

		Service<Integer, ItemDTO> service = new ItemService();
		Scanner sc = new Scanner(System.in);
		int id=0;
		
		while(true) {
			System.out.println("Input command(q, i, d, u)");
			String cmd = sc.next();
			if(cmd.equals("q")) {
				System.out.println("Bye");
				break;
			}else if(cmd.equals("i")) {
				System.out.println("Input ID...");
				
				try {
					id = sc.nextInt();
					service.remove(id);
				}catch(Exception e) {
					System.out.println("잘못 입력하셨습니다");
				}
				
				System.out.println("Input NAME...");
				String name = sc.next();
				System.out.println("Input PRICE...");
				double price = sc.nextDouble();
				System.out.println("Input Quantity...");
				int qt = Integer.parseInt(sc.next());
			
				ItemDTO item = new ItemDTO(id, name, price, qt); //데이터 운반 객체 생성
				service.register(item);
			}else if(cmd.equals("d")) {
				System.out.println("Input ID...");
				id = sc.nextInt();
				System.out.println("Input NAME...");
				String name = sc.next();
				System.out.println("Input PRICE...");
				double price = sc.nextDouble();
				System.out.println("Input Quantity...");
				int qt = Integer.parseInt(sc.next());
			
				ItemDTO item = new ItemDTO(id, name, price, qt); //데이터 운반 객체 생성
				service.remove(id);
			}else if(cmd.equals("u")) {
				System.out.println("Input ID...");
				id = sc.nextInt();
				System.out.println("Input NAME...");
				String name = sc.next();
				System.out.println("Input PRICE...");
				double price = sc.nextDouble();
				System.out.println("Input Quantity...");
				int qt = Integer.parseInt(sc.next());
			
				ItemDTO item = new ItemDTO(id, name, price, qt); //데이터 운반 객체 생성
				service.modify(item);
			}
		}
		
		sc.close();

	}
}

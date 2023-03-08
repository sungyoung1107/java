package com.kbstar.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.kbstar.DTO.ItemDTO;
import com.kbstar.frame.MakeMessage;
import com.kbstar.frame.SearchService;
import com.kbstar.frame.Service;
import com.kbstar.service.ItemService;

public class App2 implements Service<Object, Object>{
	
	public static void main(String[] args) {

		Service<Integer, ItemDTO> service = new ItemService();
		SearchService search = new ItemService();
		Scanner sc = new Scanner(System.in);
		int id = 0;
		double price = 0;
		int qt = 0;
		ItemDTO item;
		
		while(true) {
			System.out.println("Input command(q, i, s, d, u)");
			String cmd = sc.next();
			
			if(cmd.equals("q")) {
				System.out.println("Bye");
				break;
			}else if(cmd.equals("i")) {
				
				while(true) {
				
					System.out.println("Input ID...");
				
					try {
						id = sc.nextInt();				
						break;	
					}catch(InputMismatchException e) {
						System.out.println("잘못 입력하셨습니다. 다시 입력해주세요. ");
						sc.next(); // 커서 처리
					}
					
//					try {
//						service.remove(id);
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}	
				}
				
				System.out.println("Input NAME...");
				String name = sc.next();
				
				while(true) {
				
					System.out.println("Input PRICE...");
				
					try {
						price = sc.nextDouble();
						break;
					}catch(InputMismatchException e) {
						System.out.println("가격은 숫자로 입력하세요");
						sc.next(); // 커서 처리
					}
					
				}
				
				while(true) {
				
					System.out.println("Input Quantity...");
					
					try {
						qt = Integer.parseInt(sc.next());
						break;
					}catch(NumberFormatException e) {
						System.out.println("수량은 숫자로 입력하세요");
						sc.next(); // 커서 처리
					}
					
				}
				
				item = new ItemDTO(id, name, price, qt); //데이터 운반 객체 생성
				
				try {
					service.register(item);
				} catch (Exception e) {
					System.out.println(MakeMessage.makeMessage(e.getMessage()));
				}
				
			}else if (cmd.equals("s")) {
				try {
					search.search();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(cmd.equals("d")) {
				
				while(true) {
					
					System.out.println("Input ID...");
				
					try {
						id = sc.nextInt();				
						break;	
					}catch(InputMismatchException e) {
						System.out.println("잘못 입력하셨습니다. 다시 입력해주세요. ");
						sc.next(); // 커서 처리
					}
					
				}			
				
				System.out.println("Input NAME...");
				String name = sc.next();
				
				while(true) {
					
					System.out.println("Input PRICE...");
				
					try {
						price = sc.nextDouble();
						break;
					}catch(InputMismatchException e) {
						System.out.println("가격은 숫자로 입력하세요");
						sc.next(); // 커서 처리
					}
					
				}
				
				while(true) {
				
					System.out.println("Input Quantity...");
					
					try {
						qt = Integer.parseInt(sc.next());
						break;
					}catch(NumberFormatException e) {
						System.out.println("수량은 숫자로 입력하세요");
						sc.next(); // 커서 처리
					}
					
				}
			
				item = new ItemDTO(id, name, price, qt); //데이터 운반 객체 생성
				try {
					service.remove(id);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(MakeMessage.makeMessage(e.getMessage()));
				}
					
			}else if(cmd.equals("u")) {
				
				while(true) {
					
					System.out.println("Input ID...");
				
					try {
						id = sc.nextInt();				
						break;	
					}catch(InputMismatchException e) {
						System.out.println("잘못 입력하셨습니다. 다시 입력해주세요. ");
						sc.next(); // 커서 처리
					}
					
				}		
				
				System.out.println("Input NAME...");
				String name = sc.next();
				
				while(true) {
					
					System.out.println("Input PRICE...");
				
					try {
						price = sc.nextDouble();
						break;
					}catch(InputMismatchException e) {
						System.out.println("가격은 숫자로 입력하세요");
						sc.next(); // 커서 처리
					}
					
				}
				
				while(true) {
				
					System.out.println("Input Quantity...");
					
					try {
						qt = Integer.parseInt(sc.next());
						break;
					}catch(NumberFormatException e) {
						System.out.println("수량은 숫자로 입력하세요");
						sc.next(); // 커서 처리
					}
					
				}
			
				item = new ItemDTO(id, name, price, qt); //데이터 운반 객체 생성
				try {
					service.modify(item);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(MakeMessage.makeMessage(e.getMessage()));
				}
			}
		}
		
		sc.close();

	}

	@Override
	public void register(Object v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Object k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(Object v) throws Exception {
		// TODO Auto-generated method stub
		
	}
}

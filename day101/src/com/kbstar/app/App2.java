package com.kbstar.app;

import java.util.List;
import java.util.Scanner;

import com.kbstar.dao.ItemDAO;
import com.kbstar.dto.ItemDTO;
import com.kbstar.frame.DAO;

public class App2 {

   public static void main(String[] args) {
	   
	  DAO<Integer, ItemDTO> itemdao = new ItemDAO();
      Scanner sc = new Scanner(System.in);
      
      int id; // 상품번호 (primary key)
      String name; // 상품이름
      double price; // 상품가격
      int qt; // 상품갯수
      
      while (true) {
         System.out.println("Input Command(q,i,d,u,s,sa)");
         String cmd = sc.next();
         if (cmd.equals("q")) {
            System.out.println("Bye...");
            break;
         } else if (cmd.equals("i")) {
        	while(true) {
        		try {
        			System.out.println("Input ID...(숫자로만 입력 바람)");
        			id = Integer.parseInt(sc.next());
        			break;
        		}catch(NumberFormatException e) {
        			System.out.println("고객님, 숫자로 입력하세요");
        		}
        	}
        	
            System.out.println("Input PRODUCT NAME...");
            name = sc.next();
            
            while(true) {
            	try {
                    System.out.println("Input PRICE...(숫자로만 입력 바람)");
                    price = Double.parseDouble(sc.next());
                    break;
            	}catch(NumberFormatException e) {
            		System.out.println("고객님, 숫자로 입력하세요");
            	}
            }
            
            while(true) {
            	try {
                    System.out.println("Input QUANTITY...(숫자로만 입력 바람)");
                    qt = Integer.parseInt(sc.next()); 	
                    break;
            	}catch(NumberFormatException e) {
            		System.out.println("고객님, 숫자로 입력하세요");
            	}
            }
            
            ItemDTO item;
			try {
				item = new ItemDTO(id, name, price, qt);
				itemdao.insert(item);
            	System.out.println(item.toString());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}
			
         } else if (cmd.equals("d")) {
        		while(true) {
            		try {
            			System.out.println("Input ID...(숫자로만 입력 바람)");
            			id = Integer.parseInt(sc.next());
            			break;
            		}catch(NumberFormatException e) {
            			System.out.println("고객님, 숫자로 입력하세요");
            		}
            	}
            	
                System.out.println("Input PRODUCT NAME...");
                name = sc.next();
                
                while(true) {
                	try {
                        System.out.println("Input PRICE...(숫자로만 입력 바람)");
                        price = Double.parseDouble(sc.next());
                        break;
                	}catch(NumberFormatException e) {
                		System.out.println("고객님, 숫자로 입력하세요");
                	}
                }
                
                while(true) {
                	try {
                        System.out.println("Input QUANTITY...(숫자로만 입력 바람)");
                        qt = Integer.parseInt(sc.next()); 	
                        break;
                	}catch(NumberFormatException e) {
                		System.out.println("고객님, 숫자로 입력하세요");
                	}
                }
                
                ItemDTO item;
    			try {
    				item = new ItemDTO(id, name, price, qt);
    				itemdao.delete(id);
                	System.out.println(item.toString());
    			} catch (Exception e1) {
    				// TODO Auto-generated catch block
    				System.out.println(e1.getMessage());
    			}
    			
         } else if (cmd.equals("u")) {
     		while(true) {
        		try {
        			System.out.println("Input ID...(숫자로만 입력 바람)");
        			id = Integer.parseInt(sc.next());
        			break;
        		}catch(NumberFormatException e) {
        			System.out.println("고객님, 숫자로 입력하세요");
        		}
        	}
        	
            System.out.println("Input PRODUCT NAME...");
            name = sc.next();
            
            while(true) {
            	try {
                    System.out.println("Input PRICE...(숫자로만 입력 바람)");
                    price = Double.parseDouble(sc.next());
                    break;
            	}catch(NumberFormatException e) {
            		System.out.println("고객님, 숫자로 입력하세요");
            	}
            }
            
            while(true) {
            	try {
                    System.out.println("Input QUANTITY...(숫자로만 입력 바람)");
                    qt = Integer.parseInt(sc.next()); 	
                    break;
            	}catch(NumberFormatException e) {
            		System.out.println("고객님, 숫자로 입력하세요");
            	}
            }
            
            ItemDTO item;
			try {
				item = new ItemDTO(id, name, price, qt);
				itemdao.update(item);
            	System.out.println(item.toString());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}
			
         } else if (cmd.equals("s")) {
             System.out.println("Input ID...");
             id = Integer.parseInt(sc.next());
             
             ItemDTO item = null;
             try {
            	 item = itemdao.select(id);
            	 System.out.println(item);
             } catch (Exception e) {
             	System.out.println(e.getMessage());
             }
         } else if (cmd.equals("sa")) {
        	 List<ItemDTO> list = null;
        	 
        	 try {
				list  = itemdao.select();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
        	 
        	 for (ItemDTO data : list) {
        		 System.out.println(data);
        	 }
        	         	 
         }

      }
      sc.close();
   }
}
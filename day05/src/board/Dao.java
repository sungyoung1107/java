package board;

public class Dao {
	
	public void insert(String str) {
		//누가, 언제, 제목, 내용
		System.out.println("Inserted Oracle Database: "+str);
		
	}
	
	public void update(int num, String str) {
		System.out.println("Updated Oracle Database Row: "+ num + " " + str);		
	}
	
	public void delete(int num) {
		System.out.println("Deleted Oracle Database Row: "+ num);
	}
	
	public String select(int num) {
		return "Hi Database..." ;
	}

}

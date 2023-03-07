package p214;

import java.util.Random;

public class test4 {

	public static void main(String[] args) {
		
		int ar[] = new int[10];
		Random r = new Random();
		
		for(int i=0; i<ar.length ; i++) {
			ar[i] = r.nextInt(10)+1;
		}
		
//		for(int i=0; i < 4 ; i++) {
//			ar[i] = r.nextInt(10)+1;
//		}
		
		for (int data:ar) {
			System.out.println(data);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}

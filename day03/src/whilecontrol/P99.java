package whilecontrol;

public class P99 {

	public static void main(String[] args) {
		
		int bb = 200;
		
		int a =10;
		int aa = 100;
		int d = 20;
		
		for(int i=2;i<10;i++) {
			System.out.printf("%d 단 \n",i);
			for(int j=1;j<10;j++) {
				System.out.printf("%d * %d = %d \n",i,j,(i*j));
			}
		}
	}

}

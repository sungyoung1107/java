package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Test2 {

	public static void main(String[] args) {
		
		Properties props = new Properties();
		String fileName = "file.txt";
		try (FileInputStream in = new FileInputStream(fileName)){
			props.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("문제 발생 !!!!");
			return; //밑에 실행되면 안되니까 함수를 종료해야 한다!
		} 
		
		String ip = props.getProperty("IP_ADDR");
		int port = Integer.parseInt(props.getProperty("PORT"));
		System.out.println(ip);
		System.out.printf("IP 는 %s, PORT는 %d. ", ip, port);
	}

}

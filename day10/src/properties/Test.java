package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Test {

	public static void main(String[] args) {
		
		Properties props = new Properties();
		String fileName = "file.txt";
		FileInputStream in = null;
		try {
			in = new FileInputStream(fileName); // 위에서 exception 발생하면 밑에는 내려가지 않는다.
			props.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();	
			}		
		} // Thread.sleep(2000);  // 2초 후에 다시 실행하자
		
		String ip = props.getProperty("IP_ADDR");
		System.out.println(ip);

	}

}

package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetIpAddress {
	
	public static String getIpAddress() {
		String ipAddr = "";
		Properties props = new Properties();
		String fileName = "file.txt";
		try (FileInputStream in = new FileInputStream(fileName)){
			props.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("문제 발생 !!!!");
		} 
		ipAddr = props.getProperty("IP_ADDR");
		return ipAddr;
	}

}

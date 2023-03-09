package properties;

public class Test3 {

	public static void main(String[] args) {
		String ipAddr = GetIpAddress.getIpAddress();
		System.out.printf("%s로 접속. ", ipAddr);
	}

}

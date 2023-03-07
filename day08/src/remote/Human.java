package remote;

public class Human {

	public static void main(String[] args) {
		
		// 사람은 리모컨을 가지고 있다.
//		Remote remote  = new Remote(); // 인터페이스는 객체를 생성할 수 없다.
//		remote.turnOn();
//		remote.turnoff();
		
		Remote remote_TV  = new TV();
		remote_TV.turnOn();
		remote_TV.turnoff();		
		
		Remote remote_Audio  = new Audio();
		remote_Audio.turnOn();
		remote_Audio.turnoff();	
		
	}

}

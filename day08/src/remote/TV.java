package remote;

public class TV implements Remote {

	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");

	}

	@Override
	public void turnoff() {
		System.out.println("TV를 끕니다.");

	}

}

package remote;

public class Audio implements Remote {

	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다.");

	}

	@Override
	public void turnoff() {
		System.out.println("Audio를 끕니다.");

	}

}

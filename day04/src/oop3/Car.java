package oop3;

public class Car {
	
	private String name;
	private String color;
	private int size;
	private int fsize; // 기름통 사이즈
	private int cfsize; // 현재 기름 사이즈
	
	// 생성자(클래스의 명칭과 동일하게) --> 리턴타입은 존재하지 않는다! 
	public Car(){
	}

	public Car(String name, String color, int size, int fsize) {
		this.name = name;
		this.color = color;
		this.size = size;
		this.fsize = fsize;
	}

	public Car(String name, String color, int size, int fsize, int cfsize) {
		this(name, color, size, fsize);
		this.cfsize = cfsize;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + ", size=" + size + ", fsize=" + fsize + ", cfsize=" + cfsize
				+ "]";
	}
	
	/* 기름을 넣는다.
	 * 기름통 보다 많이 넣으면 - 다시 주유 하세요
	 * 음수 값이 들어가면 - 다시 주유 하세요
	 */
	public void setCfsize(int size) {
//		if(size<=0) {
//			System.out.println("잘못된 값입니다. 다시 주유 하세요.");
//		}else {
//			if(this.fsize < (this.cfsize+size)) { // 기름통 사이즈 < 현재 기름량 + 넣을 기름량
//				System.out.println("기름통 사이즈를 초과하여 주유 실패하였습니다. 다시 주유 하세요.");
//			}else if (this.fsize == (this.cfsize+size)) {
//				this.cfsize+=size;
//				System.out.println("현재 기름은 " + this.cfsize + " 입니다." + " 현재 기름이 꽉 찼습니다.");
//			}else { // 기름통 사이즈 > 현재 기름량 + 넣을 기름량
//				this.cfsize+=size;
//				System.out.println("현재 기름은 " + this.cfsize + " 입니다.");
//			}
//		}
		
		if(size <= 0 || fsize < (cfsize+size)) {
			System.out.println("음수 값이거나 기름통 사이즈를 초과하였습니다. 다시 주유 하세요.");
			return;
		}
		cfsize+=size;
		System.out.println("현재 기름은 " + cfsize + " 입니다.");
	}
	// 주행을 한다.
	// 1리터당 10km를 주행할 수 있다.
	public void go(int distance) {
//		if (this.cfsize == 0) {
//			System.out.println("기름이 없습니다. 주유를 먼저 하세요.");
//		}else if (this.cfsize >= (distance/10)){
//			System.out.printf("%s Go...\n", this.name);
//			this.cfsize -= (distance/10);
//			System.out.println(distance + "km 이동 완료하였습니다.");
//			System.out.println("남아 있는 기름량은 " + this.cfsize + "입니다.");
//		}else {
//			System.out.println("기름이 부족합니다. 주유를 먼저 하세요.");
//		}
		if(cfsize < 0 || cfsize < (distance/10)) {
			System.out.println("주유하시고 출발 하세요");
			return;
		}	
		System.out.printf("%s %d Go ...", this.name, distance);
		cfsize = cfsize - (distance/10);
	}
	
	// 멈춘다.
	public void stop() {
		System.out.printf("%s Stop...", this.name);
	}
	 
}

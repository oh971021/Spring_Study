

public class SIMain {
	public static void main(String[] args) {
		
		// phone
		
		// 1. 버전 출시 후 수정 원하면 싹 다 갈아야함. 
		Iphone i = new Iphone();
		i.logo();	// 생성하면 뭐가 뜨도록 할거임
		
		Galaxy g = new Galaxy();
		g.logo();
		
		System.out.println("---------------");
		
		// 2. 다형성 (상위 타입에 하위타입 넣은거)
			// 객체만 바꿔주면 되는데 다시 수정 다시 배포
			// 여기까지가 java 한계, 다음이 spring		
	}
}

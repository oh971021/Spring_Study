import java.util.Scanner;

// Bad Maintenance : 유지보수가 좋지않다.

// jar 유지보수
// 프로젝트 열기 -> 소스코드 수정 -> 테스트 -> 재배포 (jar/export)
public class BMain {
	public static void main(String[] args) {
		
		// 물건을 샀는데 포인트 적립
		// 구매가격 : 1000 원
			// 적립 포인트 : 100원 - 10% 적립률
		
		Scanner k = new Scanner(System.in);
		
		System.out.println("구매가격 : ");
		int price = k.nextInt();
		
		double pointRate = 0.01;
		
		double point = price * pointRate;
		
		System.out.printf("적립포인트 : %.1f점", point);
		
		
		
	}
}

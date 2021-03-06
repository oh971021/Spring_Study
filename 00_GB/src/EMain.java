import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

// Easy Maintenance : 쉬운 유지보수

// Spring 이 추구하는 스타일 
// 수정이 일어날만한 부분 : 외부파일에 작성한다. (C:\Users\oh971\OneDrive\바탕 화면\m)
// java 에서 그 외부 파일을 불러서 사용한다.
public class EMain {
	public static void main(String[] args) throws IOException {
			
		Scanner k = new Scanner(System.in);
		
		try {	
		
			System.out.println("구매가격 : ");
			int price = k.nextInt();
			
			// 수정이 자주 발생하는 부분 (외부파일에 빼놓기)
			// 역슬러쉬는 두개 써야함. 하나 쓸거면 그냥 슬러쉬로
			FileReader fr = new FileReader("C:\\Users\\oh971\\OneDrive\\바탕 화면\\m\\pointRate.txt"); // 파일 가져오기 (fr에는 파일전체가 들어있음)
			BufferedReader br = new BufferedReader(fr); // 파일 읽기 (br에는 파일의 내용이 담겨있음)
			String pr = br.readLine(); // 한줄씩 읽어옴.
			
			double pointRate = Double.parseDouble(pr);
			
			double point = price * pointRate;
			
			System.out.printf("적립포인트 : %.1f점", point);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

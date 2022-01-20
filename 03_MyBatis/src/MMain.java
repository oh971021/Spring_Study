import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.js.mb.Weather;

public class MMain {
	public static void main(String[] args) {
		
		try {
			SqlSession ss = DBManager_new.Connect();
			
			// 프로토콜 관련 
			HttpsURLConnection huc = null;
			Scanner k = new Scanner(System.in);
			
			System.out.print("city : ");
			String str = k.next();
			
			String url = "https://api.openweathermap.org/data/2.5/weather?q="+ str +"&units=metric&appid=e7b1a57cd2158c8d195bfb24b7597bad";
			
			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();
			
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			
			// json 받은 데이터 파싱하기 (Json Simple, Json Parser 필요)
			JSONParser jp = new JSONParser();
			
			// 만든 객체로 isr(본데이터) 넣어서 파싱준비
			JSONObject weatherData = (JSONObject) jp.parse(isr);
			System.out.println(weatherData);
			
			// 원하는 데이터 추출
			// 온도
			JSONObject main = (JSONObject) weatherData.get("main");
				// JSON Object를 담고 있다.
			System.out.println("현재 온도 : " + main.get("temp"));
			// 국가
			JSONObject sys = (JSONObject) weatherData.get("sys");
			System.out.println("국가 : " + sys.get("country"));
			// 도시			
			System.out.println("도시 : " + weatherData.get("name"));
			// 설명
			JSONArray weather = (JSONArray) weatherData.get("weather");
			JSONObject weatherO = (JSONObject) weather.get(0);
			System.out.println("날씨 : " + weatherO.get("description"));
			
			// API 데이터를 DB에 넣기 MyBatis 작업!
			Weather w = new Weather();
			w.setW_temp(new BigDecimal(main.get("temp") + ""));
			w.setW_country((String)sys.get("country"));
			w.setW_city((String)weatherData.get("name"));
			w.setW_description((String)weatherO.get("description"));
			
			if (ss.insert("jsqqq.regCurWeather", w) == 1) {
				System.out.println("Success");
				ss.commit();
			}
			
			
			
			
		// Exception은 모조리 퉁친다.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.js.mb;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MMain2 {

	public static void main(String[] args) {

		// 콘솔에 DB에 있는거 나오게 함
		
		try {
			SqlSession ss = DBManager_new.Connect();
			
			List<Weather> weathers = ss.selectList("jsqqq.getAllWeather");
			
//			for (Weather w : weathers) {
//				System.out.println(w.getW_city());
//			}
			
			// csv file 만들기
			FileOutputStream fos = new FileOutputStream("C:\\Users\\oh971\\OneDrive\\바탕 화면\\m\\r.csv", true);
			// fos 보다 많은 정보를 빨아들임
			OutputStreamWriter osw = new OutputStreamWriter(fos, "euc-kr");
			// 더 두꺼운거
			BufferedWriter bw = new BufferedWriter(osw);
			
			for (Weather w : weathers) {
				bw.write(w.getW_city() + ",");
				bw.write(w.getW_country() + ",");
				bw.write(w.getW_temp() + ",");
				bw.write(w.getW_description() + ",");
				bw.write(w.getW_date() + "\r\n");
			}
			
			System.out.println("생성 성공!");
			bw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}

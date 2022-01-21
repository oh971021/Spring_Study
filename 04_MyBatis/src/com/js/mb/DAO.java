package com.js.mb;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class DAO {
	public static void getAllProduct(HttpServletRequest request) {

		try {
			SqlSession ss = DBManager_new.Connect();
			
			List<Product> pr = ss.selectList("jsqqq.getAllProduct");
			
			ArrayList<Product> products = new ArrayList<Product>();
			
			Product pp = null;
			
			for (Product p : pr) {
				pp = new Product(p.getP_no(), p.getP_name(), p.getP_price(), p.getP_img(), p.getP_exp());
				products.add(pp);
			}
			
			request.setAttribute("products", products);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void searchProduct(HttpServletRequest request) {
		
		try {
			
			SqlSession ss = DBManager_new.Connect();
			
			String pName = request.getParameter("p_name");

			Product pp = new Product();
			pp.setP_name(pName);
						
			request.setAttribute("products", ss.selectList("jsqqq.searchProduct", pp));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void deleteProduct(HttpServletRequest request) {
		
		try {
			SqlSession ss = DBManager_new.Connect();
			
			int pNo = Integer.parseInt(request.getParameter("p_no"));
			
			Product p = new Product();
			
			p.setP_no(pNo);
			
			if (ss.delete("jsqqq.deleteProduct", p) == 1) {
				ss.commit();
				System.out.println("삭제 성공");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void priceSearchProduct(HttpServletRequest request) {

		try {
			
			SqlSession ss = DBManager_new.Connect();
			
			int pPrice = Integer.parseInt(request.getParameter("p_price"));

			Product pp = new Product();
			pp.setP_price(pPrice);
						
			request.setAttribute("products", ss.selectList("jsqqq.priceSearchProduct", pp));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void searchPriceToPrice(HttpServletRequest request) {

		try {
			
			SqlSession ss = DBManager_new.Connect();
			
			int pPrice1 = Integer.parseInt(request.getParameter("p_price1"));
			int pPrice2 = Integer.parseInt(request.getParameter("p_price2"));

			Map<String, Integer> m = new HashMap<String, Integer>();
			
			m.put("price1", pPrice1);
			m.put("price2", pPrice2);
						
			request.setAttribute("products", ss.selectList("jsqqq.searchPriceToPrice", m));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public static void updateProduct(HttpServletRequest request) {

		int pPrice1 = Integer.parseInt(request.getParameter("p_price1"));
		int pPrice2 = Integer.parseInt(request.getParameter("p_price2"));
		
		try {
			
			SqlSession ss = DBManager_new.Connect();
			
			
			System.out.println("p1 : " + pPrice1);
			System.out.println("p2 : " + pPrice2);

			Map<String, Integer> m = new HashMap<String, Integer>();
			
			m.put("price1", pPrice1);
			m.put("price2", pPrice2);
						
			if (ss.update("jsqqq.updateProduct", m) >= 1) {
				ss.commit();
				System.out.println("수정 성공");
			};
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void regProduct(HttpServletRequest request) {

		String path = request.getSession().getServletContext().getRealPath("img");
		System.out.println(path);
				
		try {
			request.setCharacterEncoding("UTF-8");

			MultipartRequest mr = new MultipartRequest(request, path, 1024*1024*30, "UTF-8", new DefaultFileRenamePolicy());
			
			SqlSession ss = DBManager_new.Connect();

			String pName = mr.getParameter("p_name");
			int pPrice = Integer.parseInt(mr.getParameter("p_price"));
			String pFile = mr.getFilesystemName("p_file");
			String pDate = mr.getParameter("p_exp");
			
			System.out.println(pName);
			System.out.println(pPrice);
			System.out.println(pFile);
			System.out.println(pDate);

			Date pDate2 = Date.valueOf(pDate);
			
			Product p = new Product();
			
			p.setP_name(pName);
			p.setP_price(pPrice);
			p.setP_img(pFile);
			p.setP_exp(pDate2);
			
			if (ss.insert("jsqqq.regProduct", p) >= 1) {
				ss.commit();
				System.out.println("수정 성공");
			};
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

package com.js.smb2;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class ProductDAO {

	@Autowired
	SqlSession ss;
	
	public void getAllProduct(HttpServletRequest req) {
		req.setAttribute("products", ss.getMapper(ProductMapper.class).getAllProduct()); 
	}

	public void delProduct(Product p, HttpServletRequest req) {
		if (ss.getMapper(ProductMapper.class).delProduct(p) >= 1) {
			System.out.println("삭제성공");
		} else {
			System.out.println("삭제실패");
		};
	}

	public void regProduct(Product p, HttpServletRequest req) {
		
		String saveDirectory = req.getSession().getServletContext().getRealPath("resources/file");
		
		try {
			
			// 객체를 밖으로 빼서 사용하자 - 유지보수를 위해서
			MultipartRequest mr = new MultipartRequest(req, saveDirectory, 1024 * 1024 * 30, 
					"UTF-8", new DefaultFileRenamePolicy());
		
			String name = mr.getParameter("p_name");
			String img = mr.getFilesystemName("p_img");
			BigDecimal price = new BigDecimal(mr.getParameter("p_price"));
			String exp = mr.getParameter("p_exp");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
//			System.out.println(name);
//			System.out.println(img);
//			System.out.println(price);
//			System.out.println(exp);
			
			p.setP_name(name);
			p.setP_img(img);
			p.setP_price(price);
			p.setP_exp(sdf.parse(exp));
			
			if (ss.getMapper(ProductMapper.class).regProduct(p) == 1) {
				System.out.println("등록성공");
			} else {
				System.out.println("등록실패");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchName(Product p, HttpServletRequest req) {
		req.setAttribute("products", ss.getMapper(ProductMapper.class).searchProduct(p));
	}

	public void searchPrice(Product p, HttpServletRequest req) {
		req.setAttribute("products", ss.getMapper(ProductMapper.class).searchPrice(p));
	}

	public void searchPriceToPrice(HttpServletRequest req) {
		
		int price1 = Integer.parseInt(req.getParameter("price1"));
		int price2 = Integer.parseInt(req.getParameter("price2"));
		
		System.out.println(price1);
		System.out.println(price2);
		
		Map<String, Integer> m = new HashMap<String, Integer>();
		
		m.put("price1", price1);
		m.put("price2", price2);
		
		req.setAttribute("products", ss.getMapper(ProductMapper.class).searchPriceToPrice(m));
	}

	public void updatePrice(HttpServletRequest req) {
		
		int price1 = Integer.parseInt(req.getParameter("price1"));
		int price2 = Integer.parseInt(req.getParameter("price2"));
		
		System.out.println(price1);
		System.out.println(price2);
		
		Map<String, Integer> m = new HashMap<String, Integer>();
		
		m.put("price1", price1);
		m.put("price2", price2);
		
		if (ss.getMapper(ProductMapper.class).updatePrice(m) >= 1) {
			System.out.println("인상되었습니다.");
		} else {
			System.out.println("인상실패");
		}			
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

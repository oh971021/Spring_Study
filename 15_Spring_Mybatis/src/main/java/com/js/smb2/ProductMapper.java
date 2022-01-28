package com.js.smb2;

import java.util.List;
import java.util.Map;

public interface ProductMapper {

	List<Product> getAllProduct();
	
	int delProduct(Product p);

	int regProduct(Product p);
	
	List<Product> searchProduct(Product p);
	
	List<Product> searchPrice(Product p);
	
	List<Product> searchPriceToPrice(Map<String, Integer> m);
	
	int updatePrice(Map<String, Integer> m);
	
}

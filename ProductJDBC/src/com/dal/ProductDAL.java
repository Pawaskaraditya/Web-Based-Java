package com.dal;

import java.util.List;

import com.pojo.Product;

public interface ProductDAL {
	
	List<Product> getAllProducts();
	
	int addProduct(Product obj);
	
	int updateProduct(Product obj);
	
	int deleteProduct(int id);

}

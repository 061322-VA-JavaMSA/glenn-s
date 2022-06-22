package com.revature.daos;

import java.util.List;

import com.revature.models.Product;

public interface ProductDAO  {
	Product createProduct(Product p);
	Product retrieveProductById(int id);
	List<Product> retrieveProducts();
	boolean updateProduct(Product p);
	boolean deleteProductById(int id);
}

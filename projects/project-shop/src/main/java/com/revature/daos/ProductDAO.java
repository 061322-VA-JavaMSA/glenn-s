package com.revature.daos;

import java.sql.ResultSet;
import java.util.List;

import com.revature.models.Product;
import com.revature.models.User;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface ProductDAO  {
	Product createProduct(Product p);
	Product retrieveProductById(int id);
	List<Product> retrieveProducts();
	boolean updateProduct(Product p);
	boolean deleteProductById(int id);
	boolean resetProduct(int id);
	boolean payProduct(Product p);
	List<Product>  retrieveProductByUserId(int id);
	boolean setProducttoUser(Product p);
	Product returnData(ResultSet rs,Product p);
	List<Product> retrieveProductsOwned(int i);
	List<Product> getPreparedStatement(String sql);
	List<Product> retrieveProductByName(String n);
	Product retrieveProductByNameExact(String n);


}

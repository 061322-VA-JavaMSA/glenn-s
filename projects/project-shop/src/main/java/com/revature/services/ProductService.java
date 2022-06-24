package com.revature.services;

import java.util.List;

import com.revature.daos.ProductDAO;
import com.revature.daos.ProductPostgres;
import com.revature.models.Product;

public class ProductService {
	private ProductDAO pd = new ProductPostgres();

	public List<Product> getProducts() {
		return pd.retrieveProducts();
	}

	public List<Product> getProducts(int i) {
		return pd.retrieveProductsOwned(i);
	}
	
	public Product createProduct(Product ps) {
		return pd.createProduct(ps);
	}

	public Product getProductByID(int id) {
		return pd.retrieveProductById(id);
	}

	public boolean setProduct(Product ps) {
		return pd.updateProduct(ps);
	}

	public boolean deleteProductById(int id) {
		return pd.deleteProductById(id);
	}

	public boolean setProducttoUser(Product ps) {
		return pd.setProducttoUser(ps);
	}

	public boolean resetProduct(Product ps) {
		return pd.resetProduct(ps);
	}

	public List<Product> retrieveProductByUserId(int id) {
		return pd.retrieveProductByUserId(id);
	}

	public boolean payProduct(Product ps) {
		return pd.payProduct(ps);
	}
}

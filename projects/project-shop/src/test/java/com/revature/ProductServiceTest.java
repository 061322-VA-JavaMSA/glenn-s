package com.revature;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import com.revature.models.Product;
import com.revature.services.ProductService;

import org.junit.jupiter.api.Disabled;

public class ProductServiceTest {
	private static ProductService pservice;
	
	@BeforeAll
	public static void setUp() {
		pservice = new ProductService();
		
	}	
	
	//createProduct,getProductByID,deleteProductById
 	@Test
 	public void addProduct() {
 		Product pcreate = new Product();
 		pcreate.setProduct_name("test");
 		pcreate.setPrice(20);
 		Product actual = pservice.createProduct(pcreate);
 		Product expected = pservice.getProductByID(actual.getId());
 		assertEquals(expected,actual);
 		pservice.deleteProductById(actual.getId());
 	}

}

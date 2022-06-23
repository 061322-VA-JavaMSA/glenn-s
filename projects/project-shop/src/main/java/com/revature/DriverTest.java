package com.revature;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Product;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.ProductService;
import com.revature.services.RoleService;
import com.revature.services.UserService;

public class DriverTest {
	static UserService us;
	static RoleService rs;
	static ProductService ps;
	
	public static void main(String[] args) {
		
		ps = new ProductService();
		
//		us = new UserService();
//		List<User> users = us.getUsers();
//		for(User u : users) {
//			System.out.println(u);
//		}	
//		rs = new RoleService();
//		List<Role> roles = rs.getRoles();
//		for(Role r : roles) {
//			System.out.println(r);
//		}		
		
//		
//		List<Product> products = ps.getProducts();
//		for (Product p : products) {
//			System.out.println(p);
//		}

//		Product productTBC = new Product();
//		productTBC.setId(5);
//		productTBC.setPrice(10.00);
//		productTBC.setProduct_name(new String("Pusheen"));
//		if(ps.setProduct(productTBC)) {
//			System.out.println("working");
//		} 		
		 	
	}
	
 
}

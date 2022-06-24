package com.revature;

import java.util.List;
import java.util.Scanner;

import com.revature.daos.OfferDAO;
import com.revature.daos.OfferPostgres;
import com.revature.exceptions.LoginException;
import com.revature.models.Offer;
import com.revature.models.Product;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.ProductService;
import com.revature.services.RoleService;
import com.revature.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DriverTest {
	static Scanner scan;
	static UserService us;
	static RoleService rs;
	static ProductService ps;
	static Offer o;
	private static Logger log = LogManager.getLogger(Driver.class);
	static AuthService as;

	public static void main(String[] args) {
		as = new AuthService();

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
//		OfferDAO od = new OfferPostgres();  
//		Offer offer = off.retrieveOfferById(50);
//		//System.out.println(offer);
//		if(off.verifyAcceptOffer(offer)) {
//			System.out.println("working");
//		} else {
//			System.out.println("false accept exist");
//		}
//		if(off.acceptOffer(offer)) {
//			System.out.println("working");
//		}
//		List<Offer> offers  = od.retrieveOffers();
//		for (Offer o : offers) {
//			System.out.println(o);
//		} 
//		scan = new Scanner(System.in);
//		
//		String username = null;
//		String password = null;		
//		System.out.println("Please enter username:");
//		username = scan.nextLine();
//		System.out.println("Please enter password:");
//		password = scan.nextLine();
//		
//		try {
//			log.info(as.login(username, password));
//		} catch (LoginException e) {
//			System.out.println("Invalid credentials.");
//			log.error("Login exception was thrown: " + e.fillInStackTrace());
// 		}		
		
  	}
	
 
}

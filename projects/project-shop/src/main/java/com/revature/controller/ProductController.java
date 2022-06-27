package com.revature.controller;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Payment;
import com.revature.models.PaymentConn;
import com.revature.models.Product;
import com.revature.models.User;
import com.revature.services.OfferServices;
import com.revature.services.PaymentConService;
import com.revature.services.PaymentService;
import com.revature.services.ProductService;
import com.revature.services.UserService;

public class ProductController {
	private ProductService ps;
	private UserService us;
	private PaymentService pys;
	private PaymentConService pcs;
	private Scanner input = null;
	private List<Product> products = null;
	private User u = null;
	private OfferServices os;
	public ProductController() {
		ps = new ProductService();
		os = new OfferServices();
		us = new UserService();
		pys = new PaymentService();
		pcs = new PaymentConService();
		input = new Scanner(System.in);
	}

 
	public void list() {
		List<Product> products = null;
		System.out.println("Product List");
		products = ps.getProducts(0);
		for (Product p : products) {

			System.out.println(
					"ID: " + p.getId() + " Product Name: " + p.getProduct_name() + " Product Price: " + p.getPrice());
		}
		products = ps.getProducts(1);
		if (products != null) {
			System.out.println("Owned Products");
		}

		for (Product p : products) {
			displayList(p);
		}
		System.out.println("Press enter to continue");
		try {
			System.in.read();
		} catch (Exception e) {
		}

	}

	public void searchname() {
		System.out.println("Product search");
		System.out.println("Type in Product name");
		String pd_name = input.nextLine();
		products = ps.getProductByName(pd_name);
		if (products.size() < 1) {
			System.out.println("Product not found");
		}
		for (Product p : products) {
			displayList(p);
		}
		System.out.println("Press enter to continue");
		try {
			System.in.read();
		} catch (Exception e) {
		}

	}

	public void add() {

		System.out.println("Product add");

		System.out.println("Ener name");
		String pd_name = input.nextLine();
		System.out.println("Enter price");
		Double pd_price = input.nextDouble();
		Product p = new Product();
		p.setProduct_name(pd_name);
		p.setPrice(pd_price);

		Product psearch = ps.retrieveProductByNameExact(pd_name);
		if (psearch != null) {
			System.out.println("name already exist");
		} else {
			ps.createProduct(p);
			System.out.println("Successfully added");
		}

		System.out.println("Press enter to continue");
		try {
			System.in.read();
		} catch (Exception e) {
		}
	}

	public void edit() {
		System.out.println("Product edit");
		System.out.println("Ener name");
		String pd_name = input.nextLine();
		System.out.println("Enter price");
		Double pd_price = input.nextDouble();
		Product p = new Product();
		p.setProduct_name(pd_name);
		p.setPrice(pd_price);
		System.out.println("Press enter to continue");
		try {
			System.in.read();
		} catch (Exception e) {
		}
	}

	public void delete() {
		int id = 0;
		System.out.println("Product Delete");
		System.out.println("Ener Product ID");
		id = input.nextInt();
		Product p = ps.getProductByID(id);
		if (p == null) {
			System.out.println("Cannot find Product");
		} else {
			displayList(p);
			System.out.println("Do you want to delete this product Y/N");
			String choice = input.next();
			switch (choice) {
			case "y":
			case "Y":
				System.out.println("Product has been deleted");
 				pcs.paymentConnProductDelete(id, p.getUser_id());
 				
				ps.deleteProductById(id);
				break;
			case "n":
			case "N":
			default:
				System.out.println("Product was not deleted");
				break;

			}

		}
		System.out.println("Press enter to continue");
		try {
			System.in.read();
		} catch (Exception e) {
		}
	}

	public void resetProduct() {
		int id = 0;
		System.out.println("Product Reset Ownership");
		System.out.println("Ener Product ID");
		id = input.nextInt();
		Product p = ps.getProductByID(id);
		if (p == null) {
			System.out.println("Cannot find product");
		} else if (p.getUser_id() < 1) {
			System.out.println("Product has no user");
		} else {
			displayList(p);
			System.out.println("Do you want to reset this product Y/N");
			String choice = input.next();
			switch (choice) {
			case "y":
			case "Y":
				System.out.println("Product has been reset");
				pcs.resetPaymentConn(id, p.getUser_id());
				os.deleteOfferByProductId(id);
				ps.resetProduct(id);
				break;
			case "n":
			case "N":
			default:
				System.out.println("Product was not reset");
				break;

			}

		}
		System.out.println("Press enter to continue");
		try {
			System.in.read();
		} catch (Exception e) {
		}
	}

	/*
	 * display product
	 */
	public void displayList(Product p) {
		long diff = 0;
		long diffDays = 0;
		long d1 = 0;
		u = null;
		PaymentConn pc = null;
		int usid = 0;
		String extra = new String();
		extra = "";
		usid = p.getUser_id();
		List<Payment> payments = null;
		if (usid > 0) {
			u = us.retrieveUserById(p.getUser_id());
			pc = pcs.getPaymentConnByProductIdUserId(p.getId(), u.getId());
			Payment py = pys.retrievefirstPaymentByUserId(pc.getId());
			payments = pys.retrievePaymentsByConnID(pc.getId());
			diff = d1 - py.getCreated_at().getTime();
			diffDays = diff / (24 * 60 * 60 * 1000);
			extra = " Customer Owned: " + u.getUsername();
			extra += (diffDays > 14) ? " Past Due Days: " + (diffDays - 14) : "";
		}
		System.out.println("ID: " + p.getId() + " Product Name: " + p.getProduct_name() + " Product Price: "
				+ p.getPrice() + extra);
		if(payments != null && payments.size() > 0 ) {
			System.out.println("Payments: ");
			for (Payment payment : payments) {

				System.out.println("Date: " + payment.getCreated_at().toLocalDateTime() + " Paid: " + payment.getPaid());
			}			
		}


	}
}

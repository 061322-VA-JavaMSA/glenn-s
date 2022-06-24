package com.revature.controller;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Product;
import com.revature.services.ProductService;

public class ProductController {
		static Scanner scan;
		static ProductService ps;

		public void startMenu() {
			scan = new Scanner(System.in);
			ps = new ProductService();

			int choice = 0;
			int done = 0;

			while (done == 0) {
				System.out.println("Products Menu:");
				System.out.println("1 = List");
				System.out.println("2 = Search");
				System.out.println("3 = Main Menu");
				choice = scan.nextInt();
				switch (choice) {
				case 1:
					List<Product> products = ps.getProducts(0);
					for (Product p : products) {
						System.out.println("ID: "+p.getId()+" Product Name: "+p.getProduct_name()+" Product Price: "+p.getPrice());
					}
					products = ps.getProducts(1);
					for (Product p : products) {
						System.out.println("ID: "+p.getId()+" Product Name: "+p.getProduct_name()+" Product Price: "+p.getPrice());
					}					
					break;
				case 2:
						
					break;
				case 3:
					done = 1;	
					System.err.println("Bye");
					break;
				default:
					System.err.println("Please try again");
					break;
				}
				
			}			
		}
}

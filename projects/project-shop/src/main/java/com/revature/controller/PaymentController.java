package com.revature.controller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.revature.models.Offer;
import com.revature.models.Payment;
import com.revature.models.PaymentConn;
import com.revature.models.Product;
import com.revature.models.User;
import com.revature.services.OfferServices;
import com.revature.services.PaymentConService;
import com.revature.services.PaymentService;
import com.revature.services.ProductService;
import com.revature.services.UserService;

public class PaymentController {
	private Payment payment;
	private PaymentService pys;
	private PaymentConService pcs;
	private PaymentConn pc;
	private User u;
	private UserService us;
	private Product p;
	private ProductService ps;
	private Scanner input = null;
	private ProductController pcont;
    private OfferServices oservice; 

	public PaymentController() {
		pys = new PaymentService();
		pcs = new PaymentConService();
		pc = new PaymentConn();
		us = new UserService();
		ps = new ProductService();		
		pcont = new ProductController();		
	}
	
	public void allByEmplyee() {
		input = new Scanner(System.in);
		List<Payment> payments = pys.retrievePayments();
		String pname = "";
		for (Payment payment : payments) {
			pname = "none";
			PaymentConn paymentconn = pcs.getPaymentConnById(payment.getPayment_connection_id());
			User user = us.retrieveUserById(paymentconn.getUser_id());
			Product product = ps.getProductByID(paymentconn.getProduct_id());
			if (product != null) {
				pname = product.getProduct_name();
			}
			System.out.println("Date: " + new Date(payment.getCreated_at().getTime()) + " Paid: " + payment.getPaid()
					+ " Product: " + pname + " Customer name: " + user.getUsername());
		}
	}

	public void allByCustomer(User cu) {

		 
		List<Payment> payments = null;
		List<PaymentConn> paymentconns = pcs.getPaymentConnByUserId(cu.getId());
		String pname = "";
		for (PaymentConn paymentconn : paymentconns) {
			payments = pys.retrievePaymentsByConnID(paymentconn.getId());
			for (Payment payment : payments) {
				pname = "none";
				Product product = ps.getProductByID(paymentconn.getProduct_id());
				if (product != null) {
					pname = product.getProduct_name();
				}
				System.out.println("Date: " + new Date(payment.getCreated_at().getTime()) + " Paid: "
						+ payment.getPaid() + " Product: " + pname);
			}
		}
	}
	
	
	public void makepayment(User cu) {
		int id = 0;
		int allow = 1;
		input = new Scanner(System.in);
		System.out.println("Product edit");
		System.out.println("Ener Product ID");
		id = input.nextInt();
		Product p = ps.getProductByID(id);
 
		if (p == null || p.getUser_id() != cu.getId() ) {
			System.out.println("Cannot find Product");
			allow = 0;
		} 
		if(p.getPaid_status() == 1) {
			System.out.println("Product fully paid");
			allow = 0;
		}
		if (allow == 1 ){
			pcont.displayList(p);
			PaymentConn paymentconn = pcs.getPaymentConnByProductIdUserId(id, cu.getId());
			Double paid = pys.retrievePaymentsSumByPC(paymentconn.getId());
			Double amount_left = paymentconn.getOffer_price() - paid;
			System.out.println("Enter payment (amount due:"+amount_left+"): ");
			Double pd_pay = input.nextDouble();
			if(pd_pay > amount_left && pd_pay > 0) {
				System.out.println("Cannot pay more than amount due :"+ amount_left);
			} else {
				if((pd_pay - amount_left) == 0) {
					ps.setProductPaid(id);
					System.out.println("dasdasdasd");
				}	
				Payment py = new Payment();
				py.setPaid(pd_pay);
				py.setPayment_connection_id(paymentconn.getId());
				pys.createPayment(py);
				System.out.println("Thank You for your Payment");
			}
			

		}
		System.out.println("Press enter to continue");
		try {
			System.in.read();
		} catch (Exception e) {
		}
	}	
}

package com.revature.controller;

import java.util.Date;
import java.util.List;

import com.revature.models.Payment;
import com.revature.models.PaymentConn;
import com.revature.models.Product;
import com.revature.models.User;
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

	public void allByEmplyee() {
		pys = new PaymentService();
		pcs = new PaymentConService();
		pc = new PaymentConn();
		us = new UserService();
		ps = new ProductService();
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
		pys = new PaymentService();
		pcs = new PaymentConService();
		pc = new PaymentConn();
		us = new UserService();
		ps = new ProductService();

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
}

package com.revature.controller;

import java.util.List;

import com.revature.models.Payment;
import com.revature.models.PaymentConn;
import com.revature.models.User;
import com.revature.services.PaymentConService;
import com.revature.services.PaymentService;
import com.revature.services.UserService;

public class PaymentController {
	private Payment payment ;
	private PaymentService pys; 
	private PaymentConService pcs; 
	private PaymentConn pc;
	private User u;
	private UserService us;
	public void allByEmplyee() {
		pys = new PaymentService();
		pcs = new PaymentConService();
		pc = new PaymentConn();
		us = new UserService();
		List <Payment> payments = pys.retrievePayments();
		for (Payment payment : payments) {
			PaymentConn paymentconn = pcs.getPaymentConnById(payment.getPayment_connection_id());
		 
			User user = us.retrieveUserById(paymentconn.getUser_id());
			
			System.out.println("Date: " + payment.getCreated_at().toLocalDateTime() + " Paid: " + payment.getPaid() +" Customer name: "+ user.getUsername());
		}
	}
}

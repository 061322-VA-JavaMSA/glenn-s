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

import com.revature.models.Payment;
import com.revature.services.PaymentService;

public class PaymentServiceTest {
	private static PaymentService pservice;

	@BeforeAll
	public static void setUp() {
		pservice = new PaymentService();
	}

	@Test
	public void addPayment() {
		Payment pcreate = new Payment();
		pcreate.setPaid(1);
		pcreate.setPayment_connection_id(12);
		Payment actual = pservice.createPayment(pcreate);
		System.out.println(actual);
		Payment expected = pservice.retrievePaymentById(actual.getId());
		actual.setCreated_at(expected.getCreated_at());
		assertEquals(expected, actual);
		pservice.deletePaymentById(actual.getId());
	}
}

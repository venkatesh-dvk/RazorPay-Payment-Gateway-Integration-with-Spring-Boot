package com.venkat.Rayzorpay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.Rayzorpay.service.RazorPayService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
	
	@Autowired
	private RazorPayService razorPayService;
	
	@PostMapping("/createOrder")
	public String createOrder(@RequestParam int amount, @RequestParam String currency) {
		try {
			return razorPayService.createOrder(amount, currency, "receipt_123");
		} catch (Exception e) {
			e.printStackTrace();
			return "Error creating order: " + e.getMessage();
		}
	}
}

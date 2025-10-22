package com.venkat.Rayzorpay.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
public class RazorPayService {
	
	@Value("${razorpay.api.key}")
	private String apiKey;
	
	@Value("${razorpay.api.secret}")
	private String apiSecret;
	
	public String createOrder(int amount, String currency, String receiptId) throws RazorpayException {
		RazorpayClient client = new RazorpayClient(apiKey, apiSecret);
		JSONObject orderRequest = new JSONObject();
		orderRequest.put("amount", amount* 100); // amount in the smallest currency unit
		orderRequest.put("currency", currency);
		orderRequest.put("receipt", receiptId);
		
		Order order = client.orders.create(orderRequest);
		return order.toString();
	}
}
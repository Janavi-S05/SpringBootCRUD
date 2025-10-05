package com.ecommerce.SpringBootEcom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.SpringBootEcom.model.dto.OrderRequest;
import com.ecommerce.SpringBootEcom.model.dto.OrderResponse;
import com.ecommerce.SpringBootEcom.service.OrderService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/orders/place")
	public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest){
		OrderResponse orderResponse = orderService.placeOrder(orderRequest);;
		return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<OrderResponse>> getAllOrders(){
		List<OrderResponse> responses = orderService.getAllOrders();
		return new ResponseEntity<>(responses,HttpStatus.OK);
	}
	
	
}

package com.ecommerce.SpringBootEcom.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.SpringBootEcom.model.Order;
import com.ecommerce.SpringBootEcom.model.OrderItem;
import com.ecommerce.SpringBootEcom.model.Product;
import com.ecommerce.SpringBootEcom.model.dto.OrderItemRequest;
import com.ecommerce.SpringBootEcom.model.dto.OrderItemResponse;
import com.ecommerce.SpringBootEcom.model.dto.OrderRequest;
import com.ecommerce.SpringBootEcom.model.dto.OrderResponse;
import com.ecommerce.SpringBootEcom.repository.OrderRepo;
import com.ecommerce.SpringBootEcom.repository.ProductRepo;

@Service
public class OrderService {

	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private OrderRepo orderRepo;
	public OrderResponse placeOrder(OrderRequest orderRequest) {
		
		Order order = new Order();
		String orderId = UUID.randomUUID().toString().substring(0,8).toUpperCase();
		order.setOrderId(orderId);
		order.setCustomerName(orderRequest.customerName());
		order.setEmail(orderRequest.email());
		order.setStatus("PLACED");
		order.setOrderDate(LocalDate.now());
		
		List<OrderItem> orderItems = new ArrayList<>();
		for(OrderItemRequest itemReq:orderRequest.items())
		{
			Product product = productRepo.findById(itemReq.productId())
					.orElseThrow(() -> new RuntimeException("Product not found"));
			
			product.setStockQuantity(product.getStockQuantity()-itemReq.quantity());
			productRepo.save(product);
			
//			OrderItem orderItem = OrderItem.builder()
//					.product(product)
//					.quantity(itemReq.quantity())
//					.totalPrice(product.getPrice().multiply(BigDecimal.valueOf(itemReq.quantity())))
//					.order(order)
//					.build();
			// Same as above
			OrderItem orderItem = new OrderItem();
			orderItem.setProduct(product);
			orderItem.setQuantity(itemReq.quantity());
			orderItem.setTotalPrice(product.getPrice().multiply(BigDecimal.valueOf(itemReq.quantity())));
			orderItem.setOrder(order);
			
			orderItems.add(orderItem);
		}
		
		order.setOrderItems(orderItems);
		Order saveOrder = orderRepo.save(order);
		
		List<OrderItemResponse> itemResponses = new ArrayList<>();
		for(OrderItem item: order.getOrderItems()) {
			OrderItemResponse orderItemResponse = new OrderItemResponse(
					item.getProduct().getName(),
					item.getQuantity(),
					item.getTotalPrice()
					);
			itemResponses.add(orderItemResponse);
		}
		
		OrderResponse orderResponse = new OrderResponse(
				saveOrder.getOrderId(),
				saveOrder.getCustomerName(),
				saveOrder.getEmail(),
				saveOrder.getStatus(),
				saveOrder.getOrderDate(),
				itemResponses
				
				);
		return null;
	}

	public List<OrderResponse> getAllOrders() {
		
		List<Order> orders = orderRepo.findAll();
		List<OrderResponse> orderResponses = new ArrayList<>();
		
		for(Order order: orders)
		{
			
			List<OrderItemResponse> itemResponses = new ArrayList<>();
			
			for(OrderItem item: order.getOrderItems()) {
				OrderItemResponse orderItemResponse = new OrderItemResponse(
						item.getProduct().getName(),
						item.getQuantity(),
						item.getTotalPrice()
						);
				itemResponses.add(orderItemResponse);
			}
			
			OrderResponse orderResponse = new OrderResponse(
					order.getOrderId(),
					order.getCustomerName(),
					order.getEmail(),
					order.getStatus(),
					order.getOrderDate(),
					itemResponses
			);
			orderResponses.add(orderResponse);
			
		}
		
		return orderResponses;
	}

}

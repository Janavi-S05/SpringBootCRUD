package com.ecommerce.SpringBootEcom.model.dto;

public record OrderItemRequest(
		int productId,
		int quantity
	) {
	
}

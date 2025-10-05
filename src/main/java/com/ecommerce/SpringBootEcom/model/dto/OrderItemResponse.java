package com.ecommerce.SpringBootEcom.model.dto;

import java.math.BigDecimal;

public record OrderItemResponse(
		String productName,
		int quantity,
		BigDecimal subTotal
		) {

}

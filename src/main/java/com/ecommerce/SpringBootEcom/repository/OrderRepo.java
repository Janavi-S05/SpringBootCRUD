package com.ecommerce.SpringBootEcom.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.SpringBootEcom.model.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer>{
	Optional<Order> findByOrderId(String orderId);
}

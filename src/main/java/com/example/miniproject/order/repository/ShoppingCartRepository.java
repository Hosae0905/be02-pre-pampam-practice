package com.example.miniproject.order.repository;

import com.example.miniproject.order.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
}

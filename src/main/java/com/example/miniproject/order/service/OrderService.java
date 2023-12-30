package com.example.miniproject.order.service;

import com.example.miniproject.order.repository.OrderRepository;
import com.example.miniproject.order.repository.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ShoppingCartRepository shoppingCartRepository;

    public void buy() {

    }

    public void orderList() {

    }

    public void sellInfo() {

    }

    public void addToCart() {

    }
}

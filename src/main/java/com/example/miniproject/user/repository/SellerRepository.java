package com.example.miniproject.user.repository;

import com.example.miniproject.user.model.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    Optional<Seller> findBySellerId(String sellerId);
}

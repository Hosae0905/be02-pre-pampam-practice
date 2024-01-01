package com.example.miniproject.user.repository;

import com.example.miniproject.user.model.entity.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConsumerRepository extends JpaRepository<Consumer, Long> {
    Optional<Consumer> findByConsumerId(String consumerId);
    Optional<Consumer> findByUsername(String userName);
}

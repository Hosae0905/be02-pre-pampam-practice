package com.example.miniproject.product.repository;

import com.example.miniproject.product.model.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}

package com.example.miniproject.product.model.entity;

import com.example.miniproject.user.model.entity.Seller;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller sellerInfo;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}

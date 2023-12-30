package com.example.miniproject.user.model.entity;

import com.example.miniproject.product.model.entity.Product;
import com.example.miniproject.user.model.PostConsumerSignUpReq;
import com.example.miniproject.user.model.PostSellerSignUpReq;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sellerId;
    private String password;
    private String name;
    private String address;
    private String tel;
    private String businessNumber;

    @OneToMany(mappedBy = "seller")
    List<Product> products = new ArrayList<>();

    public static Seller dtoToEntity(PostSellerSignUpReq sellerSignUpReq) {
        return Seller.builder()
                .sellerId(sellerSignUpReq.getSellerId())
                .password(sellerSignUpReq.getPassword())
                .name(sellerSignUpReq.getName())
                .address(sellerSignUpReq.getAddress())
                .tel(sellerSignUpReq.getTel())
                .businessNumber(sellerSignUpReq.getBusinessNumber())
                .build();
    }
}

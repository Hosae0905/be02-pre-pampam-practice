package com.example.miniproject.user.model.entity;

import com.example.miniproject.product.model.entity.Image;
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
    private String authority;

    @OneToMany(mappedBy = "seller")
    List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "sellerInfo")
    List<Image> imageList = new ArrayList<>();

    public static Seller dtoToEntity(PostSellerSignUpReq sellerSignUpReq) {
        return Seller.builder()
                .sellerId(sellerSignUpReq.getSellerId())
                .password(sellerSignUpReq.getPassword())
                .name(sellerSignUpReq.getName())
                .address(sellerSignUpReq.getAddress())
                .tel(sellerSignUpReq.getTel())
                .businessNumber(sellerSignUpReq.getBusinessNumber())
                .authority("USER_SELLER")
                .build();
    }
}

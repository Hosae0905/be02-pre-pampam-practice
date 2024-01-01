package com.example.miniproject.product.model.entity;

import com.example.miniproject.product.model.PostRegisterProductReq;
import com.example.miniproject.user.model.entity.Seller;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String name;
    private Integer price;
    private String info;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @ManyToOne
    @JoinColumn(name = "Category_Id")
    private Category category;

    @OneToMany(mappedBy = "product")
    List<Image> imageList = new ArrayList<>();

    public static Product dtoToEntity(PostRegisterProductReq registerProductReq) {

        return Product.builder()
                .name(registerProductReq.getName())
                .price(registerProductReq.getPrice())
                .info(registerProductReq.getInfo())
                .seller(Seller.builder().id(registerProductReq.getId()).build())
                .build();
    }

}

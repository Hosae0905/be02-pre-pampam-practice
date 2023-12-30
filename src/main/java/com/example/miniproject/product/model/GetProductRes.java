package com.example.miniproject.product.model;

import com.example.miniproject.product.model.entity.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetProductRes {
    private String name;
    private Integer price;
    private String info;

    public static GetProductRes entityToDto(Product product) {
        return GetProductRes.builder()
                .name(product.getName())
                .price(product.getPrice())
                .info(product.getInfo())
                .build();
    }
}

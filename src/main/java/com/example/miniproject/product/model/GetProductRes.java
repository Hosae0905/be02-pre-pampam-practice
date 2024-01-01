package com.example.miniproject.product.model;

import com.example.miniproject.product.model.entity.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class GetProductRes {
    private String name;
    private Integer price;
    private String info;
    private List<ImageDto> imageList = new ArrayList<>();

    public static GetProductRes entityToDto(Product product, List<ImageDto> images) {
        return GetProductRes.builder()
                .name(product.getName())
                .price(product.getPrice())
                .info(product.getInfo())
                .imageList(images)
                .build();
    }
}

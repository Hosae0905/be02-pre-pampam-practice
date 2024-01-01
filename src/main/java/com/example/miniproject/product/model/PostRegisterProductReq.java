package com.example.miniproject.product.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class PostRegisterProductReq {
    private String name;
    private Integer price;
    private String info;
    private Long id;
    private MultipartFile image;
}

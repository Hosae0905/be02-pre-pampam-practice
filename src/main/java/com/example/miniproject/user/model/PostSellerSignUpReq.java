package com.example.miniproject.user.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PostSellerSignUpReq {
    private String sellerId;
    private String password;
    private String name;
    private String address;
    private String tel;
    private String businessNumber;
}

package com.example.miniproject.user.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PostConsumerSignUpReq {
    private String consumerId;
    private String password;
    private String name;
    private String address;
    private String tel;
    private String businessNumber;
}

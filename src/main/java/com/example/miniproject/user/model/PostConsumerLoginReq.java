package com.example.miniproject.user.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostConsumerLoginReq {
    private String consumerId;
    private String password;
}

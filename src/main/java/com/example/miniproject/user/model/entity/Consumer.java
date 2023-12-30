package com.example.miniproject.user.model.entity;

import com.example.miniproject.user.model.PostConsumerSignUpReq;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Consumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String consumerId;
    private String password;
    private String name;
    private String address;
    private String tel;

    public static Consumer dtoToEntity(PostConsumerSignUpReq consumerSignUpReq) {
        return Consumer.builder()
                .consumerId(consumerSignUpReq.getConsumerId())
                .password(consumerSignUpReq.getPassword())
                .name(consumerSignUpReq.getName())
                .address(consumerSignUpReq.getAddress())
                .tel(consumerSignUpReq.getTel())
                .build();
    }
}

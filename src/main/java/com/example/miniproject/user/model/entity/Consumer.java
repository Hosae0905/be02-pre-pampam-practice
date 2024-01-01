package com.example.miniproject.user.model.entity;

import com.example.miniproject.user.model.PostConsumerSignUpReq;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Consumer implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String consumerId;
    private String password;
    private String username;
    private String address;
    private String tel;
    private String authority;

    public static Consumer dtoToEntity(PostConsumerSignUpReq consumerSignUpReq) {
        return Consumer.builder()
                .consumerId(consumerSignUpReq.getConsumerId())
                .password(consumerSignUpReq.getPassword())
                .username(consumerSignUpReq.getName())
                .address(consumerSignUpReq.getAddress())
                .tel(consumerSignUpReq.getTel())
                .authority("USER_CUSTOMER")
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

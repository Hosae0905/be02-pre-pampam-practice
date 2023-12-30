package com.example.miniproject.user.controller;

import com.example.miniproject.user.model.PostConsumerLoginReq;
import com.example.miniproject.user.model.PostConsumerSignUpReq;
import com.example.miniproject.user.model.PostSellerLoginReq;
import com.example.miniproject.user.model.PostSellerSignUpReq;
import com.example.miniproject.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/consumer/signup")
    public ResponseEntity<Object> signUp(@RequestBody PostConsumerSignUpReq signUpReq) {
        userService.consumerSignUp(signUpReq);
        return ResponseEntity.ok().body("ok");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/seller/signup")
    public ResponseEntity<Object> signUp(@RequestBody PostSellerSignUpReq signUpReq) {
        userService.sellerSignUp(signUpReq);
        return ResponseEntity.ok().body("ok");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/consumer/login")
    public ResponseEntity<Object> login(@RequestBody PostConsumerLoginReq loginReq) {
        return ResponseEntity.ok().body(userService.consumerLogin(loginReq));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/seller/login")
    public ResponseEntity<Object> login(@RequestBody PostSellerLoginReq loginReq) {
        return ResponseEntity.ok().body(userService.sellerLogin(loginReq));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/seller/list")
    public ResponseEntity<Object> getList(Long id) {
        return ResponseEntity.ok().body(userService.sellList(id));
    }
}

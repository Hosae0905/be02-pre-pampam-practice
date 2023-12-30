package com.example.miniproject.product.controller;

import com.example.miniproject.product.model.PostRegisterProductReq;
import com.example.miniproject.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ResponseEntity<Object> register(@RequestBody PostRegisterProductReq registerProductReq) {
        productService.register(registerProductReq);
        return ResponseEntity.ok().body("ok");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity<Object> getProductList() {
        return ResponseEntity.ok().body(productService.getProductList());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public ResponseEntity<Object> searchProduct(Long id) {
        return ResponseEntity.ok().body(productService.searchProduct(id));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public ResponseEntity<Object> delete(Long productId) {
        productService.delete(productId);
        return ResponseEntity.ok().body("ok");
    }
}

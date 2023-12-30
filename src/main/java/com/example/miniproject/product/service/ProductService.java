package com.example.miniproject.product.service;

import com.example.miniproject.product.model.GetProductRes;
import com.example.miniproject.product.model.PostRegisterProductReq;
import com.example.miniproject.product.model.entity.Product;
import com.example.miniproject.product.repository.ProductRepository;
import com.example.miniproject.user.model.entity.Seller;
import com.example.miniproject.user.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void register(PostRegisterProductReq registerProductReq) {
        productRepository.save(Product.dtoToEntity(registerProductReq));
    }

    public GetProductRes searchProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return GetProductRes.builder()
                    .name(product.get().getName())
                    .price(product.get().getPrice())
                    .info(product.get().getInfo())
                    .build();
        } else {
            return null;
        }
    }

    public List<GetProductRes> getProductList() {
        List<Product> list = productRepository.findAll();
        List<GetProductRes> productList = new ArrayList<>();

        for (Product product : list) {
            productList.add(GetProductRes.entityToDto(product));
        }

        return productList;
    }

    public void delete(Long id) {
        productRepository.delete(Product.builder().productId(id).build());

    }

    public void selectCategory() {

    }

}

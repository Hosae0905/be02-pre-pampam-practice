package com.example.miniproject.user.service;

import com.example.miniproject.product.model.GetProductRes;
import com.example.miniproject.product.model.entity.Product;
import com.example.miniproject.user.model.PostConsumerLoginReq;
import com.example.miniproject.user.model.PostConsumerSignUpReq;
import com.example.miniproject.user.model.PostSellerLoginReq;
import com.example.miniproject.user.model.PostSellerSignUpReq;
import com.example.miniproject.user.model.entity.Consumer;
import com.example.miniproject.user.model.entity.Seller;
import com.example.miniproject.user.repository.ConsumerRepository;
import com.example.miniproject.user.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ConsumerRepository consumerRepository;
    private final SellerRepository sellerRepository;

    public void consumerSignUp(PostConsumerSignUpReq consumerSignUpReq) {
        consumerRepository.save(Consumer.dtoToEntity(consumerSignUpReq));
    }

    public void sellerSignUp(PostSellerSignUpReq sellerSignUpReq) {
        sellerRepository.save(Seller.dtoToEntity(sellerSignUpReq));
    }

    public String consumerLogin(PostConsumerLoginReq loginReq) {
        Optional<Consumer> consumer = consumerRepository.findByConsumerId(loginReq.getConsumerId());

        if (consumer.isPresent() && consumer.get().getPassword().equals(loginReq.getPassword())) {
            return "ok";
        } else {
            return null;
        }
    }

    public String sellerLogin(PostSellerLoginReq loginReq) {
        Optional<Seller> seller = sellerRepository.findBySellerId(loginReq.getSellerId());

        if (seller.isPresent() && seller.get().getPassword().equals(loginReq.getPassword())) {
            return "ok";
        } else {
            return null;
        }
    }

    public List<GetProductRes> sellList(Long id) {
        Optional<Seller> seller = sellerRepository.findById(id);
        List<GetProductRes> productList = new ArrayList<>();
        if (seller.isPresent()) {
            List<Product> products = seller.get().getProducts();

            for (Product product : products) {
                productList.add(GetProductRes.builder()
                        .name(product.getName())
                        .price(product.getPrice())
                        .info(product.getInfo())
                        .build());
            }

            return productList;
        } else {
            return null;
        }

    }

//    public void update() {
//
//    }
}

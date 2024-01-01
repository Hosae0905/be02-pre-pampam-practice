package com.example.miniproject.product.service;

import com.example.miniproject.product.model.GetProductRes;
import com.example.miniproject.product.model.ImageDto;
import com.example.miniproject.product.model.PostRegisterProductReq;
import com.example.miniproject.product.model.entity.Image;
import com.example.miniproject.product.model.entity.Product;
import com.example.miniproject.product.repository.ImageRepository;
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
    private final ImageRepository imageRepository;
    private final SaveImageService saveImageService;

    public void register(PostRegisterProductReq registerProductReq) {
        String saveFile = saveImageService.saveFile(registerProductReq.getImage());

        imageRepository.save(Image.builder()
                .image(saveFile)
                .sellerInfo(Seller.builder().id(registerProductReq.getId()).build())
                .product(Product.builder().name(registerProductReq.getName()).build())
                .build());

        productRepository.save(Product.dtoToEntity(registerProductReq));
    }

    public GetProductRes searchProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {

            List<ImageDto> images = new ArrayList<>();

            for (Image image : product.get().getImageList()) {
                images.add(ImageDto.builder().image(image.getImage()).build());
            }

            return GetProductRes.entityToDto(product.get(), images);
        } else {
            return null;
        }
    }

    public List<GetProductRes> getProductList() {
        List<Product> list = productRepository.findAll();
        List<GetProductRes> productList = new ArrayList<>();

        for (Product product : list) {

            List<ImageDto> images = new ArrayList<>();

            for (Image image : product.getImageList()) {
                images.add(ImageDto.builder().image(image.getImage()).build());
            }

            productList.add(GetProductRes.entityToDto(product, images));
        }

        return productList;
    }

    public void delete(Long id) {
        productRepository.delete(Product.builder().productId(id).build());

    }

    public void selectCategory() {

    }

}

package com.inditex.zarachallenge.app.service;

import com.inditex.zarachallenge.domain.mappers.ProductMapper;
import com.inditex.zarachallenge.domain.repo.ProductOfferRepository;
import com.inditex.zarachallenge.infrastructure.model.ProductAvailabilityEvent;
import com.inditex.zarachallenge.infrastructure.model.ProductOfferDTO;
import com.inditex.zarachallenge.infrastructure.model.ProductSizeDTO;
import com.inditex.zarachallenge.domain.repo.ProductSizeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Value("${date}")
    private String date;
    @Autowired
    private final ProductSizeRepository productRepository;

    @Autowired
    private final ProductOfferRepository productOfferRepository;

    private final ProductMapper productMapper;

    public ProductService(ProductSizeRepository productRepository, ProductOfferRepository productOfferRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productOfferRepository = productOfferRepository;
        this.productMapper = productMapper;
    }

    public void updateStockAvailability(ProductAvailabilityEvent event) {
        ProductSizeDTO optionalProductSize = productRepository.findById(event.getSizeId())
                .orElseThrow(EntityNotFoundException::new);
        ProductSizeDTO product = productMapper.mapToTable(optionalProductSize, event);
        productRepository.save(product);
    }

    public List<?> getSimilarProducts(Long productId) {
        //Get similar products by price range
        ProductOfferDTO toBuyProduct = productOfferRepository.findByProductIdAndValidFrom(productId, date)
                .orElseThrow(EntityNotFoundException::new);

        return productOfferRepository.findByPriceBetween(toBuyProduct.getPrice().subtract(BigDecimal.TEN), toBuyProduct.getPrice().add(BigDecimal.TEN));
    }
}

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
    private ProductSizeRepository productRepository;

    @Autowired
    private ProductOfferRepository productOfferRepository;

    private ProductMapper productMapper;

    public void updateStockAvailability(ProductAvailabilityEvent event) {
        Optional<ProductSizeDTO> optionalProductSize = productRepository.findById(event.getSizeId());
        ProductSizeDTO product;
        if (optionalProductSize.isPresent()) {
            product = productMapper.mapToTable(optionalProductSize.get(), event);
            productRepository.save(product);
        } else {
            throw new EntityNotFoundException();
        }

    }

    public List<?> getSimilarProducts(Long productId) {
        //Get similar products by price range
        ProductOfferDTO toBuyProduct = productOfferRepository.findByProductIdAndValidFrom(productId, date);

        return productOfferRepository.findByPriceBetween(toBuyProduct.getPrice().subtract(BigDecimal.TEN), toBuyProduct.getPrice().add(BigDecimal.TEN));
    }
}

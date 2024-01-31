package com.inditex.zarachallenge.app.service;

import com.inditex.zarachallenge.domain.mappers.ProductMapper;
import com.inditex.zarachallenge.infrastructure.model.ProductAvailabilityEvent;
import com.inditex.zarachallenge.infrastructure.model.ProductSizeDTO;
import com.inditex.zarachallenge.domain.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private ProductMapper productMapper;

    public void updateStockAvailability(ProductAvailabilityEvent event) {
        ProductSizeDTO product = productMapper.mapToTable(event);
        productRepository.save(product);
    }
}

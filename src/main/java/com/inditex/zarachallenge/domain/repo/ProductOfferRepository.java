package com.inditex.zarachallenge.domain.repo;

import com.inditex.zarachallenge.infrastructure.model.ProductOfferDTO;
import com.inditex.zarachallenge.infrastructure.model.ProductSizeDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductOfferRepository extends JpaRepository<ProductOfferDTO, Long> {
    ProductOfferDTO findByProductId(Long productId);
    List<ProductOfferDTO> findByPriceBetween(BigDecimal lowPrice, BigDecimal highPrice);

    ProductOfferDTO findByProductIdAndValidFrom(Long productId, String date);
}

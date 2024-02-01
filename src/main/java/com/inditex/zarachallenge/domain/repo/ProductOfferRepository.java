package com.inditex.zarachallenge.domain.repo;

import com.inditex.zarachallenge.infrastructure.model.ProductOfferDTO;
import com.inditex.zarachallenge.infrastructure.model.ProductSizeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductOfferRepository extends JpaRepository<ProductOfferDTO, Long> {
    ProductOfferDTO findByProductId(Long productId);
    List<ProductOfferDTO> findByPriceBetween(BigDecimal lowPrice, BigDecimal highPrice);
    @Query("SELECT o FROM ProductOfferDTO o WHERE o.productId = :productId AND o.validFrom = :date")
    Optional<ProductOfferDTO> findByProductIdAndValidFrom(Long productId, String date);
}

package com.inditex.zarachallenge.infrastructure.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "OFFER")
public class ProductOfferDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String validFrom;
    @Column
    private BigDecimal price;
    @Column
    private Long productId;

    public ProductOfferDTO() {
    }

    public ProductOfferDTO(Long id, String validFrom, BigDecimal price, Long productId) {
        this.id = id;
        this.validFrom = validFrom;
        this.price = price;
        this.productId = productId;
    }
}

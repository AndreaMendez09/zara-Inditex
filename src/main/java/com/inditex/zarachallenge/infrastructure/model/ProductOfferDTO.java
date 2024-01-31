package com.inditex.zarachallenge.infrastructure.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Setter
@Getter
@Entity
@Table(name = "OFFER")
public class ProductOfferDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Timestamp validFrom;
    @Column
    private BigDecimal price;
    @Column
    private Long productId;

}

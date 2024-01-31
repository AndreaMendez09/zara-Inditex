package com.inditex.zarachallenge.infrastructure.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "SIZE")
public class ProductSizeDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sizeId;
    @Column
    private String size;
    @Column
    private boolean availability;
    @Column
    private LocalDateTime lastUpdated;
    @Column
    private Long productId;

    public ProductSizeDTO(Long sizeId, String size, boolean availability, LocalDateTime lastUpdated, Long productId) {
        this.sizeId = sizeId;
        this.size = size;
        this.availability = availability;
        this.lastUpdated = lastUpdated;
        this.productId = productId;
    }

    public ProductSizeDTO() {
    }
}

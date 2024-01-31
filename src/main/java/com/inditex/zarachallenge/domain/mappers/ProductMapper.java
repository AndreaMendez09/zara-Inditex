package com.inditex.zarachallenge.domain.mappers;

import com.inditex.zarachallenge.infrastructure.model.ProductAvailabilityEvent;
import com.inditex.zarachallenge.infrastructure.model.ProductSizeDTO;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductMapper {

    public ProductSizeDTO mapToTable(ProductSizeDTO product, ProductAvailabilityEvent event) {
        product.setAvailability(event.isAvailability());
        product.setLastUpdated(event.getUpdate().toLocalDateTime());
        return product;
    }
}

package com.inditex.zarachallenge.domain.mappers;

import com.inditex.zarachallenge.infrastructure.model.ProductAvailabilityEvent;
import com.inditex.zarachallenge.infrastructure.model.ProductSizeDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductSizeDTO mapToTable(ProductAvailabilityEvent productAvailabilityEvent) {
        return new ProductSizeDTO(
            productAvailabilityEvent.getSizeId(),
            null,
            productAvailabilityEvent.isAvailability(),
            productAvailabilityEvent.getUpdate(),
            null
        );
    }
}

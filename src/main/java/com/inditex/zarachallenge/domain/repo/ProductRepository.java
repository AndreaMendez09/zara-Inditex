package com.inditex.zarachallenge.domain.repo;

import com.inditex.zarachallenge.domain.model.ProductSizeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductSizeDTO, Long> {
}

package com.inditex.zarachallenge.presentation.controller;

import com.inditex.zarachallenge.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class SimilarController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{productId}/similar")
    public List<?> getSimilarProducts(@PathVariable Long productId) {
        return productService.getSimilarProducts(productId);
    }
}

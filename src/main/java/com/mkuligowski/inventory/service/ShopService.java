package com.mkuligowski.inventory.service;

import com.mkuligowski.inventory.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public class ShopService {
    public BigDecimal getTotalPriceProducts(List<Product> products) {
        BigDecimal price = products.stream()
                .map(p -> p.getPrice().multiply(new BigDecimal(String.valueOf(p.getQuantity()))))
                .reduce(BigDecimal.ZERO,(sum, current) -> sum = sum.add(current));
        return price;
    }
}
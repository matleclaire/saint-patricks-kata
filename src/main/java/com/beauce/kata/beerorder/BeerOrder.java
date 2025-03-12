package com.beauce.kata.beerorder;

public record BeerOrder(Beer beer, int quantity) {
    public BeerOrder {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
    }
}

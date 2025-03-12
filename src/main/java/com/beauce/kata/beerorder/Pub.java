package com.beauce.kata.beerorder;

public record Pub(String name) {
    public Pub {
        if (null == name || name.isEmpty()) {
            throw new IllegalArgumentException("Pub name cannot be null or empty");
        }
    }
}

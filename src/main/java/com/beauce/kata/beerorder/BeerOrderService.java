package com.beauce.kata.beerorder;

import java.util.List;

public class BeerOrderService {



    public boolean isOverBudget(BeerOrders beerOrders,
                                double budget) {
        return beerOrders.getTotalPrice() > budget;
    }

    public String generateInvoice(Pub pub,
                                  BeerOrders beerOrders) {

        var result = new StringBuilder("Invoice for %s:\n".formatted(pub.name()));
        beerOrders.forEach(beerOrder -> result.append("%s - %d x %.1f€ = %.1f€\n".formatted(
                beerOrder.beer().name(),
                beerOrder.quantity(),
                beerOrder.beer().price(),
                beerOrder.totalPrice())));
        result.append("Total: %.1f€".formatted(beerOrders.getTotalPrice()));
        return result.toString();
    }
}

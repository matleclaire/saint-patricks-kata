package com.beauce.kata.beerorder;

import java.util.List;

public class BeerOrderService {


    @Deprecated
    public String generateInvoice(Pub pub, List<BeerOrder> beerOrders) {
        StringBuilder result = new StringBuilder("Invoice for %s:\n".formatted(pub.name()));
        for (var beerOrder : beerOrders) {
            result.append("%s - %d x %.1f€ = %.1f€\n".formatted(
                    beerOrder.beer().name(),
                    beerOrder.quantity(),
                    beerOrder.beer().price(),
                    beerOrder.totalPrice()));
        }
        result.append("Total: %.1f€".formatted(beerOrders.stream()
                .mapToDouble(BeerOrder::totalPrice)
                .sum()));
        return result.toString();
    }

    public boolean isOverBudget(List<Integer> quantities, List<Double> unitPrices, double budget) {
        double totalCost = 0;
        for (int i = 0; i < quantities.size(); i++) {
            totalCost += quantities.get(i) * unitPrices.get(i);
        }

        return totalCost > budget;
    }

    public String generateInvoiceNew(Pub pub,
                                  BeerOrders beerOrders) {

        return generateInvoice(pub, beerOrders.getBeerOrders());
//        var result = new StringBuilder("Invoice for %s:\n".formatted(pub.name()));
//        beerOrders.forEach(beerOrder -> result.append("%s - %d x %.1f€ = %.1f€\n".formatted(
//                beerOrder.beer().name(),
//                beerOrder.quantity(),
//                beerOrder.beer().price(),
//                beerOrder.totalPrice())));
//        result.append("Total: %.1f€".formatted(beerOrders.getTotalPrice()));
//        return result.toString();
    }
}

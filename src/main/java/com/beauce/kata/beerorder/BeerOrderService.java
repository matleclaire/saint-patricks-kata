package com.beauce.kata.beerorder;

import java.util.List;

public class BeerOrderService {

    @Deprecated
    public String generateInvoiceOld(Pub pub, List<String> beerNames, List<Integer> quantities, List<Double> unitPrices) {
        double totalCost = 0;
        StringBuilder invoice = new StringBuilder("Invoice for " + pub.name() + ":\n");

        for (int i = 0; i < beerNames.size(); i++) {
            double cost = quantities.get(i) * unitPrices.get(i);
            totalCost += cost;
            invoice.append(beerNames.get(i))
                    .append(" - ")
                    .append(quantities.get(i))
                    .append(" x ")
                    .append(unitPrices.get(i))
                    .append("€ = ")
                    .append(cost)
                    .append("€\n");
        }

        invoice.append("Total: ").append(totalCost).append("€");
        return invoice.toString();
    }

    public String generateInvoiceNEW(Pub pub, List<BeerOrder> beerOrders) {
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
}

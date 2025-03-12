package com.beauce.kata.beerorder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BeerOrderServiceTest {
    private BeerOrderService service;

    @BeforeEach
    void setup() {
        this.service = new BeerOrderService();
    }

    @Test
    void shouldGenerateInvoiceCorrectly() {
        var invoice = service.generateInvoice(
                new Pub("O’Malley’s Pub"), List.of("Guinness", "Kilkenny"),
                List.of(10, 5),
                List.of(5.0, 4.5)
        );

        assertThat(invoice)
                .contains(
                        "Guinness - 10 x 5.0€ = 50.0€",
                        "Kilkenny - 5 x 4.5€ = 22.5€",
                        "Total: 72.5€");
    }

    @Test
    void shouldDetectOverBudgetOrders() {
        assertThat(
                service.isOverBudget(
                        List.of(20, 15),
                        List.of(6.0, 5.5),
                        100.0
                )
        ).isTrue();
    }

    @Test
    void shouldNotDetectOverBudgetOrders() {
        assertThat(
                service.isOverBudget(
                        List.of(5, 2),
                        List.of(5.0, 4.0),
                        100.0
                )
        ).isFalse();
    }
}

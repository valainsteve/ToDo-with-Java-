package de.uniba.wiai.dsg.ajp.assignment3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LowBudgetPriceTests {
    Price lowBudgetPrice;

    @BeforeEach
    public void setUp() {
        lowBudgetPrice = new LowBudgetPrice();
    }

    @Test
    public void getChargeReturnsCorrectAmountIfDaysRentedIs1() {
        assertEquals(0.5, lowBudgetPrice.getCharge(1));
    }

    @Test
    public void getChargeReturnsCorrectAmountIfDaysRentedIs2() {
        assertEquals(1.5, lowBudgetPrice.getCharge(2));
    }

    @Test
    public void getChargeReturnsCorrectAmountIfDaysRentedGreaterThan2() {
        assertEquals(3.0, lowBudgetPrice.getCharge(5));
    }

    @Test
    public void getChargeReturnsCorrectAmountIfDaysRentedNegativeOrZero() {
        assertThrows(IllegalArgumentException.class, () -> lowBudgetPrice.getCharge(-10));
        assertThrows(IllegalArgumentException.class, () -> lowBudgetPrice.getCharge(0));
    }

    @Test
    public void getPriceCodeReturnsCorrectPriceCode() {
        assertEquals(PriceCode.LOW_BUDGET, lowBudgetPrice.getPriceCode());
    }

    @Test
    public void getFrequentRenterPointsReturns1() {
        assertEquals(0, lowBudgetPrice.getFrequentRenterPoints(100));
    }
}

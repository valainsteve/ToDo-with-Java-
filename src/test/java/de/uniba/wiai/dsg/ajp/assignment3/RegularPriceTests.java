package de.uniba.wiai.dsg.ajp.assignment3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RegularPriceTests {
    Price regularPrice;

    @BeforeEach
    public void setUp(){
        regularPrice = new RegularPrice();
    }

    @Test
    public void getChargeReturnsCorrectAmountIfDaysRentedGreaterThan2(){
        assertEquals(17, regularPrice.getCharge(12));
    }

    @Test
    public void getChargeReturnsCorrectAmountIfDaysRentedSmallerOrEqualTo2(){
        assertEquals(2, regularPrice.getCharge(2));
    }

    @Test
    public void getChargeReturnsCorrectAmountIfDaysRentedNegativeOrZero(){
        assertThrows(IllegalArgumentException.class, () -> regularPrice.getCharge(-10));
        assertThrows(IllegalArgumentException.class, () -> regularPrice.getCharge(0));
    }

    @Test
    public void getPriceCodeReturnsCorrectPriceCode(){
        assertEquals(PriceCode.REGULAR, regularPrice.getPriceCode());
    }

    @Test
    public void getFrequentRenterPointsReturns1(){
        assertEquals(1, regularPrice.getFrequentRenterPoints(100));
    }
}

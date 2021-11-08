package de.uniba.wiai.dsg.ajp.assignment3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NewReleasePriceTests {
    Price newReleasePrice;

    @BeforeEach
    public void setUp(){
        newReleasePrice = new NewReleasePrice();
    }

    @Test
    public void getChargeReturnsCorrectAmount(){
        assertEquals(30, newReleasePrice.getCharge(10));
    }

    @Test
    public void getChargeReturnsCorrectAmountIfDaysRentedNegativeOrZero(){
        assertThrows(IllegalArgumentException.class, () -> newReleasePrice.getCharge(-10));
        assertThrows(IllegalArgumentException.class, () -> newReleasePrice.getCharge(0));
    }

    @Test
    public void getPriceCodeReturnsCorrectPriceCode(){
        assertEquals(PriceCode.NEW_RELEASE, newReleasePrice.getPriceCode());
    }

    @Test
    public void getFrequentRenterPointsThrowsIfDaysRentedNegativeOrZero(){
        assertThrows(IllegalArgumentException.class, () -> newReleasePrice.getFrequentRenterPoints(-10));
        assertThrows(IllegalArgumentException.class, () -> newReleasePrice.getFrequentRenterPoints(0));
    }

    @Test
    public void getFrequentRenterPointsReturnsCorrectAmountIfDaysRentedGreaterThan1(){
        assertEquals(2, newReleasePrice.getFrequentRenterPoints(4));
    }

    @Test
    public void getFrequentRenterPointsReturnsCorrectAmountIfDaysRentedSmallerOrEqualTo1(){
        assertEquals(1, newReleasePrice.getFrequentRenterPoints(1));
    }
}

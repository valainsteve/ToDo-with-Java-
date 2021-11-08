package de.uniba.wiai.dsg.ajp.assignment3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChildrensPriceTests {
    Price childrensPrice;

    @BeforeEach
    public void setUp(){
        childrensPrice = new ChildrensPrice();
    }

    @Test
    public void getChargeReturnsCorrectAmountIfDaysRentedSmallerThan3(){
        assertEquals(1.5, childrensPrice.getCharge(2));
    }

    @Test
    public void getChargeReturnsCorrectAmountIfDaysRentedGreaterThan3(){
        assertEquals(16.5, childrensPrice.getCharge(13));
    }

    @Test
    public void getChargeReturnsCorrectAmountIfDaysRentedNegativeOrZero(){
        assertThrows(IllegalArgumentException.class, () -> childrensPrice.getCharge(-10));
        assertThrows(IllegalArgumentException.class, () -> childrensPrice.getCharge(0));
    }

    @Test
    public void getPriceCodeReturnsCorrectPriceCode(){
        assertEquals(PriceCode.CHILDRENS, childrensPrice.getPriceCode());
    }

    @Test
    public void getFrequentRenterPointsReturns1(){
        assertEquals(1, childrensPrice.getFrequentRenterPoints(100));
    }
}

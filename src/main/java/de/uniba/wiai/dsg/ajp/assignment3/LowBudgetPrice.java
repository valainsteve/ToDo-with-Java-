package de.uniba.wiai.dsg.ajp.assignment3;

public class LowBudgetPrice extends Price {

    @Override
    double getCharge(int daysRented) {
        if(daysRented <= 0){
            throw new IllegalArgumentException("daysRented must be positive.");
        }
        double result = 0;
        result += 0.5;
        daysRented--;
        if (daysRented > 0) {
            result += 1.0;
            daysRented--;
        }
        if(daysRented > 0) {
            result += daysRented * 0.5;
        }
        return result;
    }

    @Override
    int getFrequentRenterPoints(int daysRented) {
        return 0;
    }

    @Override
    PriceCode getPriceCode() {
        return PriceCode.LOW_BUDGET;
    }
}

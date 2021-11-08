package de.uniba.wiai.dsg.ajp.assignment3;

public class RegularPrice extends Price {

	@Override
	double getCharge(int daysRented) {
		if(daysRented <= 0){
			throw new IllegalArgumentException("daysRented must be positive.");
		}
		double result = 2;
		if (daysRented > 2) {
			result += (daysRented - 2) * 1.5;
		}
		return result;
	}

	@Override
	PriceCode getPriceCode() {
		return PriceCode.REGULAR;
	}

}

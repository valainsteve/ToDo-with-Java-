package de.uniba.wiai.dsg.ajp.assignment3;

public class ChildrensPrice extends Price {

	@Override
	double getCharge(int daysRented) {
		if(daysRented <= 0){
			throw new IllegalArgumentException("daysRented must be positive.");
		}
		double result = 1.5;
		if (daysRented > 3) {
			result += (daysRented - 3) * 1.5;
		}
		return result;
	}

	@Override
	PriceCode getPriceCode() {
		return PriceCode.CHILDRENS;
	}

}

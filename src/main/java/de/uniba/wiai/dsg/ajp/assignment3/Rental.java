package de.uniba.wiai.dsg.ajp.assignment3;

public class Rental {

	private int daysRented;
	private Movie movie;
	private double discountPercentage;

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		if(movie == null){
			throw new IllegalArgumentException("movie must not be null.");
		}
		this.movie = movie;
	}

	public void setDiscountPercentage(double discountPercentage){
		if(discountPercentage<0){
			throw new IllegalArgumentException("discountPercentage must be at least 0.");
		}
		if(discountPercentage>100){
			throw new IllegalArgumentException("discountPercentage has to be smaller than or equal to 100.");
		}
		this.discountPercentage = discountPercentage;
	}

	public double getDiscountPercentage(){
		return discountPercentage;
	}

	public int getDaysRented() { return daysRented; }

	public void setDaysRented(int daysRented) {
		if(daysRented <= 0){
			throw new IllegalArgumentException("daysRented must be positive.");
		}
		this.daysRented = daysRented;
	}

	public double getCharge() {
		return movie.getCharge(daysRented) * (100-discountPercentage)/100;
	}

	public int getFrequentRenterPoints() {
		if(movie == null){
			throw new IllegalStateException("movie has not been set.");
		}
		return movie.getFrequentRenterPoints(daysRented);
	}

}

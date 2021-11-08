package de.uniba.wiai.dsg.ajp.assignment3;

public class Movie {

	private Price price;

	private String title;

	private PictureQuality quality;

	/**
	 * Precondition:
	 * Movie is not initialized.
	 *
	 * Postcondition:
	 * Title, priceCode and quality of the movie are set. quality is set to PictureQuality.HD
	 *
	 * Constructor of the Movie class.
	 * @param title The title the movie should have.
	 * @param priceCode The integer representation of the price code the movie should have.
	 * @throws IllegalArgumentException if title is null or empty or priceCode is incorrect.
	 */
	public Movie(String title, PriceCode priceCode) {
		this.setTitle(title);
		this.setPriceCode(priceCode);
		this.setQuality(PictureQuality.HD);
	}

	/**
	 * Precondition:
	 * Movie is not initialized.
	 *
	 * Postcondition:
	 * Title, priceCode and quality of the movie are set
	 *
	 * Constructor of the Movie class.
	 * @param title The title the movie should have.
	 * @param priceCode The integer representation of the price code the movie should have.
	 * @param quality The PictureQuality The movie should have.
	 * @throws IllegalArgumentException if title is null or empty or priceCode is incorrect.
	 */
	public Movie(String title, PriceCode priceCode, PictureQuality quality){
		this.setTitle(title);
		this.setPriceCode(priceCode);
		this.setQuality(quality);
	}

	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of the movie
	 *
	 * Precondition:
	 * The title given is not set
	 *
	 * Postcondition:
	 * The title given is set.
	 *
	 * @param title the title of the movie
	 * @throws IllegalArgumentException if title is null or empty
	 */
	public void setTitle(String title) {
		if(title == null || title.equals("")){
			throw new IllegalArgumentException("title must not be null or empty.");
		}
		this.title = title;
	}

	double getCharge(int daysRented) {
		if(quality.equals(PictureQuality._4K)){
			return price.getCharge(daysRented) + 2.0;
		}
		return price.getCharge(daysRented);
	}

	public PictureQuality getQuality() {
		return quality;
	}

	public PriceCode getPriceCode() {
		return price.getPriceCode();
	}

	/**
	 * Sets the priceCode of the movie.
	 *
	 * Precondition:
	 * priceCode is not set or old value.
	 *
	 * Postcondition:
	 * priceCode is updated to the new value.
	 *
	 * @param priceCode priceCode enum
	 * @throws IllegalArgumentException if priceCode is incorrect.
	 */
	public void setPriceCode(PriceCode priceCode) {
		switch (priceCode) {
		case REGULAR:
			price = new RegularPrice();
			break;
		case CHILDRENS:
			price = new ChildrensPrice();
			break;
		case NEW_RELEASE:
			price = new NewReleasePrice();
			break;
		case LOW_BUDGET:
			price = new LowBudgetPrice();
			break;
		default:
			throw new IllegalArgumentException("Incorrect Price Code");
		}
	}

	public void setQuality(PictureQuality quality) {
		this.quality = quality;
	}

	public int getFrequentRenterPoints(int daysRented) {
		return price.getFrequentRenterPoints(daysRented);
	}

}

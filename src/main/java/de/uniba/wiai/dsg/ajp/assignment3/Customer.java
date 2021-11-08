package de.uniba.wiai.dsg.ajp.assignment3;

import java.util.LinkedList;
import java.util.List;

public class Customer {

	private String name;

	private List<Rental> rentals = new LinkedList<>();

	/**
	 * Initializes Customer and sets the name.
	 *
	 * Precondition:
	 * Customer uninitialized and name not set.
	 *
	 * Postcondition:
	 * Customer initialized and name set.
	 *
	 * @param name The name to be set.
	 * @throws IllegalArgumentException if name is empty.
	 * @throws NullPointerException	if name is null.
	 */

	public Customer(String name) {
		super();
		setName(name);
	}

	public String getName() {
		return name;
	}

	/**
	 * Sets the name of Customer.
	 *
	 * Precondition:
	 * Given name is not set.
	 *
	 * Postcondition:
	 * Given name is set.
	 *
	 * @param name The name to be set.
	 * @throws IllegalArgumentException if name is empty or null.
	 */

	public void setName(String name) {
		if(name == null || name.equals("")){
			throw new IllegalArgumentException("name must not be null or empty.");
		}
		this.name = name;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	/**
	 * Sets the rentals list if it is not null and doesn't contain null.
	 *
	 * Precondition:
	 * Rentals are not set or old value.
	 *
	 * Postcondition:
	 * The given rentals are set.
	 *
	 * @param rentals The list of rentals to be set.
	 * @throws IllegalArgumentException if Rentals are null or contain null.
	 */
	public void setRentals(List<Rental> rentals) {
		if(rentals == null){
			throw new IllegalArgumentException("rentals must not be null.");
		}
		if(rentals.contains(null)){
			throw new IllegalArgumentException("rentals list must not contain null.");
		}
		this.rentals = rentals;
	}

	/**
	 * Precondition:
	 * Customer is fully initialized.
	 *
	 * Postcondition:
	 * String is returned, customer hasn't changed.
	 *
	 * @return A String representation of the customer, their rentals (and its details), the amount owed and the renter points earned.
	 */
	public String statement() {
		String result = "Rental Record for " + getName() + "\n";

		int frequentRenterPoints = 0;
		for (Rental each : this.rentals) {
			frequentRenterPoints += each.getFrequentRenterPoints();

			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t"
					+ String.valueOf(each.getCharge()) + "\n";
			if(each.getMovie().getQuality().equals(PictureQuality._4K)){
				result += "\t\t4K Quality\n";
			}else {
				result += "\t\tHD Quality\n";
			}
			if(each.getDiscountPercentage() > 0){
				result += String.format("\t\tDiscount: %.2f %%%n", each.getDiscountPercentage());
			}
		}

		// add footer lines
		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";
		return result;
	}

	/**
	 * Precondition:
	 * Customer is fully initialized.
	 *
	 * Postcondition:
	 * String is returned, customer hasn't changed.
	 *
	 * @return A HTML String representation of the customer, their rentals (and its details), the amount owed and the renter points earned.
	 */
	public String htmlStatement() {
		String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";

		for (Rental each : rentals) {
			// show figures for each rental
			result += each.getMovie().getTitle() + ": "
					+ String.valueOf(each.getCharge()) + "<BR>\n";
			if(each.getMovie().getQuality().equals(PictureQuality._4K)){
				result += "4K Quality<BR>\n";
			}else {
				result += "HD Quality<BR>\n";
			}
			if(each.getDiscountPercentage() > 0){
				result += String.format("Discount: %.2f %%%n<BR>", each.getDiscountPercentage());
			}
		}

		// add footer lines
		result += "<P>You owe <EM>" + String.valueOf(getTotalCharge())
				+ "</EM><P>\n";
		result += "On this rental you earned <EM>"
				+ String.valueOf(getTotalFrequentRenterPoints())
				+ "</EM> frequent renter points<P>";

		return result;
	}

	/**
	 * Precondition:
	 * Customer is fully initialized.
	 *
	 * Postcondition:
	 * Total charge is returned, customer hasn't changed.
	 *
	 * @return The total amount the customer has to pay.
	 */
	double getTotalCharge() {
		double result = 0;

		for (Rental each : rentals) {
			result += each.getCharge();
		}

		return result;
	}

	/**
	 * Precondition:
	 * Customer is fully initialized.
	 *
	 * Postcondition:
	 * Total renter points are returned, customer hasn't changed.
	 *
	 * @return The total amount of frequent renter points of the customer
	 */
	int getTotalFrequentRenterPoints() {
		int result = 0;

		for (Rental each : rentals) {
			result += each.getFrequentRenterPoints();
		}

		return result;
	}

}

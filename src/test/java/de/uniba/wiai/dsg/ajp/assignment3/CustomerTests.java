package de.uniba.wiai.dsg.ajp.assignment3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Any;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

public class CustomerTests {
    List<Rental> rentals;
    Customer customer;

    @BeforeEach
    public void setUp(){
        rentals = new LinkedList<>();
        customer = new Customer("Alice");
    }

    @Test
    public void getNameReturnsCorrectName(){
        assertEquals("Alice",customer.getName());
    }

    @Test
    public void setNameThrowsIfNameIsNull(){
        assertThrows(IllegalArgumentException.class, () -> customer.setName(null));
    }

    @Test
    public void setNameThrowsIfNameIsEmpty(){
        assertThrows(IllegalArgumentException.class, () -> customer.setName(""));
    }

    @Test
    public void setNameSetsNameCorrectly(){
        customer.setName("Bob");
        assertEquals("Bob", customer.getName());
    }

    @Test
    public void setRentalsThrowsIfRentalsIsNull(){
        assertThrows(IllegalArgumentException.class, () -> customer.setRentals(null));
    }

    @Test
    public void setRentalsThrowsIfRentalsContainNull(){
        Rental r = mock(Rental.class);
        rentals.add(r);
        rentals.add(r);
        rentals.add(null);
        rentals.add(r);
        assertThrows(IllegalArgumentException.class, () -> customer.setRentals(rentals));
    }

    @Test
    public void setRentalsSetsCorrectRentals(){
        Rental r = mock(Rental.class);
        rentals.add(r);
        rentals.add(r);
        rentals.add(r);
        rentals.add(r);
        customer.setRentals(rentals);
        assertEquals(rentals, customer.getRentals());
    }

    @Test
    public void getTotalChargeReturnsCorrectAmount(){
        Rental r = mock(Rental.class);
        Rental r2 = mock(Rental.class);
        Rental r3 = mock(Rental.class);
        given(r.getCharge()).willReturn(2.0);
        given(r2.getCharge()).willReturn(1.0);
        given(r3.getCharge()).willReturn(0.0);
        rentals.add(r);
        rentals.add(r2);
        rentals.add(r3);
        customer.setRentals(rentals);
        assertEquals(3.0,customer.getTotalCharge());
    }

    @Test
    public void statementTest() throws IOException {
        Rental r = mock(Rental.class);
        Rental r2 = mock(Rental.class);
        Rental r3 = mock(Rental.class);
        Movie m = mock(Movie.class);
        Movie m2 = mock(Movie.class);
        Movie m3 = mock(Movie.class);
        given(r.getFrequentRenterPoints()).willReturn(1);
        given(r2.getFrequentRenterPoints()).willReturn(0);
        given(r3.getFrequentRenterPoints()).willReturn(2);
        given(r.getCharge()).willReturn(10.012345);
        given(r2.getCharge()).willReturn(7.0);
        given(r3.getCharge()).willReturn(12.3);
        given(r.getDaysRented()).willReturn(5);
        given(r2.getDaysRented()).willReturn(3);
        given(r3.getDaysRented()).willReturn(2);
        given(m.getTitle()).willReturn("title ");
        given(m2.getTitle()).willReturn("title 2");
        given(m3.getTitle()).willReturn("title 3");
        given(m.getQuality()).willReturn(PictureQuality.HD);
        given(m2.getQuality()).willReturn(PictureQuality._4K);
        given(m3.getQuality()).willReturn(PictureQuality.HD);
        given(m.getFrequentRenterPoints(5)).willReturn(1);
        given(m2.getFrequentRenterPoints(3)).willReturn(2);
        given(m3.getFrequentRenterPoints(2)).willReturn(0);
        given(r.getMovie()).willReturn(m);
        given(r2.getMovie()).willReturn(m2);
        given(r3.getMovie()).willReturn(m3);
        given(r2.getDiscountPercentage()).willReturn(50.12345);
        rentals.add(r);
        rentals.add(r2);
        rentals.add(r3);
        customer.setRentals(rentals);
        String validStatement = Files.readString(Paths.get("src/test/java/de/uniba/wiai/dsg/ajp/assignment3/statementValidResult.txt"));
        assertEquals(validStatement, customer.statement());
    }

    @Test
    public void htmlStatementTest() throws IOException {
        Rental r = mock(Rental.class);
        Rental r2 = mock(Rental.class);
        Rental r3 = mock(Rental.class);
        Movie m = mock(Movie.class);
        Movie m2 = mock(Movie.class);
        Movie m3 = mock(Movie.class);
        given(r.getFrequentRenterPoints()).willReturn(1);
        given(r2.getFrequentRenterPoints()).willReturn(0);
        given(r3.getFrequentRenterPoints()).willReturn(2);
        given(r.getCharge()).willReturn(16.5);
        given(r2.getCharge()).willReturn(10.0);
        given(r3.getCharge()).willReturn(13.4);
        given(r.getDaysRented()).willReturn(5);
        given(r2.getDaysRented()).willReturn(3);
        given(r3.getDaysRented()).willReturn(2);
        given(m.getTitle()).willReturn("title ");
        given(m2.getTitle()).willReturn("title 2");
        given(m3.getTitle()).willReturn("title 3");
        given(m.getQuality()).willReturn(PictureQuality.HD);
        given(m2.getQuality()).willReturn(PictureQuality._4K);
        given(m3.getQuality()).willReturn(PictureQuality.HD);
        given(m.getFrequentRenterPoints(5)).willReturn(1);
        given(m2.getFrequentRenterPoints(3)).willReturn(2);
        given(m3.getFrequentRenterPoints(2)).willReturn(0);
        given(r.getMovie()).willReturn(m);
        given(r2.getMovie()).willReturn(m2);
        given(r3.getMovie()).willReturn(m3);
        given(r2.getDiscountPercentage()).willReturn(50.12345);
        rentals.add(r);
        rentals.add(r2);
        rentals.add(r3);
        customer.setRentals(rentals);
        String validHtmlStatement = Files.readString(Paths.get("src/test/java/de/uniba/wiai/dsg/ajp/assignment3/htmlStatementValidResult.html"));
        System.out.println(customer.htmlStatement());
        assertEquals(validHtmlStatement, customer.htmlStatement());
    }

    @Test
    public void getTotalFrequentRenterPointsReturnsCorrectAmount(){
        Rental r = mock(Rental.class);
        Rental r2 = mock(Rental.class);
        Rental r3 = mock(Rental.class);
        given(r.getFrequentRenterPoints()).willReturn(1);
        given(r2.getFrequentRenterPoints()).willReturn(0);
        given(r3.getFrequentRenterPoints()).willReturn(2);
        rentals.add(r);
        rentals.add(r2);
        rentals.add(r3);
        customer.setRentals(rentals);
        assertEquals(3,customer.getTotalFrequentRenterPoints());
    }

}

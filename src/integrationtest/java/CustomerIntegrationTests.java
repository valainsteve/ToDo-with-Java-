import de.uniba.wiai.dsg.ajp.assignment3.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerIntegrationTests {
    Customer customer;
    List<Rental> rentals;

    @BeforeEach
    public void setUp(){
        customer = new Customer("Alice");
        Rental r1 = new Rental();
        Rental r2 = new Rental();
        Rental r3 = new Rental();
        Rental r4 = new Rental();
        Movie m1 = new Movie("Marvel Movie", PriceCode.REGULAR);
        Movie m2 = new Movie("Disney Movie", PriceCode.NEW_RELEASE, PictureQuality._4K);
        Movie m3 = new Movie("Old Movie", PriceCode.LOW_BUDGET, PictureQuality.HD);
        Movie m4 = new Movie("Children Movie", PriceCode.CHILDRENS);
        r1.setMovie(m1);
        r2.setMovie(m2);
        r3.setMovie(m3);
        r4.setMovie(m4);
        r1.setDaysRented(5);
        r2.setDaysRented(10);
        r3.setDaysRented(1);
        r4.setDaysRented(3);
        r2.setDiscountPercentage(30.0);
        rentals = new LinkedList<>();
        rentals.add(r1);
        rentals.add(r2);
        rentals.add(r3);
        rentals.add(r4);
    }

    @Test
    public void statementReturnsCorrectString() throws IOException {
        customer.setRentals(rentals);
        String validStatement = Files.readString(Paths.get("src/integrationtest/java/statementValidResult.txt"));
        assertEquals(validStatement, customer.statement());
    }

    @Test
    public void htmlStatementReturnsCorrectString() throws IOException {
        customer.setRentals(rentals);
        System.out.println(customer.htmlStatement());
        String validHtmlStatement = Files.readString(Paths.get("src/integrationtest/java/htmlStatementValidResult.html"));
        assertEquals(validHtmlStatement, customer.htmlStatement());
    }

}



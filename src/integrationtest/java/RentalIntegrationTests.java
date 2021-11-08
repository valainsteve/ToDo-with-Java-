import de.uniba.wiai.dsg.ajp.assignment3.Movie;
import de.uniba.wiai.dsg.ajp.assignment3.PictureQuality;
import de.uniba.wiai.dsg.ajp.assignment3.PriceCode;
import de.uniba.wiai.dsg.ajp.assignment3.Rental;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RentalIntegrationTests {
    Rental rental;

    @BeforeEach
    public void setUp() {
        rental = new Rental();
        Movie movie = new Movie("Marvel", PriceCode.REGULAR, PictureQuality._4K);
        rental.setMovie(movie);
        rental.setDaysRented(10);
        rental.setDiscountPercentage(20.0);
    }

    @Test
    public void getFrequentRenterPointsThrowsIfMovieIsNull(){
        rental = new Rental();
        assertThrows(IllegalStateException.class, () -> rental.getFrequentRenterPoints());
    }

    @Test
    public void getFrequentRenterPointsReturnsCorrectValue(){
        assertEquals(1, rental.getFrequentRenterPoints());
    }

    @Test
    public void getChargeReturnsCorrectAmount(){
        assertEquals(12.8, rental.getCharge());
    }
}

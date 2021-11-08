import de.uniba.wiai.dsg.ajp.assignment3.Movie;
import de.uniba.wiai.dsg.ajp.assignment3.PictureQuality;
import de.uniba.wiai.dsg.ajp.assignment3.PriceCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieIntegrationTests {
    Movie movie;

    @BeforeEach
    public void setUp(){
        movie = new Movie("Marvel", PriceCode.LOW_BUDGET, PictureQuality._4K);
    }

    @Test
    public void getFrequentRenterPointsCHILDRENSReturnsCorrectAmount(){
        movie.setPriceCode(PriceCode.CHILDRENS);
        assertEquals(1, movie.getFrequentRenterPoints(10));
    }

    @Test
    public void getFrequentRenterPointsLOW_BUDGETReturnsCorrectAmount(){
        movie.setPriceCode(PriceCode.LOW_BUDGET);
        assertEquals(0, movie.getFrequentRenterPoints(100));
    }

    @Test
    public void getFrequentRenterPointsNEW_RELEASEReturnsCorrectAmount(){
        movie.setPriceCode(PriceCode.NEW_RELEASE);
        assertEquals(2, movie.getFrequentRenterPoints(3));
        assertEquals(1, movie.getFrequentRenterPoints(1));
    }

    @Test
    public void getFrequentRenterPointsREGULARReturnsCorrectAmount(){
        movie.setPriceCode(PriceCode.REGULAR);
        assertEquals(1, movie.getFrequentRenterPoints(10));
    }
}

package de.uniba.wiai.dsg.ajp.assignment3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class RentalTests {
    Rental rental;
    Movie mockedMovie;

    @BeforeEach
    public void setUp(){
        rental = new Rental();
        mockedMovie = mock(Movie.class);
        rental.setMovie(mockedMovie);
        rental.setDaysRented(10);
    }

    @Test
    public void setMovieThrowsIfMovieIsNull(){
        assertThrows(IllegalArgumentException.class, () -> rental.setMovie(null));
    }

    @Test
    public void setMovieSetsMovie(){
        rental.setMovie(mockedMovie);
        assertEquals(mockedMovie, rental.getMovie());
    }

    @Test
    public void setDiscountPercentageThrowsIfPercentageSmallerThanZero(){
        assertThrows(IllegalArgumentException.class, () -> rental.setDiscountPercentage(-10));
    }

    @Test
    public void setDiscountPercentageThrowsIfPercentageGreaterThan100(){
        assertThrows(IllegalArgumentException.class, () -> rental.setDiscountPercentage(120));
    }

    @Test
    public void setDiscountPercentageSetsCorrectly(){
        rental.setDiscountPercentage(50);
        assertEquals(50.0, rental.getDiscountPercentage());
    }

    @Test
    public void setDaysRentedThrowsIfDaysRentedSmallerOrEqualToZero(){
        assertThrows(IllegalArgumentException.class, () -> rental.setDaysRented(-10));
        assertThrows(IllegalArgumentException.class, () -> rental.setDaysRented(0));
    }

    @Test
    public void getChargeReturnsCorrectAmount(){
        given(mockedMovie.getCharge(rental.getDaysRented())).willReturn(16.5);
        rental.setDiscountPercentage(50.0);
        assertEquals(8.25, rental.getCharge());
    }

    @Test
    public void getFrequentRenterPointsThrowsIfMovieIsNull(){
        rental = new Rental();
        assertThrows(IllegalStateException.class, () -> rental.getFrequentRenterPoints());
    }

    @Test
    public void getFrequentRenterPointsReturnsCorrectAmount(){
        given(mockedMovie.getFrequentRenterPoints(rental.getDaysRented())).willReturn(3);
        assertEquals(3, rental.getFrequentRenterPoints());
    }

}

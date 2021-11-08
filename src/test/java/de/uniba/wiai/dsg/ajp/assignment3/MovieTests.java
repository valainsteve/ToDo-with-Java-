package de.uniba.wiai.dsg.ajp.assignment3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class MovieTests {
    Movie movie;
    Price mockedPrice;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        movie = new Movie("title",PriceCode.REGULAR);
        mockedPrice = mock(Price.class);
        Field priceField = movie.getClass().getDeclaredField("price");
        priceField.setAccessible(true);
        priceField.set(movie, mockedPrice);
    }

    @Test
    public void constructorSetPictureQualityHD(){
        movie = new Movie("title", PriceCode.NEW_RELEASE, PictureQuality.HD);
        assertEquals(PictureQuality.HD, movie.getQuality());
    }

    @Test
    public void constructorSetPictureQuality4K(){
        movie = new Movie("title", PriceCode.REGULAR, PictureQuality._4K);
        assertEquals(PictureQuality._4K, movie.getQuality());
    }

    @Test
    public void getPictureQualityHDReturnsPictureQualityHD(){
        assertEquals(PictureQuality.HD, movie.getQuality());
    }

    @Test
    public void setAndGetPictureQuality4kReturnsPictureQuality4K(){
        movie.setQuality(PictureQuality._4K);
        assertEquals(PictureQuality._4K, movie.getQuality());
    }

    @Test
    public void constructorThrowIfNullTitle(){
        assertThrows(IllegalArgumentException.class, () -> new Movie(null, PriceCode.REGULAR));
    }

    @Test
    public void constructorThrowIfEmptyTitle(){
        assertThrows(IllegalArgumentException.class, () -> new Movie("", PriceCode.REGULAR));
    }

    @Test
    public void constructorIfThrowIncorrectPriceCode(){
        assertThrows(NullPointerException.class, () -> new Movie("title", null));
    }

    @Test
    public void getChargeReturnsCorrectAmount(){
        given(mockedPrice.getCharge(5)).willReturn(10.0);
        assertEquals(10.0, movie.getCharge(5));
    }

    @Test
    public void getCharge4KReturnsCorrectAmount(){
        movie.setQuality(PictureQuality._4K);
        given(mockedPrice.getCharge(5)).willReturn(10.0);
        assertEquals(12.0, movie.getCharge(5));
    }

    @Test
    public void getTitleReturnsTitle(){
        assertEquals("title", movie.getTitle());
    }

    @Test
    public void setPriceCodeCHILDRENSSetsPriceCodeToCHILDRENS(){
        movie.setPriceCode(PriceCode.CHILDRENS);
        assertEquals(PriceCode.CHILDRENS, movie.getPriceCode());
    }

    @Test
    public void setPriceCodeREGULARSetsPriceCodeToREGULAR(){
        movie.setPriceCode(PriceCode.REGULAR);
        assertEquals(PriceCode.REGULAR, movie.getPriceCode());
    }

    @Test
    public void setPriceCodeNEW_RELEASESetsPriceCodeToNEW_RELEASE(){
        movie.setPriceCode(PriceCode.NEW_RELEASE);
        assertEquals(PriceCode.NEW_RELEASE, movie.getPriceCode());
    }

    @Test
    public void setPriceCodeLOW_BUDGETSetsPriceCodeToLOW_BUDGET(){
        movie.setPriceCode(PriceCode.LOW_BUDGET);
        assertEquals(PriceCode.LOW_BUDGET, movie.getPriceCode());
    }

    @Test
    public void getFrequentRenterPointsReturnsCorrectAmount(){
        given(mockedPrice.getFrequentRenterPoints(10)).willReturn(1);
        assertEquals(1, movie.getFrequentRenterPoints(10));
    }

}

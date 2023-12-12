package objectTdd.christmas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static java.time.LocalDate.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ChristmasTdd {

    private SalePolicy sut;
    private TimeLoader timeLoader;

    @BeforeEach
    void setUp() {
        timeLoader = mock(TimeLoader.class);
        sut = new SalePolicy(timeLoader);
    }

    @Test
    @DisplayName("평소에는 0% 할인")
    void test0PerSale() {
        when(timeLoader.now()).thenReturn(LocalDate.now());

        String actual = sut.sale(timeLoader);

        assertEquals("0%", actual);
    }

    @Test
    @DisplayName("크리스마스에는 50% 할인 - 1")
    void test50PerSale() {
        when(timeLoader.now()).thenReturn(of(2023, 12, 25));

        String actual = sut.sale(timeLoader);

        assertEquals("50%", actual);
    }

    @Test
    @DisplayName("크리스마스에는 50% 할인 - 2")
    void testHack50PerSale() {
        var now = LocalDate.now();

        // hack
        try (var mockedLocalDate = mockStatic(LocalDate.class)) {
            mockedLocalDate.when(LocalDate::now).thenReturn(now);

            String actual = sut.sale(timeLoader);

            assertEquals("50%", actual);
        }
    }

}
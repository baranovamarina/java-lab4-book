package ua.edu.sumdu.j2se.pr4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Клас автотестів для перевірки механізмів валідації базового та похідних класів
 */
class BookTest {

    @Test
    void shouldThrowExceptionWhenInvalidConstructorData() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Book("", "Author", 2020, 100.0, Genre.SCIENCE);
        });
    }

    @Test
    void shouldThrowExceptionForInvalidDerivedProperties() {
        assertThrows(IllegalArgumentException.class, () -> {
            new EBook("Title", "Author", 2020, 100.0, Genre.FICTION, -5.0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new PaperBook("Title", "Author", 2020, 100.0, Genre.HISTORY, 0);
        });
    }
}
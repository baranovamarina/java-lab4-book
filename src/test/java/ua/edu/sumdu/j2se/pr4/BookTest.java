package ua.edu.sumdu.j2se.pr4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Клас автотестів (JUnit 5) для перевірки механізмів валідації класу Book
 */
class BookTest {

    @Test
    void shouldThrowExceptionWhenInvalidValueInSetter() {
        Book book = new Book("Valid Title", "Valid Author", 2023, 250.0, Genre.FICTION);

        assertThrows(IllegalArgumentException.class, () -> {
            book.setPrice(-10.5);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            book.setYear(2035);
        });
    }

    @Test
    void shouldThrowExceptionWhenInvalidConstructorData() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Book("", "Author", 2020, 100.0, Genre.SCIENCE);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Book("Title", "Author", 2020, 100.0, null);
        });
    }

    /**
     * Перевіряє роботу конструктора копіювання
     */
    @Test
    void shouldCorrectlyCopyBook() {
        Book original = new Book("Java", "Author", 2020, 150.0, Genre.SCIENCE);
        Book copy = new Book(original);

        assertEquals(original.getTitle(), copy.getTitle());
        assertEquals(original.getGenre(), copy.getGenre());
        assertNotSame(original, copy); // Перевірка, що це різні об'єкти в пам'яті
    }
}
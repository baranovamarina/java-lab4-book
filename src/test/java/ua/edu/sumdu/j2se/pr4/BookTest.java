package ua.edu.sumdu.j2se.pr4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Клас автотестів (JUnit 5) для перевірки механізмів валідації класу Book
 */
class BookTest {

    /**
     * Перевіряє, чи викидається IllegalArgumentException при спробі
     * передати некоректні значення в методи-сетери
     */
    @Test
    void shouldThrowExceptionWhenInvalidValueInSetter() {
        Book book = new Book("Valid Title", "Valid Author", 2023, 250.0);

        assertThrows(IllegalArgumentException.class, () -> {
            book.setPrice(-10.5);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            book.setYear(2035);
        });
    }

    /**
     * Перевіряє, чи викидається IllegalArgumentException при спробі
     * створити об'єкт через конструктор з некоректними даними
     */
    @Test
    void shouldThrowExceptionWhenInvalidConstructorData() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Book("", "Author", 2020, 100.0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Book("Title", null, 2020, 100.0);
        });
    }
}
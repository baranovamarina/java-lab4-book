package ua.edu.sumdu.j2se.pr4;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас, що представляє бібліотеку
 * Демонструє принцип агрегації: бібліотека містить список об'єктів Book
 */
public class Library {
    private List<Book> collection;

    /**
     * Конструктор для ініціалізації порожньої бібліотеки
     */
    public Library() {
        this.collection = new ArrayList<>();
    }

    /**
     * Додає книгу до бібліотеки
     *
     * @param book об'єкт книги для додавання
     * @throws IllegalArgumentException якщо передана книга є null
     */
    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Неможливо додати порожню книгу.");
        }
        collection.add(book);
    }

    /**
     * Повертає поточний список усіх книг у бібліотеці
     *
     * @return список книг
     */
    public List<Book> getAllBooks() {
        return collection;
    }

    /**
     * Перевіряє, чи порожня бібліотека
     *
     * @return true, якщо бібліотека не містить жодної книги
     */
    public boolean isEmpty() {
        return collection.isEmpty();
    }
}
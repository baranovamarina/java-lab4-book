package ua.edu.sumdu.j2se.pr4;

import java.util.Objects;

/**
 * Клас, що представляє книгу
 * Забезпечує зберігання даних про книгу та внутрішню валідацію полів
 */
public class Book {
    private String title;
    private String author;
    private int year;
    private double price;

    /**
     * Конструктор для створення нового об'єкта книги
     *
     * @param title  назва книги
     * @param author ім'я автора
     * @param year   рік видання
     * @param price  вартість книги
     * @throws IllegalArgumentException якщо будь-який з параметрів є некоректним
     */
    public Book(String title, String author, int year, double price) {
        validateTitle(title);
        validateAuthor(author);
        validateYear(year);
        validatePrice(price);

        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    /**
     * Отримує назву книги
     *
     * @return назва книги
     */
    public String getTitle() {
        return title;
    }

    /**
     * Встановлює назву книги
     *
     * @param title нова назва книги
     * @throws IllegalArgumentException якщо назва порожня або null
     */
    public void setTitle(String title) {
        validateTitle(title);
        this.title = title;
    }

    /**
     * Отримує ім'я автора
     *
     * @return автор книги
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Встановлює ім'я автора
     *
     * @param author нове ім'я автора
     * @throws IllegalArgumentException якщо ім'я порожнє або null
     */
    public void setAuthor(String author) {
        validateAuthor(author);
        this.author = author;
    }

    /**
     * Отримує рік видання
     *
     * @return рік видання книги
     */
    public int getYear() {
        return year;
    }

    /**
     * Встановлює рік видання
     *
     * @param year новий рік видання
     * @throws IllegalArgumentException якщо рік менший за 0 або більший за поточний
     */
    public void setYear(int year) {
        validateYear(year);
        this.year = year;
    }

    /**
     * Отримує ціну книги
     *
     * @return вартість книги
     */
    public double getPrice() {
        return price;
    }

    /**
     * Встановлює ціну книги
     *
     * @param price нова вартість книги
     * @throws IllegalArgumentException якщо ціна від'ємна
     */
    public void setPrice(double price) {
        validatePrice(price);
        this.price = price;
    }

    /**
     * Перевіряє коректність назви книги
     *
     * @param title назва для перевірки
     */
    private void validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Назва книги не може бути порожньою.");
        }
    }

    /**
     * Перевіряє коректність імені автора
     *
     * @param author ім'я для перевірки
     */
    private void validateAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Автор книги не може бути порожнім.");
        }
    }

    /**
     * Перевіряє коректність року видання
     *
     * @param year рік для перевірки
     */
    private void validateYear(int year) {
        if (year < 0 || year > 2026) {
            throw new IllegalArgumentException("Некоректний рік видання.");
        }
    }

    /**
     * Перевіряє коректність ціни
     *
     * @param price ціна для перевірки
     */
    private void validatePrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Ціна не може бути від'ємною.");
        }
    }

    @Override
    public String toString() {
        return "Книга: '" + title + "', автор: " + author + ", рік: " + year + ", ціна: " + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Double.compare(book.price, price) == 0 &&
                Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year, price);
    }
}
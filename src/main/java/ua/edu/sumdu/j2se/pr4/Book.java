package ua.edu.sumdu.j2se.pr4;

import java.util.Objects;

/**
 * Клас, що представляє книгу
 * Забезпечує зберігання базових даних про книгу
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
     */
    public Book(String title, String author, int year, double price) {
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
     */
    public void setTitle(String title) {
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
     */
    public void setAuthor(String author) {
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
     */
    public void setYear(int year) {
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
     */
    public void setPrice(double price) {
        this.price = price;
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
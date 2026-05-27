package ua.edu.sumdu.j2se.pr4;

import java.util.Objects;

/**
 * Клас, що представляє книгу
 * Забезпечує зберігання даних про книгу, внутрішню валідацію полів
 * та підрахунок загальної кількості створених об'єктів
 */
public class Book {

    /** Статичне поле для підрахунку кількості створених об'єктів класу Book */
    private static int totalBooks = 0;

    private String title;
    private String author;
    private int year;
    private double price;
    private Genre genre;

    /**
     * Конструктор для створення нового об'єкта книги
     *
     * @param title  назва книги
     * @param author ім'я автора
     * @param year   рік видання
     * @param price  вартість книги
     * @param genre  жанр книги
     * @throws IllegalArgumentException якщо будь-який з параметрів є некоректним
     */
    public Book(String title, String author, int year, double price, Genre genre) {
        validateTitle(title);
        validateAuthor(author);
        validateYear(year);
        validatePrice(price);
        validateGenre(genre);

        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
        this.genre = genre;

        totalBooks++; // Збільшуємо лічильник при створенні нової книги
    }

    /**
     * Конструктор копіювання
     * Створює новий об'єкт книги як точну копію переданого об'єкта
     *
     * @param other об'єкт книги для копіювання
     * @throws IllegalArgumentException якщо переданий об'єкт є null
     */
    public Book(Book other) {
        if (other == null) {
            throw new IllegalArgumentException("Об'єкт для копіювання не може бути null.");
        }
        this.title = other.title;
        this.author = other.author;
        this.year = other.year;
        this.price = other.price;
        this.genre = other.genre;

        totalBooks++; // Копія також вважається новим створеним об'єктом
    }

    /**
     * Статичний метод для отримання загальної кількості створених книг
     *
     * @return кількість об'єктів Book
     */
    public static int getTotalBooks() {
        return totalBooks;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) {
        validateTitle(title);
        this.title = title;
    }

    public String getAuthor() { return author; }
    public void setAuthor(String author) {
        validateAuthor(author);
        this.author = author;
    }

    public int getYear() { return year; }
    public void setYear(int year) {
        validateYear(year);
        this.year = year;
    }

    public double getPrice() { return price; }
    public void setPrice(double price) {
        validatePrice(price);
        this.price = price;
    }

    /**
     * Отримує жанр книги
     * @return жанр
     */
    public Genre getGenre() { return genre; }

    /**
     * Встановлює новий жанр для книги
     * @param genre новий жанр
     */
    public void setGenre(Genre genre) {
        validateGenre(genre);
        this.genre = genre;
    }

    private void validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Назва книги не може бути порожньою.");
        }
    }

    private void validateAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Автор книги не може бути порожнім.");
        }
    }

    private void validateYear(int year) {
        if (year < 0 || year > 2026) {
            throw new IllegalArgumentException("Некоректний рік видання.");
        }
    }

    private void validatePrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Ціна не може бути від'ємною.");
        }
    }

    private void validateGenre(Genre genre) {
        if (genre == null) {
            throw new IllegalArgumentException("Жанр книги не може бути порожнім.");
        }
    }

    @Override
    public String toString() {
        return "Книга: '" + title + "', автор: " + author + ", рік: " + year + ", ціна: " + price + ", жанр: " + genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Double.compare(book.price, price) == 0 &&
                Objects.equals(title, book.title) && Objects.equals(author, book.author) && genre == book.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year, price, genre);
    }
}
package ua.edu.sumdu.j2se.pr4;

/**
 * Клас, що представляє електронну книгу
 * Успадковується від базового класу Book
 */
public class EBook extends Book {
    private double fileSizeMB;

    /**
     * Конструктор для електронної книги
     *
     * @param title      назва
     * @param author     автор
     * @param year       рік
     * @param price      ціна
     * @param genre      жанр
     * @param fileSizeMB розмір файлу в мегабайтах
     */
    public EBook(String title, String author, int year, double price, Genre genre, double fileSizeMB) {
        super(title, author, year, price, genre);
        validateFileSize(fileSizeMB);
        this.fileSizeMB = fileSizeMB;
    }

    /**
     * Отримує розмір файлу
     * @return розмір файлу в МБ
     */
    public double getFileSizeMB() {
        return fileSizeMB;
    }

    /**
     * Встановлює розмір файлу
     * @param fileSizeMB новий розмір файлу в МБ
     */
    public void setFileSizeMB(double fileSizeMB) {
        validateFileSize(fileSizeMB);
        this.fileSizeMB = fileSizeMB;
    }

    private void validateFileSize(double size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Розмір файлу має бути більшим за 0.");
        }
    }

    /**
     * Перевизначений метод toString для демонстрації поліморфізму
     */
    @Override
    public String toString() {
        return super.toString() + " [Електронна, Розмір: " + fileSizeMB + " MB]";
    }
}
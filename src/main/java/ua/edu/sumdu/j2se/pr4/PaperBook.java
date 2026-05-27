package ua.edu.sumdu.j2se.pr4;

/**
 * Клас, що представляє паперову книгу
 * Успадковується від базового класу Book
 */
public class PaperBook extends Book {
    private int pageCount;

    /**
     * Конструктор для паперової книги
     *
     * @param title     назва
     * @param author    автор
     * @param year      рік
     * @param price     ціна
     * @param genre     жанр
     * @param pageCount кількість сторінок
     */
    public PaperBook(String title, String author, int year, double price, Genre genre, int pageCount) {
        super(title, author, year, price, genre);
        validatePageCount(pageCount);
        this.pageCount = pageCount;
    }

    /**
     * Отримує кількість сторінок
     * @return кількість сторінок
     */
    public int getPageCount() {
        return pageCount;
    }

    /**
     * Встановлює кількість сторінок
     * @param pageCount нова кількість сторінок
     */
    public void setPageCount(int pageCount) {
        validatePageCount(pageCount);
        this.pageCount = pageCount;
    }

    private void validatePageCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("Кількість сторінок має бути більшою за 0.");
        }
    }

    /**
     * Перевизначений метод toString для демонстрації поліморфізму
     */
    @Override
    public String toString() {
        return super.toString() + " [Паперова, Сторінок: " + pageCount + "]";
    }
}
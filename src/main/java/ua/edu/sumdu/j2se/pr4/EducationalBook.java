package ua.edu.sumdu.j2se.pr4;

public class EducationalBook extends Book {
    private String subject;

    public EducationalBook(String title, String author, int year, double price, Genre genre, String subject) {
        super(title, author, year, price, genre);
        this.subject = subject;
    }

    @Override
    public String toString() {
        return super.toString() + " [Навчальна, Предмет: " + subject + "]";
    }
}
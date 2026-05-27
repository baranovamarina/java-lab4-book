package ua.edu.sumdu.j2se.pr4;

public class AudioBook extends Book {
    private double durationMinutes;

    public AudioBook(String title, String author, int year, double price, Genre genre, double durationMinutes) {
        super(title, author, year, price, genre);
        this.durationMinutes = durationMinutes;
    }

    @Override
    public String toString() {
        return super.toString() + " [Аудіокнига, Тривалість: " + durationMinutes + " хв]";
    }
}
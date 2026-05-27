package ua.edu.sumdu.j2se.pr4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Головний клас програми
 * Демонструє поліморфізм та роботу з колекцією об'єктів похідних класів
 */
public class Main {

    /**
     * Точка входу в програму, запускає консольне меню
     *
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Колекція базового типу, яка зберігатиме об'єкти похідних класів
        ArrayList<Book> booksList = new ArrayList<>();
        boolean running = true;

        System.out.println("=== Системне меню (Демонстрація поліморфізму) ===");

        while (running) {
            System.out.println("\nОберіть дію:");
            System.out.println("1. Створити новий об'єкт");
            System.out.println("2. Вивести всі об'єкти");
            System.out.println("3. Завершити");
            System.out.print("Ваш вибір: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1": // Створити новий об'єкт
                    System.out.println("Оберіть тип: 1-EBook, 2-PaperBook, 3-AudioBook, 4-EducationalBook, 5-Назад");
                    System.out.print("Ваш вибір типу: ");
                    String typeChoice = scanner.nextLine().trim();

                    // Викликаємо метод створення лише якщо користувач не натиснув "Назад"
                    if (!typeChoice.equals("5")) {
                        createBook(scanner, booksList, typeChoice);
                    }
                    break;
                case "2": // Вивести всі об'єкти
                    showAllBooks(booksList);
                    break;
                case "3": // Завершити
                    running = false;
                    break;
                default:
                    System.out.println("Невірний вибір.");
            }
        }
        scanner.close();
    }
    private static void createBook(Scanner scanner, ArrayList<Book> list, String typeChoice) {
        try {
            // 1. Спочатку зчитуємо спільні дані для всіх типів
            System.out.print("Введіть назву книги: ");
            String title = scanner.nextLine();
            System.out.print("Введіть автора: ");
            String author = scanner.nextLine();
            System.out.print("Введіть рік видання: ");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.print("Введіть ціну: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.print("Оберіть жанр (1-Художня, 2-Наукова, 3-Фентезі, 4-Історична): ");
            String genreChoice = scanner.nextLine();
            Genre genre;
            switch (genreChoice) {
                case "1": genre = Genre.FICTION; break;
                case "2": genre = Genre.SCIENCE; break;
                case "3": genre = Genre.FANTASY; break;
                case "4": genre = Genre.HISTORY; break;
                default: throw new IllegalArgumentException("Невідомий жанр.");
            }

            // 2. Додаємо об'єкт відповідно до типу
            switch (typeChoice) {
                case "1": // EBook
                    System.out.print("Розмір файлу (МБ): ");
                    double size = Double.parseDouble(scanner.nextLine());
                    list.add(new EBook(title, author, year, price, genre, size));
                    break;
                case "2": // PaperBook
                    System.out.print("Кількість сторінок: ");
                    int pages = Integer.parseInt(scanner.nextLine());
                    list.add(new PaperBook(title, author, year, price, genre, pages));
                    break;
                case "3": // AudioBook
                    System.out.print("Тривалість (хв): ");
                    double duration = Double.parseDouble(scanner.nextLine());
                    list.add(new AudioBook(title, author, year, price, genre, duration));
                    break;
                case "4": // EducationalBook
                    System.out.print("Навчальний предмет: ");
                    String subject = scanner.nextLine();
                    list.add(new EducationalBook(title, author, year, price, genre, subject));
                    break;
                default:
                    System.out.println("Помилка: невідомий тип.");
            }
            System.out.println("Успіх: Книгу додано до колекції!");
        } catch (NumberFormatException e) {
            System.out.println("Помилка: Очікувалося числове значення.");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    /**
     * Демонстрація поліморфізму: цикл проходить по колекції базового типу Book,
     * але автоматично викликає перевизначений метод toString() для EBook або PaperBook
     *
     * @param list колекція об'єктів
     */
    private static void showAllBooks(ArrayList<Book> list) {
        System.out.println("\n-- Зареєстрований список книг --");
        if (list.isEmpty()) {
            System.out.println("Список порожній.");
        } else {
            for (Book b : list) {
                System.out.println(b.toString());
            }
        }
    }
}


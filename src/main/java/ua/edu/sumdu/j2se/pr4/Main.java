package ua.edu.sumdu.j2se.pr4;

import java.util.Scanner;

/**
 * Головний клас програми
 * Реалізує інтерактивне консольне меню для взаємодії користувача з бібліотекою
 */
public class Main {

    /**
     * Точка входу в програму. Запускає безперервний цикл консольного меню
     *
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library myLibrary = new Library(); // Використання агрегації
        boolean running = true;

        System.out.println("=== Системне меню керування бібліотекою ===");

        while (running) {
            System.out.println("\nОберіть дію:");
            System.out.println("1. Додати нову книгу");
            System.out.println("2. Вивести всі книги");
            System.out.println("3. Створити копію першої книги у списку");
            System.out.println("4. Показати загальну статистику (Статика)");
            System.out.println("5. Завершити роботу");
            System.out.print("Ваш вибір: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addNewBook(scanner, myLibrary);
                    break;
                case "2":
                    showAllBooks(myLibrary);
                    break;
                case "3":
                    copyFirstBook(myLibrary);
                    break;
                case "4":
                    System.out.println("\nЗагальна кількість створених об'єктів Book: " + Book.getTotalBooks());
                    break;
                case "5":
                    running = false;
                    System.out.println("Роботу програми завершено. До побачення!");
                    break;
                default:
                    System.out.println("Помилка: Невідомий пункт меню. Спробуйте ще раз.");
            }
        }
        scanner.close();
    }

    private static void addNewBook(Scanner scanner, Library library) {
        try {
            System.out.print("Введіть назву книги: ");
            String title = scanner.nextLine();

            System.out.print("Введіть автора книги: ");
            String author = scanner.nextLine();

            System.out.print("Введіть рік видання: ");
            int year = Integer.parseInt(scanner.nextLine());

            System.out.print("Введіть ціну книги: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.println("Оберіть жанр (1 - Художня, 2 - Наукова, 3 - Фентезі, 4 - Історична): ");
            String genreChoice = scanner.nextLine();
            Genre genre;
            switch (genreChoice) {
                case "1": genre = Genre.FICTION; break;
                case "2": genre = Genre.SCIENCE; break;
                case "3": genre = Genre.FANTASY; break;
                case "4": genre = Genre.HISTORY; break;
                default: throw new IllegalArgumentException("Невідомий жанр.");
            }

            Book newBook = new Book(title, author, year, price, genre);
            library.addBook(newBook);
            System.out.println("Успіх: Книгу успішно додано до бібліотеки!");

        } catch (NumberFormatException e) {
            System.out.println("Помилка введення: Для року та ціни необхідно вводити числові значення!");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка валідації даних: " + e.getMessage());
        }
    }

    private static void showAllBooks(Library library) {
        System.out.println("\n-- Зареєстрований список книг --");
        if (library.isEmpty()) {
            System.out.println("Бібліотека порожня.");
        } else {
            for (Book b : library.getAllBooks()) {
                System.out.println(b.toString());
            }
        }
    }

    private static void copyFirstBook(Library library) {
        if (library.isEmpty()) {
            System.out.println("Помилка: Бібліотека порожня, немає що копіювати.");
            return;
        }
        try {
            Book firstBook = library.getAllBooks().get(0);
            Book copiedBook = new Book(firstBook); // Демонстрація конструктора копіювання
            library.addBook(copiedBook);
            System.out.println("Успіх: Копію першої книги створено та додано до бібліотеки!");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка копіювання: " + e.getMessage());
        }
    }
}
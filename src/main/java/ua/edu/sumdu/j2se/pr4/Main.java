package ua.edu.sumdu.j2se.pr4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Головний клас програми
 * Демонструє поліморфізм та роботу з колекцією об'єктів похідних класів
 */
public class Main {

    /**
     * Точка входу в програму. Запускає консольне меню
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
    /**
     * Зчитує дані та створює об'єкт відповідного похідного класу
     *
     * @param scanner об'єкт Scanner
     * @param list    колекція для збереження книг
     * @param isEBook прапорець: true, якщо це EBook, false, якщо PaperBook
     */
    private static void addBook(Scanner scanner, ArrayList<Book> list, boolean isEBook) {
        try {
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

            if (isEBook) {
                System.out.print("Введіть розмір файлу в МБ: ");
                double size = Double.parseDouble(scanner.nextLine());
                // Створення об'єкта EBook і додавання його під виглядом базового класу
                Book ebook = new EBook(title, author, year, price, genre, size);
                list.add(ebook);
                System.out.println("Успіх: Електронну книгу додано!");
            } else {
                System.out.print("Введіть кількість сторінок: ");
                int pages = Integer.parseInt(scanner.nextLine());
                // Створення об'єкта PaperBook і додавання його під виглядом базового класу
                Book paperBook = new PaperBook(title, author, year, price, genre, pages);
                list.add(paperBook);
                System.out.println("Успіх: Паперову книгу додано!");
            }

        } catch (NumberFormatException e) {
            System.out.println("Помилка введення: очікується числове значення!");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка валідації: " + e.getMessage());
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


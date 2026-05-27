package ua.edu.sumdu.j2se.pr4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Головний клас програми
 * Реалізує інтерактивне консольне меню для взаємодії користувача зі списком книг
 */
public class Main {

    /**
     * Точка входу в програму. Запускає безперервний цикл консольного меню
     *
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> booksList = new ArrayList<>();
        boolean running = true;

        System.out.println("=== Системне меню керування книгами ===");

        while (running) {
            System.out.println("\nОберіть дію:");
            System.out.println("1. Створити новий об’єкт (Додати книгу)");
            System.out.println("2. Вивести інформацію про всі об’єкті");
            System.out.println("3. Завершити роботу");
            System.out.print("Ваш вибір: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addNewBook(scanner, booksList);
                    break;
                case "2":
                    showAllBooks(booksList);
                    break;
                case "3":
                    running = false;
                    System.out.println("Роботу програми завершено. До побачення!");
                    break;
                default:
                    System.out.println("Помилка: Невідомий пункт меню. Спробуйте ще раз.");
            }
        }
        scanner.close();
    }

    /**
     * Зчитує дані з клавіатури, валідує їх та додає нову книгу до списку
     * Перехоплює винятки парсингу чисел та помилки валідації об'єкта
     *
     * @param scanner об'єкт Scanner для зчитування потоку вводу
     * @param list    список, у який буде збережено створену книгу
     */
    private static void addNewBook(Scanner scanner, ArrayList<Book> list) {
        try {
            System.out.print("Введіть назву книги: ");
            String title = scanner.nextLine();

            System.out.print("Введіть автора книги: ");
            String author = scanner.nextLine();

            System.out.print("Введіть рік видання: ");
            String yearInput = scanner.nextLine();
            int year = Integer.parseInt(yearInput);

            System.out.print("Введіть ціну книги: ");
            String priceInput = scanner.nextLine();
            double price = Double.parseDouble(priceInput);

            Book newBook = new Book(title, author, year, price);
            list.add(newBook);
            System.out.println("Успіх: Книгу успішно додано до системи!");

        } catch (NumberFormatException e) {
            System.out.println("Помилка введення: Для року та ціни необхідно вводити числові значення!");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка валідації даних: " + e.getMessage());
        }
    }

    /**
     * Виводить у консоль інформацію про всі збережені книги
     * Якщо список порожній, інформує про це користувача
     *
     * @param list список збережених книг
     */
    private static void showAllBooks(ArrayList<Book> list) {
        System.out.println("\n-- Зареєстрований список книг --");
        if (list.isEmpty()) {
            System.out.println("Список порожній. Жодної книги ще не створено.");
        } else {
            for (Book b : list) {
                System.out.println(b.toString());
            }
        }
    }
}
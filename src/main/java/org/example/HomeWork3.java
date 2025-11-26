package org.example;

public class HomeWork3 {
    public static void main(String[] args) {
        System.out.println("Домашняя работа 3 начата!\n");

        // Часть 1: Тестирование класса Product
        System.out.println("=== ЧАСТЬ 1: КЛАСС PRODUCT ===");

        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra",
                java.time.LocalDate.of(2025, 2, 1), "Samsung Corp.", "Korea", 55999.0, true);
        productsArray[1] = new Product("iPhone 16 Pro",
                java.time.LocalDate.of(2024, 9, 15), "Apple Inc.", "USA", 129999.0, false);

        for (int i = 0; i < 2; i++) {
            System.out.println("Товар #" + (i + 1) + ":");
            productsArray[i].printInfo();
        }

        // Часть 2: Тестирование класса Park с внутренним классом
        System.out.println("\n=== ЧАСТЬ 2: КЛАСС PARK С ВНУТРЕННИМ КЛАССОМ ===");

        // Создаем парк
        Park disneyland = new Park("Диснейленд", "Париж, Франция");

        // Добавляем аттракционы
        disneyland.addAttraction("Космическая гора", "10:00-20:00", 15.50);
        disneyland.addAttraction("Пираты Карибского моря", "09:30-19:30", 12.00);
        disneyland.addAttraction("Призрачное поместье", "11:00-21:00", 10.00);
        disneyland.addAttraction("Безумное чаепитие", "10:00-18:00", 8.50);
        disneyland.addAttraction("Автомобили Радиатор-Спрингс", "09:00-17:30", 14.75);

        // Выводим информацию о парке
        disneyland.printParkInfo();

        // Создаем еще один парк
        System.out.println("\n=== ВТОРОЙ ПАРК ===");
        Park gorkyPark = new Park("Парк Горького", "Москва, Россия");
        gorkyPark.addAttraction("Колесо обозрения", "09:00-22:00", 5.00);
        gorkyPark.addAttraction("Американские горки", "10:00-21:00", 8.00);
        gorkyPark.printParkInfo();

        // Демонстрация работы с отдельными аттракционами
        System.out.println("=== ИНФОРМАЦИЯ О ПЕРВОМ АТТРАКЦИОНЕ ДИСНЕЙЛЕНДА ===");
        Park.Attraction firstAttraction = disneyland.getAttractions()[0];
        firstAttraction.printAttractionInfo();
    }
}
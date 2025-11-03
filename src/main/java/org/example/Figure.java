package org.example;

public interface Figure {
    // Основные методы
    double calculateArea();
    double calculatePerimeter();
    String getFillColor();
    String getBorderColor();

    // Default метод для вывода информации
    default void printInfo() {
        System.out.println("Фигура: " + this.getClass().getSimpleName());
        System.out.println("Площадь: " + String.format("%.2f", calculateArea()));
        System.out.println("Периметр: " + String.format("%.2f", calculatePerimeter()));
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println("---------------------------");
    }

    // Default метод для проверки положительных значений
    default boolean isValidValue(double value) {
        return value > 0;
    }
}
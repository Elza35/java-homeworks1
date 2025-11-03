package org.example;

public class GeometryApp {
    public static void main(String[] args) {
        System.out.println("=== РАСЧЕТ ГЕОМЕТРИЧЕСКИХ ФИГУР ===\n");

        // Создаем массив фигур
        Figure[] figures = {
                new Circle(5.0, "Красный", "Черный"),
                new Rectangle(4.0, 6.0, "Синий", "Белый"),
                new Triangle(3.0, 4.0, 5.0, "Зеленый", "Желтый"),
                new Circle(7.5, "Желтый", "Красный"),
                new Rectangle(10.0, 2.5, "Фиолетовый", "Оранжевый")
        };

        // Выводим информацию о всех фигурах
        for (Figure figure : figures) {
            figure.printInfo();
        }

        // Дополнительная статистика
        System.out.println("=== СТАТИСТИКА ===");
        System.out.println("Всего фигур: " + figures.length);

        double totalArea = 0;
        double totalPerimeter = 0;

        for (Figure figure : figures) {
            totalArea += figure.calculateArea();
            totalPerimeter += figure.calculatePerimeter();
        }

        System.out.println("Общая площадь всех фигур: " + String.format("%.2f", totalArea));
        System.out.println("Общий периметр всех фигур: " + String.format("%.2f", totalPerimeter));
    }
}

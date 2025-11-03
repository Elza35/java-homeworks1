package org.example;

public class HomeWork4 {
    public static void main(String[] args) {
        // Тестирование животных
        System.out.println("=== Тестирование животных ===");
        Cat cat1 = new Cat("Барсик");
        Dog dog1 = new Dog("Бобик");

        cat1.run(150);
        cat1.run(250);
        cat1.swim(10);

        dog1.run(400);
        dog1.run(600);
        dog1.swim(5);
        dog1.swim(15);

        // Тестирование котов и миски
        System.out.println("\n=== Тестирование котов и миски ===");
        Bowl bowl = new Bowl(25);

        Cat[] cats = {
                new Cat("Мурзик"),
                new Cat("Васька"),
                new Cat("Рыжик")
        };

        // Кормим котов
        for (Cat cat : cats) {
            cat.eat(bowl, 10);
        }

        // Проверяем сытость
        System.out.println("\n=== Состояние сытости котов ===");
        for (Cat cat : cats) {
            System.out.println(cat.getName() + " сыт: " + cat.isSatiety());
        }

        // Добавляем еду и кормим снова
        System.out.println("\n=== Добавляем еду и кормим снова ===");
        bowl.addFood(20);

        for (Cat cat : cats) {
            if (!cat.isSatiety()) {
                cat.eat(bowl, 10);
            }
        }

        // Статистика
        System.out.println("\n=== Статистика ===");
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Котов: " + Cat.getCatCount());
        System.out.println("Собак: " + Dog.getDogCount());
    }
}

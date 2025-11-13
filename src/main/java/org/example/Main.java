package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ДЗ №6: Коллекции ===");

        // Тестирование задания 1 - Класс Student
        testStudent();

        // Тестирование задания 2 - Класс PhoneDirectory
        testPhoneDirectory();
    }

    private static void testStudent() {
        System.out.println("\n--- Задание 1: Класс Student ---");

        // Создаем коллекцию студентов
        Set<Student> students = new HashSet<>();

        // Создаем и настраиваем студентов
        Student student1 = new Student("Иван Иванов", "Группа А", 1);
        student1.addGrade("Математика", 4);
        student1.addGrade("Физика", 3);
        student1.addGrade("Информатика", 5);

        Student student2 = new Student("Петр Петров", "Группа Б", 1);
        student2.addGrade("Математика", 2);
        student2.addGrade("Физика", 2);
        student2.addGrade("Информатика", 3);

        Student student3 = new Student("Мария Сидорова", "Группа А", 2);
        student3.addGrade("Математика", 5);
        student3.addGrade("Физика", 4);
        student3.addGrade("Информатика", 5);

        // Добавляем студентов в коллекцию
        students.add(student1);
        students.add(student2);
        students.add(student3);

        // Выводим всех студентов
        System.out.println("Все студенты:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Печатаем студентов 1 курса
        Student.printStudents(students, 1);

        // Удаляем неуспевающих студентов
        System.out.println("\nУдаляем студентов со средним баллом < 3...");
        Student.removeUnderperformingStudents(students);

        System.out.println("Оставшиеся студенты:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Переводим на следующий курс
        System.out.println("\nПереводим студентов на следующий курс...");
        Student.promoteQualifiedStudents(students);

        System.out.println("Студенты после перевода:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void testPhoneDirectory() {
        System.out.println("\n--- Задание 2: Класс PhoneDirectory ---");

        PhoneDirectory phoneDirectory = new PhoneDirectory();

        // Добавляем записи
        phoneDirectory.add("Иванов", "+7-911-111-11-11");
        phoneDirectory.add("Иванов", "+7-911-111-11-12"); // второй номер
        phoneDirectory.add("Петров", "+7-922-222-22-22");
        phoneDirectory.add("Сидорова", "+7-933-333-33-33");
        phoneDirectory.add("иванов", "+7-911-111-11-13"); // третий номер (проверка регистра)

        // Выводим весь справочник
        phoneDirectory.displayAll();

        // Поиск по фамилиям
        System.out.println("\nПоиск по фамилиям:");
        System.out.println("Иванов: " + phoneDirectory.get("Иванов"));
        System.out.println("Петров: " + phoneDirectory.get("Петров"));
        System.out.println("Кузнецов: " + phoneDirectory.get("Кузнецов")); // не существует

        // Проверка поиска с разным регистром
        System.out.println("иванов (строчные): " + phoneDirectory.get("иванов"));
    }
}

package org.example;

import java.util.*;

public class Student {
    private String name;
    private String group;
    private int course;
    private Map<String, Integer> grades;

    public Student(String name, String group, int course) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new HashMap<>();
    }

    // Добавление оценки по предмету
    public void addGrade(String subject, int grade) {
        if (grade < 1 || grade > 5) {
            throw new IllegalArgumentException("Оценка должна быть от 1 до 5");
        }
        grades.put(subject, grade);
    }

    // Расчет среднего балла
    public double getAverageGrade() {
        if (grades.isEmpty()) return 0.0;
        return grades.values().stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    // Перевод на следующий курс
    public void promoteToNextCourse() {
        this.course++;
    }

    // Метод для печати студентов определенного курса (статический)
    public static void printStudents(Set<Student> students, int course) {
        System.out.println("Студенты " + course + " курса:");
        boolean found = false;
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(" - " + student.getName() + " (Группа: " + student.getGroup() +
                        ", Средний балл: " + String.format("%.2f", student.getAverageGrade()) + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Студентов на " + course + " курсе не найдено.");
        }
    }

    // Метод для удаления студентов с средним баллом < 3 (статический)
    public static void removeUnderperformingStudents(Set<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3.0);
    }

    // Метод для перевода студентов на следующий курс если средний балл >= 3 (статический)
    public static void promoteQualifiedStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3.0) {
                student.promoteToNextCourse();
            }
        }
    }

    // Getters
    public String getName() { return name; }
    public String getGroup() { return group; }
    public int getCourse() { return course; }
    public Map<String, Integer> getGrades() { return new HashMap<>(grades); }

    @Override
    public String toString() {
        return String.format("Студент: %s, Группа: %s, Курс: %d, Средний балл: %.2f",
                name, group, course, getAverageGrade());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course &&
                Objects.equals(name, student.name) &&
                Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, group, course);
    }
}

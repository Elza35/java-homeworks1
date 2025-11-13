package org.example;

import java.util.*;

public class PhoneDirectory {
    private Map<String, List<String>> directory;

    public PhoneDirectory() {
        this.directory = new HashMap<>();
    }

    // Добавление записи (фамилия + телефон)
    public void add(String lastName, String phoneNumber) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Фамилия не может быть пустой");
        }
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Номер телефона не может быть пустым");
        }

        // Приводим фамилию к единому формату (первая буква заглавная, остальные строчные)
        String formattedLastName = formatLastName(lastName);

        directory.computeIfAbsent(formattedLastName, k -> new ArrayList<>()).add(phoneNumber);
    }

    // Поиск номеров телефонов по фамилии
    public List<String> get(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            return new ArrayList<>();
        }
        String formattedLastName = formatLastName(lastName);
        return new ArrayList<>(directory.getOrDefault(formattedLastName, new ArrayList<>()));
    }

    // Вспомогательный метод для форматирования фамилии
    private String formatLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) return lastName;
        return lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
    }

    // Вывод всего справочника
    public void displayAll() {
        if (directory.isEmpty()) {
            System.out.println("Телефонный справочник пуст.");
            return;
        }

        System.out.println("Телефонный справочник:");
        for (Map.Entry<String, List<String>> entry : directory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Получение всех записей справочника
    public Map<String, List<String>> getAllEntries() {
        Map<String, List<String>> copy = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : directory.entrySet()) {
            copy.put(entry.getKey(), new ArrayList<>(entry.getValue()));
        }
        return copy;
    }
}

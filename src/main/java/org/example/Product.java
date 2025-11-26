package org.example;

import java.time.LocalDate;

public class Product {
    private String name;
    private LocalDate productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private double price;
    private boolean isReserved;

    // Конструктор
    public Product(String name, LocalDate productionDate, String manufacturer,
                   String countryOfOrigin, double price, boolean isReserved) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isReserved = isReserved;
    }

    // Метод для вывода информации
    public void printInfo() {
        System.out.println("=== Информация о товаре ===");
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + countryOfOrigin);
        System.out.println("Цена: " + price + " руб.");
        System.out.println("Забронирован: " + (isReserved ? "Да" : "Нет"));
        System.out.println("============================");
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public double getPrice() {
        return price;
    }

    public boolean isReserved() {
        return isReserved;
    }

    // Сеттеры (опционально, но полезно)
    public void setName(String name) {
        this.name = name;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }
}
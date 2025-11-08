package org.example.geometry;

public class Circle implements Figure {
    private double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        if (!isValidValue(radius)) {
            throw new IllegalArgumentException("Радиус должен быть положительным числом");
        }
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    // Геттер для радиуса
    public double getRadius() {
        return radius;
    }
}

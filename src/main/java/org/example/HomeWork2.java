package org.example;

import java.util.Arrays;

public class HomeWork2 {
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 5;
        int b = -3;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 75;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 8;
        int b = 12;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void checkNumberSign(int number) {
        if (number >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    public static boolean isNegative(int number) {
        return number < 0;
    }

    public static void printStringMultipleTimes(String text, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(text);
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void invertArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
        }
    }

    public static int[] fillArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    public static void multiplyLessThanSix(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
    }

    public static void fillDiagonals(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 1;
            matrix[i][matrix.length - 1 - i] = 1;
        }
    }

    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println("Домашняя работа 2 начата!");
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println("Сумма 5 и 7 в диапазоне 10-20: " + isSumInRange(5, 7));
        System.out.println("Сумма 2 и 3 в диапазоне 10-20: " + isSumInRange(2, 3));
        checkNumberSign(5);
        checkNumberSign(-3);
        checkNumberSign(0);
        System.out.println("Число -5 отрицательное: " + isNegative(-5));
        System.out.println("Число 5 отрицательное: " + isNegative(5));
        System.out.println("Число 0 отрицательное: " + isNegative(0));
        printStringMultipleTimes("Hello Java!", 3);
        System.out.println("2024 високосный: " + isLeapYear(2024));
        System.out.println("2023 високосный: " + isLeapYear(2023));
        System.out.println("2000 високосный: " + isLeapYear(2000));
        System.out.println("1900 високосный: " + isLeapYear(1900));

        int[] array10 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Исходный массив: " + Arrays.toString(array10));
        invertArray(array10);
        System.out.println("Инвертированный массив: " + Arrays.toString(array10));

        int[] array11 = fillArray();
        System.out.println("Первые 10 элементов массива: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(array11[i] + " ");
        }
        System.out.println("...");

        int[] array12 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Исходный массив: " + Arrays.toString(array12));
        multiplyLessThanSix(array12);
        System.out.println("После умножения: " + Arrays.toString(array12));

        int[][] matrix = new int[5][5];
        fillDiagonals(matrix);
        System.out.println("Матрица с диагоналями:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        int[] array14 = createArray(5, 7);
        System.out.println("Массив: " + Arrays.toString(array14));
    }
}
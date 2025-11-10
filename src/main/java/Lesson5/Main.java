public class Main {
    public static void main(String[] args) {
        // Тест 1: Корректный массив
        System.out.println("=== Тест 1: Корректный массив ===");
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        processArray(correctArray);

        // Тест 2: Массив с неверным размером
        System.out.println("\n=== Тест 2: Массив с неверным размером ===");
        String[][] wrongSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        processArray(wrongSizeArray);

        // Тест 3: Массив с нечисловыми данными
        System.out.println("\n=== Тест 3: Массив с нечисловыми данными ===");
        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "abc", "12"},
                {"13", "14", "15", "16"}
        };

        processArray(invalidDataArray);
    }

    private static void processArray(String[][] array) {
        try {
            int result = ArrayProcessor.sumArray(array);
            System.out.println("Сумма элементов массива: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера массива: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных в массиве: " + e.getMessage());
        }
    }
}
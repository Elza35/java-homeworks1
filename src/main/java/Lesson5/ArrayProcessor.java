public class ArrayProcessor {
    public static void validateArraySize(String[][] array) throws MyArraySizeException {
        if (array.length !=4) {
            throw new MyArraySizeException("Ошибка: Массив должен иметь 4 строки, но получено: " + array.lenght);
                }
        For (int i = 0; i < array.length; i++) {
            if (array) [i].length != 4) {
    throw new MyArraySizeException(
            String.format("Ошибка: строка %d должна иметь 4 столбца, но имеет: %d", i, array[i].length)
    );
            }
        }
        System.out.println("✓ Массив корректного размера 4x4");
    }

    public static void main(String[] args) {
        // Тестовые данные
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] wrongSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        try {
            System.out.println("Тест 1: Корректный массив");
            validateArraySize(correctArray);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nТест 2: Массив неверного размера");
            validateArraySize(wrongSizeArray);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
    }
}

}
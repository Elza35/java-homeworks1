public class ArrayProcessor {

    public static void validateArraySize(String[][] array) {
        if (array.length != 4) {
            throw new MyArraySizeException(
                    "Ошибка: массив должен иметь 4 строки, но получено: " + array.length
            );
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException(
                        String.format("Ошибка: строка %d должна иметь 4 столбца, но имеет: %d", i, array[i].length)
                );
            }
        }
    }

    public static int sumArray(String[][] array) {
        validateArraySize(array);

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, array[i][j]);
                }
            }
        }
        return sum;
    }
}
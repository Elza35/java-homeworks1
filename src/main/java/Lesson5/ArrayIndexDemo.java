public class ArrayIndexDemo {

    public static void demonstrateArrayIndexOutOfBounds() {
        System.out.println("\n=== Демонстрация ArrayIndexOutOfBoundsException ===");

        int[] array = {1, 2, 3, 4, 5};

        try {
            System.out.println("Попытка доступа к элементу за пределами массива:");
            for (int i = 0; i <= array.length; i++) {
                System.out.println("array[" + i + "] = " + array[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано ArrayIndexOutOfBoundsException: " + e.getMessage());
            System.out.println("Индекс вышел за границы массива длиной " + array.length);
        }

        try {
            System.out.println("\nПопытка доступа к отрицательному индексу:");
            System.out.println("array[-1] = " + array[-1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        demonstrateArrayIndexOutOfBounds();
    }
}
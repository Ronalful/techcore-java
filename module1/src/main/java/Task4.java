import java.util.Arrays;
import java.util.Random;

public class Task4 {
    public static void main(String[] args) {
        Random rand = new Random();

        int arraySize = 20;
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = rand.nextInt(20);
        }
        System.out.println("array: " + Arrays.toString(array));

        System.out.println("Максимальное значение: " + findMaxValue(array));
        System.out.println("Индекс числа 5: " + findElement(5, array));
        System.out.println("Индекс числа 10: " + findElement(10, array));
    }

    public static int findMaxValue(int[] array) {
        var maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }

    public static int findElement(int value, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}

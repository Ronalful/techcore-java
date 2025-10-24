import java.util.Arrays;
import java.util.Random;

public class Task5 {
    public static void main(String[] args) {
        Random rand = new Random();

        int arraySize = 20;
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = rand.nextInt(20);
        }
        System.out.println("array: " + Arrays.toString(array));

        bubbleSort(array);
        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }

    public static void bubbleSort(int[] arr) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    isSorted = false;
                }
            }
        }
    }
}

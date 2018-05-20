package sort.util;

import java.util.Arrays;
import java.util.Random;

import sort.Sort;

public class SortUtil {
    public static int[] generateRandomArray(int n, int min, int max) {
        assert min < max;
        int[] randomArray = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int randomInt = random.nextInt(max - min + 1) + min;
            randomArray[i] = randomInt;
        }
        return randomArray;
    }

    public static int[] generateNearlySortedArray(int n, int swapTimes) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        Random random = new Random();
        for (int i = 0; i < swapTimes; i++) {
            int randomFirstIndex = random.nextInt(n);
            int randomSecondIndex = random.nextInt(n);
            swap(array, randomFirstIndex, randomSecondIndex);
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
            System.out.println();
        }
    }

    public static void swap(int[] array, int firstPosition, int secondPosition) {
        int temp = array[firstPosition];
        array[firstPosition] = array[secondPosition];
        array[secondPosition] = temp;
    }

    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int[] copyArray(int[] array) {

        return Arrays.copyOf(array, array.length);
    }

    public static void testSort(int[] array, Sort sortAlgorithm) {
        long startTime = System.currentTimeMillis();

        int[] sortedArray = sortAlgorithm.sort(array);


        long endTime = System.currentTimeMillis();

        assert isSorted(sortedArray);

        long consumeTime = (endTime - startTime);

        System.out.println(sortAlgorithm.getClass().getSimpleName() + " : " + consumeTime + " ms");

    }
}

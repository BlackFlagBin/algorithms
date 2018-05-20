package sort.implementation;

import sort.Sort;

public class MergeSort implements Sort {

    @Override
    public int[] sort(int[] array) {

        mergeSort(array, 0, array.length - 1);
        return array;
    }

    private void mergeSort(int[] array, int left, int right) {
        if ((right - left) < 15) {
            insertionSort(array, left, right);
            return;
        }
        int middle = (left + right) / 2;
        mergeSort(array, left, middle);
        mergeSort(array, middle + 1, right);
        if (array[middle] < array[middle + 1]) {
            return;
        }
        merge(array, left, middle, right);
    }

    public static void merge(int[] array, int left, int middle, int right) {
        int[] tempArray = new int[right - left + 1];
        for (int i = left; i <= right; i++) {
            tempArray[i - left] = array[i];
        }

        int firstPosition = 0;
        int secondPosition = middle - left + 1;
        for (int finalPosition = left; finalPosition <= right; finalPosition++) {
            if (firstPosition > middle - left) {
                array[finalPosition] = tempArray[secondPosition];
                secondPosition++;
            } else if (secondPosition > right - left) {
                array[finalPosition] = tempArray[firstPosition];
                firstPosition++;
            } else if (tempArray[firstPosition] < tempArray[secondPosition]) {
                array[finalPosition] = tempArray[firstPosition];
                firstPosition++;
            } else {
                array[finalPosition] = tempArray[secondPosition];
                secondPosition++;
            }
        }
    }

    private void insertionSort(int[] array, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int element = array[i];
            int j;
            for (j = i; j > 0 && element < array[j - 1]; j--) {
                array[j - 1] = element;
            }
            array[j] = element;
        }
    }


}

package sort.implementation;

import sort.Sort;
import sort.util.SortUtil;

public class InsertionSort implements Sort {


    @Override
    public int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int element = array[i];
            int j;
            for (j = i; j > 0 && element < array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = element;
        }
        return array;
    }
}

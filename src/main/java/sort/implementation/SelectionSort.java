package sort.implementation;

import java.util.jar.JarEntry;

import sort.Sort;
import sort.util.SortUtil;

public class SelectionSort implements Sort {


    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            SortUtil.swap(array, minIndex, i);
        }
        return array;
    }
}

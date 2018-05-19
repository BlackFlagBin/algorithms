package sort.implementation;

import sort.Sort;

public class MergeSortBU implements Sort {

    @Override
    public int[] sort(int[] array) {
        for (int size = 1; size <= array.length; size += size) {
            for (int i = 0; i + size < array.length; i += size + size) {
                MergeSort.merge(array, i, i + size - 1, Math.min(i + size + size - 1, array.length - 1));
            }
        }
        return array;
    }

}

package sort.test;

import sort.implementation.InsertionSort;
import sort.implementation.MergeSort;
import sort.implementation.MergeSortBU;
import sort.implementation.SelectionSort;
import sort.util.SortUtil;

public class Test {
    public static void main(String[] args) {
        int[] array = SortUtil.generateNearlySortedArray(1000000,100);
        int[] copiedArray1 = SortUtil.copyArray(array);
        int[] copiedArray2 = SortUtil.copyArray(array);
        SortUtil.testSort(array, new InsertionSort());
        SortUtil.testSort(copiedArray1, new MergeSort());
        SortUtil.testSort(copiedArray2, new MergeSortBU());
    }
}

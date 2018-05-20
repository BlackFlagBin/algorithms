package sort.test;

import sort.implementation.InsertionSort;
import sort.implementation.MergeSort;
import sort.implementation.MergeSortBU;
import sort.implementation.QuickSort;
import sort.implementation.QuickSort3Way;
import sort.implementation.SelectionSort;
import sort.util.SortUtil;

public class Test {
    public static void main(String[] args) {
        int[] array = SortUtil.generateRandomArray(1000000, 0, 1000);
        int[] copiedArray1 = SortUtil.copyArray(array);
        int[] copiedArray2 = SortUtil.copyArray(array);
        SortUtil.testSort(array, new MergeSort());
        SortUtil.testSort(copiedArray1, new QuickSort());
        SortUtil.testSort(copiedArray2, new QuickSort3Way());
    }
}

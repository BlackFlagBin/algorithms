package sort.test;

import sort.implementation.InsertionSort;
import sort.implementation.MergeSort;
import sort.implementation.QuickSort;
import sort.implementation.QuickSort3Way;
import sort.implementation.SelectionSort;
import sort.util.SortUtil;

public class Test {
    public static void main(String[] args) {
        int[] array = SortUtil.generateRandomArray(100000, 0, 100000);
        int[] copiedArray1 = SortUtil.copyArray(array);
        int[] copiedArray2 = SortUtil.copyArray(array);
        int[] copiedArray3 = SortUtil.copyArray(array);
        int[] copiedArray4 = SortUtil.copyArray(array);

        SortUtil.testSort(array, new SelectionSort());
        SortUtil.testSort(copiedArray1, new InsertionSort());
        SortUtil.testSort(copiedArray2, new MergeSort());
        SortUtil.testSort(copiedArray3, new QuickSort());
        SortUtil.testSort(copiedArray4, new QuickSort3Way());
    }
}

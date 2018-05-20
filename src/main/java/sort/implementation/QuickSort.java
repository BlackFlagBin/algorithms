package sort.implementation;

import com.sun.tools.corba.se.idl.constExpr.ShiftRight;

import java.util.Random;

import sort.Sort;
import sort.util.SortUtil;

public class QuickSort implements Sort {

    @Override
    public int[] sort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int left, int right) {
        if (right - left < 15) {
            insertionSort(array, left, right);
            return;
        }

        int partition = partition(array, left, right);
        quickSort(array, left, partition - 1);
        quickSort(array, partition + 1, right);

    }

    private int partition(int[] array, int left, int right) {
        //随机化数组首元素
        int randomPosition = new Random().nextInt(right - left + 1) + left;
        SortUtil.swap(array, left, randomPosition);

        //array[left+1,finalPosition]<array[left] ; array[finalPosition+1,i)>=array[left]
        int finalPosition = left;
        for (int i = left + 1; i <= right; i++) {
            if (array[i] < array[left]) {
                SortUtil.swap(array, ++finalPosition, i);
            }
        }
        SortUtil.swap(array, left, finalPosition);
        return finalPosition;
    }

    private void insertionSort(int[] array, int left, int right) {
        for (int i = left + 1; i < right - left + 1; i++) {
            int element = array[i];
            int j;
            for (j = i; j > 0 && element < array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = element;

        }
    }
}

package sort.implementation;

import java.util.Random;

import sort.Sort;
import sort.util.SortUtil;

public class QuickSort3Way implements Sort {


    @Override
    public int[] sort(int[] array) {
        quickSort3Way(array, 0, array.length - 1);
        return array;
    }

    private void quickSort3Way(int[] array, int left, int right) {
        if (right - left < 15) {
            insertionSort(array, left, right);
            return;
        }

        int randomPosition = new Random().nextInt(right - left + 1) + left;
        SortUtil.swap(array, left, randomPosition);

        int element = array[left];
        int lt = left;
        int gt = right + 1;
        int currentPosition = left + 1;
        //array[left+1,lt] < element ; array[lt+1,currentPosition] = element ; array[gt,right] > element
        while (currentPosition<gt) {

            if (array[currentPosition] < element) {
                SortUtil.swap(array, lt + 1, currentPosition);
                lt++;
                currentPosition++;
            } else if (array[currentPosition] > element) {
                SortUtil.swap(array, currentPosition, gt - 1);
                gt--;
            } else if (array[currentPosition] == element) {
                currentPosition++;
            }

        }

        SortUtil.swap(array, lt, left);


        quickSort3Way(array, left, lt - 1);
        quickSort3Way(array, gt, right);
    }

    private void insertionSort(int[] array, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int element = array[i];
            int j;
            for (j = i; j > left && element < array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = element;
        }
    }


}

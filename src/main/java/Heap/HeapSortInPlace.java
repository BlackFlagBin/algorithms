package Heap;

import sort.Sort;
import sort.util.SortUtil;

public class HeapSortInPlace implements Sort {
    @Override
    public int[] sort(int[] array) {
        for (int i = 0; i < (array.length - 1 - 1) / 2; i++) {
            shiftDown(array, array.length, i);
        }

        for (int i = array.length - 1; i >= 0; i--) {
            SortUtil.swap(array,0,i);
            shiftDown(array, i, 0);
        }

        return array;
    }

    private void shiftDown(int[] array, int size, int position) {
        while (position * 2 + 1 < size) {
            int finalPosition=position*2+1;
            if (finalPosition + 1 < size && array[finalPosition + 1] > array[finalPosition]) {
                finalPosition++;
            }
            if (array[position]>=array[finalPosition]) {
                break;
            }
            SortUtil.swap(array,position,finalPosition);
            position=finalPosition;
        }
    }
}

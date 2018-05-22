package Heap;

import sort.Sort;

public class HeapSort implements Sort {


    @Override
    public int[] sort(int[] array) {
        MaxHeap maxHeap = new MaxHeap(array);
        for (int i = array.length-1; i >=0 ; i--) {
            array[i]=maxHeap.extractMax();
        }
        return array;
    }
}

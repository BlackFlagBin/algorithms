package Heap;

import sort.util.SortUtil;

public class MaxHeap {

    protected int[] mContent;
    protected int   mCount;
    protected int   mCapacity;

    public MaxHeap(int size) {
        mCapacity = size;
        mContent = new int[size + 1];
        mCount = 0;
    }

    public MaxHeap(int[] array) {
        mCapacity = array.length;
        mContent = new int[array.length + 1];
        mCount = array.length;
        for (int i = 0; i < array.length; i++) {
            mContent[i + 1] = array[i];
        }
        for (int i = mCount / 2; i > 0; i--) {
            shiftDown(i);
        }
    }

    public int getCount() {
        return mCount;
    }

    public boolean isEmpty() {
        return mCount == 0;
    }

    public void insert(int element) {
        assert mCount + 1 <= mCapacity;
        mCount++;
        mContent[mCount] = element;
        shiftUp(mCount);
    }

    private void shiftUp(int position) {
        while (position > 1 && mContent[position / 2] < mContent[position]) {
            SortUtil.swap(mContent, position, position / 2);
            position /= 2;
        }
    }

    public int extractMax() {
        int result = mContent[1];
        SortUtil.swap(mContent, 1, mCount);
        mCount--;
        shiftDown(1);
        return result;
    }

    private void shiftDown(int position) {
        while (position * 2 <= mCount) {
            int finalPosition = position * 2;
            if (finalPosition + 1 <= mCount && mContent[finalPosition] < mContent[finalPosition + 1]) {
                finalPosition++;
            }
            if (mContent[position] > mContent[finalPosition]) {
                break;
            }
            SortUtil.swap(mContent, position, finalPosition);
            position = finalPosition;
        }
    }

    public static void main(String[] args) {

        MaxHeap maxHeap = new MaxHeap(100);
        int N = 50; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for (int i = 0; i < N; i++)
            maxHeap.insert((int) (Math.random() * M));
        System.out.println(maxHeap.getCount());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = maxHeap.extractMax();
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 确保arr数组是从大到小排列的
        for (int i = 1; i < N; i++)
            assert arr[i - 1] >= arr[i];

    }

}

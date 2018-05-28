package Heap;

import sort.util.SortUtil;

public class IndexMaxHeap {
    protected int[] mIndexArray;
    protected int[] mDataArray;
    protected int   mCount;
    protected int   mCapacity;

    public IndexMaxHeap(int size) {
        mCapacity = size;
        mDataArray = new int[size + 1];
        mIndexArray = new int[size + 1];
        mCount = 0;
    }

    public IndexMaxHeap(int[] array) {
        mCapacity = array.length;
        mDataArray = new int[array.length + 1];
        mIndexArray = new int[array.length + 1];
        mCount = array.length;
        for (int i = 0; i < array.length; i++) {
            mDataArray[i + 1] = array[i];
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

    public void insert(int i, int element) {
        assert mCount + 1 <= mCapacity;
        assert i + 1 >= 1 && i + 1 <= mCapacity;
        i += 1;
        mCount++;
        mIndexArray[mCount] = i;
        mDataArray[i] = element;
        shiftUp(mCount);
    }

    private void shiftUp(int position) {
        while (position > 1 && mDataArray[mIndexArray[position / 2]] < mDataArray[mIndexArray[position]]) {
            SortUtil.swap(mIndexArray, position, position / 2);
            position /= 2;
        }
    }

    public int extractMax() {
        int result = mDataArray[mIndexArray[1]];
        SortUtil.swap(mIndexArray, 1, mCount);
        mCount--;
        shiftDown(1);
        return result;
    }

    public int getMaxIndex() {
        assert mCount > 0;
        return mIndexArray[1] - 1;
    }

    public int getItem(int position) {

        return mDataArray[position + 1];
    }

    private void shiftDown(int position) {
        while (position * 2 <= mCount) {
            int finalPosition = position * 2;
            if (finalPosition + 1 <= mCount && mDataArray[mIndexArray[finalPosition]] < mDataArray[mIndexArray[finalPosition + 1]]) {
                finalPosition++;
            }
            if (mDataArray[mIndexArray[position]] > mDataArray[mIndexArray[finalPosition]]) {
                break;
            }
            SortUtil.swap(mIndexArray, position, finalPosition);
            position = finalPosition;
        }
    }

    public void change(int i, int value) {
        assert i>=0&&i<mCount;
        i+=1;
        mDataArray[i]=value;
        for (int j = 1; j < mCount; j++) {
            if (mIndexArray[j] == i) {
                shiftDown(j);
                shiftUp(j);
                return;
            }
        }

    }


}

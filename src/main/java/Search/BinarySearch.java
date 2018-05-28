package Search;

public class BinarySearch {

    public int search(int[] array,int target) {
        int l=0;
        int r=array.length-1;
        while (l <= r) {
            int mid=l/2+r/2;
            if (target == array[mid]) {
                return mid;
            }

            if (target < array[mid]) {
                r=mid-1;
            } else {
                l=mid+1;
            }
        }
        return -1;
    }
}

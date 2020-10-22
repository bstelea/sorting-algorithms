import java.util.Arrays;

public class PancakeSort {
    public void flip(int[] arr, int i) {
        int tmp, start = 0;
        while (start < i) {
            tmp = arr[start];
            arr[start] = arr[i];
            arr[i] = tmp;
            start++;
            i--;
        }
    }

    public int findMax(int[] arr, int n) {
        int mi, i;
        for (mi = 0, i = 0; i < n; i++) {
            if (arr[i] > arr[mi]) {
                mi = i;
            }
        }
        return mi;
    }

    public void pancakeSort(int[] arr, int n) {
        for (int currSize = n; currSize > 1; currSize--) {
            int mi = findMax(arr, currSize);

            if (mi != currSize - 1) {
                flip(arr, mi);
                flip(arr, currSize- 1 );
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {23, 10, 20, 11, 12, 6, 7};
        int n = arr.length;
        System.out.println("Given array: " + Arrays.toString(arr));

        PancakeSort ps = new PancakeSort();
        ps.pancakeSort(arr, n);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
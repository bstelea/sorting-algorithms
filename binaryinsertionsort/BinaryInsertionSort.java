import java.util.Arrays;

public class BinaryInsertionSort {
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];

            int j = Math.abs(Arrays.binarySearch(arr, 0, i, x) + 1);

            System.arraycopy(arr, j, arr, j + 1, i - j);

            arr[j] = x;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 37, 23, 0, 17, 12, 72, 31, 46, 100, 88, 54 };
        System.out.println("Given array: " + Arrays.toString(arr));

        BinaryInsertionSort bis = new BinaryInsertionSort();
        bis.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
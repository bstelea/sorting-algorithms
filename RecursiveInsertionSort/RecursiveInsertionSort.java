import java.util.Arrays;

public class RecursiveInsertionSort {
    void insertionSortRecursive(int[] arr, int n) {
        if (n <= 1) return;

        insertionSortRecursive(arr, n - 1);

        int last = arr[n - 1];
        int j = n - 2;

        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = last;
    }  

    public static void main(String[] args) {
        int[] arr = { 423, 51, 678, 1, 14, 56, 64, 41, 23 };

        RecursiveInsertionSort ris = new RecursiveInsertionSort();

        ris.insertionSortRecursive(arr, arr.length);

        System.out.println("The sorted array is: ");
        System.out.println(Arrays.toString(arr));
    }
}
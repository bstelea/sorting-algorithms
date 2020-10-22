import java.util.Arrays;

public class RecursiveBubbleSort {
    void bubbleSort(int[] arr, int n) {
        if (n == 1) return;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int aux = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = aux;
            }
        }

        bubbleSort(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 423, 51, 678, 1, 14, 56, 64, 41, 23 };

        RecursiveBubbleSort rbs = new RecursiveBubbleSort();
        rbs.bubbleSort(arr, arr.length);

        System.out.println("Sorted array: ");
        System.out.println(Arrays.toString(arr));
    }
}
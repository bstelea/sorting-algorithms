package sort.heapsort;

import java.util.Arrays;

public class HeapSort {
    public void sort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int aux = arr[0];
            arr[0] = arr[i];
            arr[i] = aux;

            heapify(arr, i, 0);
        }
    }

    void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            int aux = arr[i];
            arr[i] = arr[largest];
            arr[largest] = aux;

            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6, 7 };

        HeapSort hs = new HeapSort();
        hs.sort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
package sort.timsort;

import java.util.Arrays;

public class TimSort {
    private final int RUN = 32;
    
    public void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int tmp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > tmp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = tmp;
        }
    }

    public void merge(int[] arr, int l, int m, int r) {
        int len1 = m - l + 1;
        int len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];
        
        for (int i = 0; i < len1; i++) {
            left[i] = arr[l + i];
        }   

        for (int i = 0; i < len2; i++) {
            right[i] = arr[m + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < len1 && j < len2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < len1) {
            arr[k] = left[i];
            k++;
            i++;
        }

        while (j < len2) {
            arr[k] = right[j];
            k++;
            j++;
        }
    }

    public void timSort(int[] arr, int n) {
        for (int i = 0; i < n; i += RUN) {
            insertionSort(arr, i, Math.min((i + RUN - 1), (n - 1)));
        }

        for (int size = RUN; size < n; size *= 2) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));

                merge(arr, left, mid, right);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 21, 7, 23, 19 };
        int n = arr.length;
        System.out.println("Given array: " + Arrays.toString(arr));

        TimSort tim = new TimSort();
        tim.timSort(arr, n);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
    
}
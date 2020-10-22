package sort.shellsort;

import java.util.Arrays;

public class ShellSort {
    public void sort(int[] arr) {
        int n = arr.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int aux = arr[i];

                int j;
                for (j = i; j >= gap && arr[j - gap] > aux; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                arr[j] = aux;
            }
        }
    }   

    public static void main(String[] args) {
        int arr[] = { 12, 34, 54, 2, 3 };
        System.out.println("Given array: " + Arrays.toString(arr));

        ShellSort ss = new ShellSort();
        ss.sort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
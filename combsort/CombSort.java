package sort.combsort;

import java.util.Arrays;

public class CombSort {
    public int getNextGap(int gap) {
        gap = (gap * 10) / 13;
        if (gap < 1) {
            return 1;
        }
        return gap;
    }

    public void sort(int[] arr) {
        int n = arr.length;
        int gap = n;
        boolean swapped = true;

        while (gap != 1 || swapped == true) {
            gap = getNextGap(gap);

            swapped = false;

            for (int i = 0; i < n - gap; i++) {
                if (arr[i] > arr[i + gap]) {
                    int aux = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = aux;

                    swapped = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 8, 4, 1, 56, 3, -44, 23, -6, 28, 0 };
        System.out.println("Given array: " + Arrays.toString(arr));

        CombSort comb = new CombSort();
        comb.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));

    }
}
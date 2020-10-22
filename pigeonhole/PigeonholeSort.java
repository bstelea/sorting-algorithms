package sort.pigeonhole;

import java.util.Arrays;

public class PigeonholeSort {
    public void pigeonholeSort(int[] arr, int n) {
        int min = arr[0];
        int max = arr[0];
        int range, i, j, index;

        for (int k = 0; k < n; k++) {
            if (arr[k] > max) {
                max = arr[k];
            }
            if (arr[k] < min) {
                min = arr[k];
            }
        }

        range = max - min + 1;
        int[] phole = new int[range];
        Arrays.fill(phole, 0);

        for (i = 0; i < n; i++) {
            phole[arr[i] - min]++;
        }

        index = 0;

        for (j = 0; j < range; j++) {
            while (phole[j] --> 0) {
                arr[index++] = j + min;
            }
        }
    }
    
    public static void main(String[] args) {
        PigeonholeSort ps = new PigeonholeSort();
        int[] arr = {8, 3, 2, 7, 4, 6, 8};
        System.out.println("Given array: " + Arrays.toString(arr));

        ps.pigeonholeSort(arr, arr.length);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
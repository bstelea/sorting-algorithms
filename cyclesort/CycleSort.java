package sort.cyclesort;

import java.util.Arrays;

public class CycleSort {
    public void cycleSort(int[] arr, int n) {
        int writes = 0;

        for (int cycleStart = 0; cycleStart < n - 1; cycleStart++) {
            int item = arr[cycleStart];

            int pos = cycleStart;
            for (int i = cycleStart + 1; i < n; i++) {
                if (arr[i] < item) {
                    pos++;
                }
            }

            if (pos == cycleStart) {
                continue;
            }

            while (item == arr[pos]) {
                pos++;
            }

            if (pos != cycleStart) {
                int aux = item;
                item = arr[pos];
                arr[pos] = aux;
                writes++;
            }

            while (pos != cycleStart) {
                pos = cycleStart;

                for (int i = cycleStart + 1; i < n; i++) {
                    if (arr[i] < item) {
                        pos++;
                    }
                }

                while (item == arr[pos]) {
                    pos++;
                }

                if (item != arr[pos]) {
                    int aux = item;
                    item = arr[pos];
                    arr[pos] = aux;
                    writes++;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int arr[] = { 1, 8, 3, 9, 10, 10, 2, 4 };
        int n = arr.length;
        System.out.println("Given array: " + Arrays.toString(arr));

        CycleSort cs = new CycleSort();
        cs.cycleSort(arr, n);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
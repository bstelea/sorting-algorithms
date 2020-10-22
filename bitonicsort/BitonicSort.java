import java.util.Arrays;

public class BitonicSort {
    // dir == 0: DESCENDING
    // dir == 1: ASCENDING
    public void compAndSwap(int[] a, int i, int j, int dir) {
        if ((a[i] > a[j] && dir == 1) || (a[i] < a[j] && dir == 0)) {
            int aux = a[i];
            a[i] = a[j];
            a[j] = aux;
        }
    }

    public void bitonicMerge(int[] a, int low, int count, int dir) {
        if (count > 1) {
            int k = count / 2;
            for (int i = low; i < low + k; i++) {
                compAndSwap(a, i, i + k, dir);
            }
            bitonicMerge(a, low, k, dir);
            bitonicMerge(a, low + k, k, dir);
        }
    }

    public void bitonicSort(int[] a, int low, int count, int dir) {
        if (count > 1) {
            int k = count / 2;

            bitonicSort(a, low, k, 1);

            bitonicSort(a, low + k, k, 0);

            bitonicMerge(a, low, count, dir);
        }
    }

    public void sort(int[] a, int N, int up) {
        bitonicSort(a, 0, N, up);
    }

    public static void main(String[] args) {
        int[] a = {3, 7, 4, 8, 6, 2, 1, 5};
        int up = 1;
        System.out.println("Given array: " + Arrays.toString(a));

        BitonicSort bitonic = new BitonicSort();
        bitonic.sort(a, a.length, up);
        
        System.out.println("Sorted array: " + Arrays.toString(a));
    }
}
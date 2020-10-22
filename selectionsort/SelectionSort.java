package javaroot.sort.selectionsort;

public class SelectionSort {
    void sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }

            int aux = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = aux;
        }
    }

    static void printArr(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 423, 51, 678, 1, 14, 56, 64, 41, 23 };
        SelectionSort ss = new SelectionSort();
        ss.sort(arr);
        printArr(arr);
    }
}
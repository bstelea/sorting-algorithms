package sort.cocktailsort;

import java.util.Arrays;

public class CocktailSort {
    public void cocktailSort(int[] arr) {
        boolean swapped = true;
        int start = 0;
        int end = arr.length;

        while (swapped) {
            swapped = false;

            for (int i = start; i < end - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int aux = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = aux;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }

            end--;

            for (int i = end - 1; i >= start; i--) {
                if (arr[i] > arr[i + 1]) {
                    int aux = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = aux;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }

            start++;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = { 5, 1, 4, 2, 8, 0, 2 };
        
        System.out.println("Given array: " + Arrays.toString(arr));
        CocktailSort cs = new CocktailSort();
        cs.cocktailSort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
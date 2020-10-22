import java.util.Arrays;

public class BogoSort {
    public void bogoSort(int[] arr) {
        while (!isSorted(arr)) {
            shuffle(arr);
        }
    }

    public void shuffle(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            swap(arr, i, (int) (Math.random() * i));
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 1, 0, 4};
        System.out.println("Given array: " + Arrays.toString(arr));

        BogoSort bogo = new BogoSort();
        bogo.bogoSort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
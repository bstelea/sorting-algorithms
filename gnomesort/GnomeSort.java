import java.util.Arrays;

public class GnomeSort {
    public void gnomeSort(int[] arr, int n) {
        int index = 0;

        while (index < n) {
            if (index == 0) {
                index++;
            }
            if (arr[index] >= arr[index - 1]) {
                index++;
            } else {
                int tmp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = tmp;
                index--;
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[] arr = { 34, 2, 10, -9 };
        System.out.println("Given array: " + Arrays.toString(arr));

        GnomeSort gnome = new GnomeSort();
        gnome.gnomeSort(arr, arr.length);

        System.out.println("Sorted array: " + Arrays.toString(arr));

    }
}
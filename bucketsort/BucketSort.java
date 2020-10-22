package sort.bucketsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {
    public void bucketSort(float[] arr, int n) {
        ArrayList<ArrayList<Float>> b = new ArrayList<ArrayList<Float>>(n);

        for (int i = 0; i < n; i++) {
            b.add(new ArrayList<Float>());
        }

        for (int i = 0; i < n; i++) {
            int bi = (int) (n * arr[i]);
            b.get(bi).add(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(b.get(i));
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < b.get(i).size(); j++) {
                arr[index++] = b.get(i).get(j);
            }
        }
    }

    public static void main(String[] args) {
        float[] arr = { 0.897f, 0.565f, 0.656f, 0.1234f, 0.665f, 0.3434f };
        int n = arr.length;
        System.out.println("Given array: " + Arrays.toString(arr));

        BucketSort bucket = new BucketSort();
        bucket.bucketSort(arr, n);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
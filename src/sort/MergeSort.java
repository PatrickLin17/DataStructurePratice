package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {2, 8, 3, 4};
        int[] ints = mergeSort(arr);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] arr = new int[left.length + right.length];

        int left_index = 0;
        int right_index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (left_index >= left.length) {
                arr[i] = right[right_index++];
            } else if (right_index >= right.length) {
                arr[i] = left[left_index++];
            } else if (left[left_index] < right[right_index]) {
                arr[i] = left[left_index++];
            } else {
                arr[i] = right[right_index++];
            }
        }
        return arr;
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }
}

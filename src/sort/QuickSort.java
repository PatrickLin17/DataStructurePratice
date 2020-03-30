package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {4, 2, 18, 9, 6, 7, 3, 8};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }


    public static void quickSort(int[] arr, int begin, int end) {
        if (arr.length <= 1 || begin >= end) {
            return;
        }
        int pivotIndex = partition(arr, begin, end);

        quickSort(arr, begin, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, end);
    }

    public static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int pivotIndex = begin;

        for (int i = begin; i < end; i++) {
            if (arr[i] < pivot) {
                if (i > pivotIndex) {
                    swap(arr, i, pivotIndex);
                }
                pivotIndex++;
            }

        }
        swap(arr, pivotIndex, end);
        return pivotIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}

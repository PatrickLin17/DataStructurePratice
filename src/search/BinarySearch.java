package search;

import sort.QuickSort;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 6, 8, 9, 9, 7, 9, 11};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        int index = lastIndexByBinarySearch(arr, 9);
        System.out.println(index);
    }

    public static int firstIndexByBinarySearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (arr[mid] == value) {
                if (mid == 0 || arr[mid] != arr[mid - 1]) {
                    return mid + 1;
                } else {
//                    high = mid - 1;
                    while (arr[mid]==arr[mid-1]){
                        mid--;
                    }
                    return mid+1;
                }
            } else if (arr[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int lastIndexByBinarySearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (arr[mid] == value) {
                if (mid == arr.length-1 || arr[mid] != arr[mid + 1]) {
                    return mid + 1;
                } else {
//                    high = mid - 1;
                    while (arr[mid]==arr[mid+1]){
                        mid++;
                    }
                    return mid+1;
                }
            } else if (arr[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}

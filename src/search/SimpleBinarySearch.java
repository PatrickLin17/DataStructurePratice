package search;

import sort.QuickSort;

import java.util.Arrays;

public class SimpleBinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 7, 9, 11};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
//        int index = binarySearch(arr, 11);
        int index = recursionBinarySearch(arr, 9,0,arr.length-1);
        System.out.println(index);
    }

    public static int binarySearch(int[] arr, int element) {

        int high = arr.length - 1;
        int low = 0;


        while (high >= low) {
            int mid = (high + low) / 2;
            if (arr[mid] == element) {
                return mid + 1;
            } else if (arr[mid] > element) {
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int recursionBinarySearch(int[] arr, int element, int low, int high) {
        int mid = (high+low)/2;
        if (arr[mid]==element){
            return mid+1;
        }
        else if (arr[mid]>element){
            return recursionBinarySearch(arr,element,low,mid-1);
        }
        else return recursionBinarySearch(arr,element,mid+1,high);
    }
}

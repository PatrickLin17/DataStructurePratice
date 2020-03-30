package sort;

import java.util.Arrays;

public class SelectedSort {
    public static void main(String[] args) {
        int arr[] = {4, 2, 18, 9, 6, 7, 3, 84};
        selectedSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectedSort(int[] arr) {
        if (arr.length <= 1) return;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

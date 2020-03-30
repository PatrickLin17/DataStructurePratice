package sort;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 5, 4, 8, 7, 9, 6, 3, 5, 2, 1, 6, 5, 7, 6};
        countingSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(getRank(arr, 3));
    }

    public static int[] countingSort(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }

        int countingLength = (max - min) + 1;
        int[] countingArr = new int[countingLength];

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            countingArr[num - min]++;
        }

        int arrIndex = 0;
        for (int i = 0; i < countingArr.length; i++) {
            if (countingArr[i] > 0) {
                for (int j = 0; j < countingArr[i]; j++) {
                    arr[arrIndex] = i + min;
                    arrIndex++;
                }
            }
        }
        return arr;
    }



    public static int getRank(int[] arr, int index) {
        if (arr[index] != arr[index - 1]) {
            return index + 1;
        } else return getRank(arr, index - 1);
    }
}

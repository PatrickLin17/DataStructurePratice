package day04.heap;

public class HeapSort {
    /**
     * 建堆：
     * 1、堆化处理
     * 2、数据交换
     */

    //元素交换
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void heapT2B(int[] arr, int begin, int end) {
        while (true) {
            int maxPos = begin;
            if (begin / 2 <= end && arr[maxPos] < arr[begin / 2]) {
                maxPos = begin / 2;
            }
            if (begin / 2 + 1 <= end && arr[maxPos] < arr[begin / 2 + 1]) {
                maxPos = begin / 2 + 1;
            }
            if (maxPos == begin) {
                break;
            }
            swap(arr, begin, maxPos);
            begin = maxPos;
        }
    }

    private void buildHeap(int[] data, int n) {
        //从后往前处理数组数据，堆化的时候是自上而下堆化的
        for (int i = n / 2; i > 0; i--) {
            heapT2B(data, i, n);
        }
    }
}

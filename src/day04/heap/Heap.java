package day04.heap;

import java.util.Arrays;

/**
 * 实现堆结构+操作
 */
public class Heap {

    //创建一个存储堆中元素的数组
    private int[] data;

    //堆中存储数据的最大个数
    private int size;

    //堆中已经存储的元素个数
    private int count;

    public Heap(int cp) {
        data = new int[cp + 1];
        count = 0;
        size = cp;
    }

    @Override
    public String toString() {
        return "Heap{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                ", count=" + count +
                '}';
    }

    //元素交换
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    //堆化操作
    private void heapB2T(int[] data, int end) {
        int i = end;
        while (i / 2 > 0 && data[i / 2] < data[i]) {
            swap(data, i / 2, i);
            i /= 2;
        }
    }

    public void insert(int data) {
        if (count >= size) {
            return;
        }
        this.data[++count] = data;
        heapB2T(this.data, count);
    }


    //自顶向下堆化的方法
    private void heapT2B(int[] arr, int begin, int end) {
        int max = begin;
        if (2 * begin <= end && arr[2*begin]>arr[max]){
            max = 2*begin;
        }
        if (2 * begin+1 <= end && arr[2*begin+1]>arr[max]){
            max = 2*begin+1;
        }
        if (max ==begin){
            return;
        }
        swap(arr,begin,max);
        begin = max;
        heapT2B(arr,begin,end);
    }

    public int removeTop() {
        int max = data[1];
        data[1] = data[count--];
        heapT2B(data, 1, count);
        return max;
    }
}

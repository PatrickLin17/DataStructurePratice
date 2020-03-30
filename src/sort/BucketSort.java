package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BucketSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(2);
        list.add(18);
        list.add(9);
        list.add(6);
        list.add(7);
        list.add(3);
        list.add(84);
        List<Integer> result = bucketSort(list, 2);
        System.out.println(result);
    }

    public static List<Integer> bucketSort(List<Integer> array, int bucketSize) {
        //设置合法性判断
        if (array == null || array.size() < 2 || bucketSize < 1) {
            return array;
        }

        int max = array.get(0);
        int min = array.get(0);

        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) > max) {
                max = array.get(i);
            }
            if (array.get(i) < min) {
                min = array.get(i);
            }
        }

        int bucketNum = (max - min) / bucketSize + 1;
        List<List<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new ArrayList<Integer>());
        }


        //将待排序的元素依次加入对应的桶中

        for (int i = 0; i < array.size(); i++) {
            int bucketIndex = (array.get(i) - min) / bucketSize;
            bucketList.get(bucketIndex).add(array.get(i));
        }

        //通过递归调用给桶内元素排序
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < bucketList.size(); i++) {
            List<Integer> everyBucket = bucketList.get(i);
            if (everyBucket.size() > 0) {
                if (bucketNum == 1) {
                    bucketSize--;
                }
                List<Integer> temp = bucketSort(everyBucket, bucketSize);
                for (int j = 0; j < temp.size(); j++) {
                    resultList.add(temp.get(j));
                }
            }
        }
        return resultList;
    }
}

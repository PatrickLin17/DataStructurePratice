package Queue;

import java.util.Arrays;

public class ArrayQueue {
    //默认容量
    private static final int DEFAULT_QUEUE_CAPACITY = 10;

    private int size = 0;

    private int head;

    private int tail;

    private Object[] elements;

    //最大容量
    private static final int MAX_QUEUE_SIZE = Integer.MAX_VALUE - 8;

    //无参构造
    public ArrayQueue() {
        elements = new Object[DEFAULT_QUEUE_CAPACITY];
        initPoint(0, 0);
    }


    //初始化指针
    private void initPoint(int head, int tail) {
        this.head = head;
        this.tail = tail;
    }

    //有参构造
    public ArrayQueue(int capacity) {
        if (capacity <= 0) {
            throw new RuntimeException("初始化容量有误！");
        }
        elements = new Object[capacity];
        initPoint(0, 0);
    }


    //入队列（支持动态扩容）
    public boolean enQueue(Object obj) {
        //检验队列容量是否够用
        ensureSizeHelper();
        elements[tail++] = obj;
        size++;
        return true;
    }


    private void ensureSizeHelper() {
        //尾指针已经越过尾部
        if (tail == elements.length && size == elements.length) {
            if (head == 0) {
                //扩容操作
                grow(size);
            } else {
                //数据搬移
                for (int i = head; i < tail; i++) {
                    elements[i - head] = elements[i];
                }
                initPoint(0, tail - head);
            }
        }
    }
    //出队列
    public Object deQueue(){
        if (head==tail){
            return null;
        }
        Object element = elements[head++];
        size--;
        return element;
    }

    //动态扩容机制
    private void grow(int oldSize) {
        //扩容1.5倍
        int newSize = oldSize + (oldSize >> 1);
        if (newSize - oldSize < 0) {
            newSize = DEFAULT_QUEUE_CAPACITY;
        }
        if (newSize > MAX_QUEUE_SIZE) {
            newSize = MAX_QUEUE_SIZE;
        }

        Object[] temporaryArray = Arrays.copyOf(elements, elements.length);
        elements  = new Object[newSize];
        for (int i = 0; i < temporaryArray.length; i++) {
            elements[i] = temporaryArray[i];
        }
    }
}

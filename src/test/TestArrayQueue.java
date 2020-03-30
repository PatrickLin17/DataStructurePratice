package test;

import Queue.ArrayQueue;

public class TestArrayQueue {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enQueue("1");
        arrayQueue.enQueue("2");
        arrayQueue.enQueue("3");
        arrayQueue.enQueue("4");
        arrayQueue.enQueue("5");
        arrayQueue.enQueue("6");
        arrayQueue.enQueue("7");
        arrayQueue.enQueue("8");
        arrayQueue.enQueue("9");
        arrayQueue.enQueue("10");
        arrayQueue.enQueue("11");


        for (int i = 0; i < 3; i++) {
            Object o = arrayQueue.deQueue();
            System.out.println(o);
        }
        System.out.println(arrayQueue);
        arrayQueue.enQueue("12");
        arrayQueue.enQueue("13");
        arrayQueue.enQueue("14");
        arrayQueue.enQueue("15");
        System.out.println(arrayQueue);

    }
}

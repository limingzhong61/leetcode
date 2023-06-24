package lmz.util.solution_template.data_structure.queue;

/**
 * leetcode662:
 * 设计循环队列
 * 多用一格空结点用来区分，空和满的状态
 * head==rear表示为空，插入位置为rear+1;
 * (rear + 1) % len == head 为满
 */
class MyCircularQueue {
    /**
     * 循环队列长度固定
     */
    int[] elements;
    int front;
    int rear;
    private int capacity;

    public MyCircularQueue(int k) {
        //多用一格空结点用来区分，空和满的状态
        capacity = k + 1;
        elements = new int[capacity];
        //初始head==rear表示为空，插入位置为rear+1;
        front = 0;
        rear = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % capacity;
        elements[rear] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        return true;
    }

    /**
     *  从队首获取元素。如果队列为空，返回 -1 。
     */
    public int Front() {
        if(isEmpty()){
            return  -1;
        }
        return elements[(front + 1) % capacity];
    }

    /**
     * 获取队尾元素。如果队列为空，返回 -1 。
     */
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return elements[rear];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}

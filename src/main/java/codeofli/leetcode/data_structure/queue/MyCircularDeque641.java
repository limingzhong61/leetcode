package codeofli.leetcode.data_structure.queue;

/**
 * 641. 设计循环双端队列
 */
public class MyCircularDeque641 {
    /**
     * 用k+1大小的数组构成循环队列
     * front == rear 为空
     * (rear + 1) % size == front 为满
     * rear的下一个位置为插入位置，front为插入位置。
     *
     * 代码优化：把next操作和prev操作抽象出来，提高可读性与可维护性。
     */
    class MyCircularDeque {
        int front;
        int rear;
        int[] elements;
        int capacity;

        public MyCircularDeque(int k) {
            elements = new int[k + 1];
            capacity = elements.length;
            front = rear = 0;
        }
        //把next操作和prev操作抽象出来，提高可读性与可维护性。
        private  int next(int pos){
            return (pos + 1) % capacity;
        }
        private  int prev(int pos){
            return (pos - 1 + capacity) % capacity;
        }
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            elements[front] = value;
            front = prev(front);
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            rear = next(rear);
            elements[rear] = value;
            return true;
        }

        public boolean deleteFront() {
            if(isEmpty()){
                return false;
            }
            front = next(front);
            return  true;
        }

        public boolean deleteLast() {
            if(isEmpty()){
                return false;
            }
            rear = prev(rear);
            return  true;
        }
        //从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
        public int getFront() {
            if(isEmpty()){
                return -1;
            }
            return elements[(front + 1) % capacity];
        }

        public int getRear() {
            if(isEmpty()){
                return -1;
            }
            return elements[rear];
        }

        public boolean isEmpty() {
            return  front == rear;
        }

        public boolean isFull() {
            return next(rear) == front;
        }
    }
}

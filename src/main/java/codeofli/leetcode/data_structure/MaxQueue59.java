package codeofli.leetcode.data_structure;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue59 {
    /**
     * 思路：维护一个单调的双端队列
     */
    class MaxQueue {
        Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> deque = new LinkedList<>();

        public MaxQueue() { }

        public int max_value() {
            if(deque.isEmpty()){
                return  -1;
            }
            return deque.peekFirst();
        }

        public void push_back(int value) {
            queue.add(value);
            //删除队尾小于当前元素的值
            while(!deque.isEmpty() && value > deque.getLast()){
                deque.removeLast();
            }
            //deque中：大于val的元素+val
            deque.addLast(value);
        }

        public int pop_front() {
            if(queue.isEmpty()){
                return -1;
            }
            //当前出队是最大元素,Integer注意使用equals比较
            if(queue.peek().equals(deque.getFirst())){
                deque.removeFirst();
            }
            return queue.poll();
        }
    }

    public static void main(String[] args) {
        //MaxQueue maxQueue = new MaxQueue();
        //System.out.println(maxQueue.max_value());
        //System.out.println(maxQueue.pop_front());
        //System.out.println(maxQueue.max_value());
        //maxQueue.push_back(46);
        //System.out.println(maxQueue.max_value());
        //System.out.println(maxQueue.pop_front());
        //System.out.println(maxQueue.max_value());
        //System.out.println(maxQueue.pop_front());
        //maxQueue.push_back(868);
        //System.out.println(maxQueue.pop_front());
    }
}
/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
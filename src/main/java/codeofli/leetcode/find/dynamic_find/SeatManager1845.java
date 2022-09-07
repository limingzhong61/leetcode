package codeofli.leetcode.find.dynamic_find;

import java.util.PriorityQueue;

public class SeatManager1845 {
    /**
     * 动态查找最小值，使用优先队列；小根堆
     */
    class SeatManager {
        PriorityQueue<Integer> minHeap;
        public SeatManager(int n) {
            minHeap = new PriorityQueue<>(n);
            for(int i = 1; i <= n; i++){
                minHeap.add(i);
            }
        }
        //每一次对 reserve 的调用，题目保证至少存在一个可以预约的座位。
        public int reserve() {
            return minHeap.poll();
        }
        //每一次对 unreserve 的调用，题目保证 seatNumber 在调用函数前都是被预约状态。
        public void unreserve(int seatNumber) {
            minHeap.remove(seatNumber);
        }
    }

}

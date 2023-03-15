package lmz.leetcode.other.easy.old;

/**
 * @author: limingzhong
 * @create: 2023-03-15 14:18
 */
public class MovingAverageII041 {
    class MovingAverage {
        int size;
        int cnt = 0;
        int total = 0;
        int idx = 0;
        int[] arr;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            this.size = size;
            arr = new int[size];
        }

        public double next(int val) {
            cnt++;
            idx++;
            total += val;
            arr[idx % size] = val;

            if (cnt > size) {
                total -= arr[(idx - 3) % size];
                System.out.printf("%d,%d,%d\n",cnt,idx, arr[(idx - 3) % size]);
                cnt = size;
            }
            return (double) total / cnt;
        }
    }
}

package lmz.leetcode.other.easy.old;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * @author: codeofli
 * @create: 2022-10-29 21:11
 */
public class MincostToHireWorkers857 {
    /**
     * 贪心+优先队列
     */
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        var id = IntStream.range(0,n).boxed().toArray(Integer[]::new);
        double[] rate = new double[n];
        for(int i = 0; i < n; i++){
            rate[i] = (double) wage[i] / quality[i];
        }
        Arrays.sort(id,(a,b) -> (int)(rate[a] - rate[b])); // 按照 r 值排序
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b -a);  // 最大堆
        int qSum = 0;
        for(int i = 0; i < k; i++){
            pq.add(quality[id[i]]);
            qSum += quality[id[i]];
        }
        double res = rate[id[k - 1]] * qSum;       // 选 r 值最小的 k 名工人组成当前的最优解
        for(int i = k; i < n; i++){
            int q = quality[id[i]];
            if(q < pq.peek()){  // sumQ 可以变小，从而可能得到更优的答案; 因为总cost + q * rate[id[i]]
                qSum -= pq.poll() - q;
                pq.add(q);
                res = Math.min(res,qSum * rate[id[i]]);
            }
        }
        return res;
    }
}

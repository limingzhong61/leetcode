package lmz.leetcode.contest.old.c86;

import lmz.leetcode.bruce_solution.bruce_search.my.leetcode.TransformUtil;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class MaximumRobots6143 {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length, ans = 0;
        // 记录窗口左右边界
        int left = 0, right = 0;
        // 记录窗口中各个值的状态
        long cost = 0, maxv = 0, sum = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        while (left < n && right <= n){
            // 当当前开销小于budget时，右移right指针
            if (cost < budget){
                ++right;
                if (right > n) break;
                // 更新开销和窗口大小
                maxHeap.add(chargeTimes[right - 1]);
                sum += runningCosts[right - 1];
                cost = maxHeap.peek() + (right - left) * sum;
                if (cost <= budget) ans = Math.max(ans, right - left);
            }else{
                // 当当前开销大于等于budget时，右移left指针
                ++left;
                if (left >= n) break;
                // 重新计算开销
                sum -= runningCosts[left - 1];
                // 使用优先队列的remove方法，删除left指针之前位置的chargeTimes值
                maxHeap.remove(chargeTimes[left - 1]);
                cost = maxv + (right - left) * sum;
            }
        }
        return ans;
    }
    /**
     * 最多连续，可以用双指针
     * 最多 可以 连续 运行的机器人数目为多少。
     */
    public int maximumRobots1(int[] chargeTimes, int[] runningCosts, long budget) {
        int maxNum = 0;
        int n = chargeTimes.length;
        long cost = 0;
        long maxCharge = 0;
        int nowNum = 0;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + runningCosts[i - 1];
        }
        TreeMap<Integer, Integer> sort = new TreeMap<>();
        //        max(chargeTimes) + k * sum(runningCosts)
        for (int left = 0, right = 0; right < n; ) {
            if(!sort.isEmpty()){
                maxCharge = Math.max(sort.lastKey(),chargeTimes[right]);
            }else{
                maxCharge = chargeTimes[right];
            }
            cost = maxCharge + (long) (nowNum + 1) * (sum[right + 1] - sum[right - nowNum]);
            if (cost > budget) {
                nowNum = Math.max(0,nowNum -1);
                //可能存在没有放进来元素
                if(sort.containsKey(chargeTimes[left])){
                    if (sort.get(chargeTimes[left]) <= 1) {
                        sort.remove(chargeTimes[left]);
                    } else {
                        sort.put(chargeTimes[left], sort.getOrDefault(chargeTimes[right], 0) - 1);
                    }
                }

                left++;
                if(left >= n){
                    break;
                }
                right = Math.max(right,left);
                //continue;
            } else {
                sort.put(chargeTimes[right], sort.getOrDefault(chargeTimes[right], 0) + 1);
                nowNum++;
                maxNum = Math.max(nowNum, maxNum);
                right++;
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {
        MaximumRobots6143 maximumRows6173 = new MaximumRobots6143();
        //testCase(maximumRows6173, "[3,6,1,3,4]\n", "[2,1,3,4,5]", 25, 3);
        testCase(maximumRows6173, "[19,63,21,8,5,46,56,45,54,30,92,63,31,71,87,94,67,8,19,89,79,25]",
                "[91,92,39,89,62,81,33,99,28,99,86,19,5,6,19,94,65,86,17,10,8,42]", 85, 1);
    }

    private static void testCase(MaximumRobots6143 maximumRows6173, String original, String original1, int budget, int x) {
        System.out.println(maximumRows6173.maximumRobots(TransformUtil.toIntArray(original),
                TransformUtil.toIntArray(original1), budget));
        System.out.println(maximumRows6173.maximumRobots(TransformUtil.toIntArray(original),
                TransformUtil.toIntArray(original1), budget) == x);
    }
}

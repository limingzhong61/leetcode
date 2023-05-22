package qianxin.t1.t2.t3;


import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 输入各台手机的剩余电量，返回能坚持的最大时间
     *
     * @param batteries int整型一维数组 每台手机剩余电量，[0,100]之间
     * @return int整型
     */
    public int maxTime(int[] batteries) {
        int n = batteries.length;
        if (n < 5) {
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b -a);
        for (int x : batteries) {
            pq.add(x);
        }
        long res = 0;
        int[] arr = new int[5];
        while (pq.size() >= 5) {
            int min = 0;
            for (int i = 0; i < 5; i++) {
                if (pq.isEmpty()) break;
                arr[i] = pq.poll();
                min = arr[i];
            }
            res += min;
            for (int i = 0; i < 5; i++) {
                arr[i] -= min;
                if (arr[i] != 0) {
                    pq.add(arr[i]);
                }
            }
        }
        return (int) res;

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxTime(new int[]{100, 100, 100, 50, 100, 5, 10}));
    }
}


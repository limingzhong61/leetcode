package com.lmz.leetcode.practice.p.easy.old;

import java.util.LinkedList;
import java.util.Queue;

public class FindTheWinner1823 {
    /**
     * 递推
     */
    public int findTheWinner(int n, int k) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + k) % i;
        }
        return ans;
    }

    /**
     * 模拟+队列
     * 模拟游戏过程的做法是，将队首元素取出并将该元素在队尾处重新加入队列，重复该操作 k - 1次，
     * 则在 k - 1次操作之后，队首元素即为这一轮中数到的第 k 名小伙伴的编号，将队首元素取出，即为数到的第 k 名小伙伴离开圈子。
     */
    public int findTheWinner2(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        //初始化队列
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while (queue.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }
        return queue.poll();
    }


    public static void main(String[] args) {
        FindTheWinner1823 findTheWinner1823 = new FindTheWinner1823();
        testCase(findTheWinner1823, 5, 2, 3);
        testCase(findTheWinner1823, 6, 5, 1);
    }

    private static void testCase(FindTheWinner1823 findTheWinner1823, int n, int k, int x) {
        System.out.println(findTheWinner1823.findTheWinner(n, k));
        System.out.println(findTheWinner1823.findTheWinner(n, k) == x);
    }
}

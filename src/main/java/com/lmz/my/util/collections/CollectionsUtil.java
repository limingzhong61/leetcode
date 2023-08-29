package com.lmz.my.util.collections;

import java.util.ArrayList;
import java.util.Deque;

/**
 * @author: limingzhong
 * @create: 2023-08-15 11:05
 */
public class CollectionsUtil {
    /**
     * 将双端链表转为int[] 数组
     * @param dq 双端链表Deque<Integer>
     * @return int[] 数组
     */
    private static int[] dequeToIntArray(Deque<Integer> dq) {
        int size = dq.size(),idx = 0;
        int[] ans = new int[size];
        while(!dq.isEmpty()){
            ans[idx++] = dq.pollFirst();
        }
        return ans;
    }

    /**
     * arrayListToIntArray
     * @param list
     * @return
     */
    private static int[] arrayListToIntArray(ArrayList<Integer> list) {
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}

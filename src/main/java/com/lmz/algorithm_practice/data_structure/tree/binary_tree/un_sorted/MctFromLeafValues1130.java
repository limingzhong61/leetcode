package com.lmz.algorithm_practice.data_structure.tree.binary_tree.un_sorted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author: limingzhong
 * @create: 2023-05-31 9:45
 */
public class MctFromLeafValues1130 {
    /**
     * 数组 arr 中的值与树的中序遍历中每个叶节点的值一一对应。
     */
    public int mctFromLeafValues(int[] arr) {
        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        int ans = 0;
        while (list.size() > 1) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < list.size(); i += 2) {
                if (i + 1 < list.size()) {
                    temp.add(Math.max(list.get(i), list.get(i + 1)));
                    ans += list.get(i) * list.get(i+1);
                } else {
                    temp.add(list.get(i));
                }
            }
            list = temp;
            Collections.sort(list);
            System.out.println(list);
        }
        return ans;
    }
}

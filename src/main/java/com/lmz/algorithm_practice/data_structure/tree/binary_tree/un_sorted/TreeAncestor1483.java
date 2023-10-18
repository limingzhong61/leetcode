package com.lmz.algorithm_practice.data_structure.tree.binary_tree.un_sorted;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author: limingzhong
 * @create: 2023-06-12 16:39
 */
public class TreeAncestor1483 {
    class TreeAncestor {
        HashMap<Integer, HashMap<Integer, Integer>> nodeMap;
        HashMap<Integer, Integer> pathMap;
        HashMap<Integer, ArrayList<Integer>> pathLenMap;

        public TreeAncestor(int n, int[] parent) {
            int[] outCnt = new int[n];
            for (int i = 1; i < n; i++) {
                outCnt[parent[i]]++;
            }
            nodeMap = new HashMap<>();
            for (int i = 1; i < n; i++) {
                if (outCnt[i] == 0) {    // 从叶子节点出发
                    int cur = i;
                    pathMap = new HashMap<>();
                    ArrayList<Integer> list = new ArrayList<>();
                    int idx = 0;
                    while (parent[i] != -1) {
                        list.add(cur);
                        pathMap.put(cur, idx++);
                        nodeMap.put(cur, pathMap);
                        cur = parent[i];
                    }
                    //Collections.reverse(list);
                    for (int x : list) {
                        pathLenMap.put(x, list);
                    }
                }
            }
        }

        public int getKthAncestor(int node, int k) {
            HashMap<Integer, Integer> pathMap = nodeMap.get(node);
            ArrayList<Integer> list = pathLenMap.get(node);
            Integer idx = pathMap.get(node);
            int pathLen = list.size();
            if(k <= pathLen - idx - 1){
                return list.get(pathLen - idx - 1);
            }
            return -1;
        }
    }
}

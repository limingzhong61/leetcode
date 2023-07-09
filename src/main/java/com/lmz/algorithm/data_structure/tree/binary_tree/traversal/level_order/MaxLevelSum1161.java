package com.lmz.algorithm.data_structure.tree.binary_tree.traversal.level_order;

import com.lmz.leetcode.binary_tree.po.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum1161 {
    /**
     * 层次遍历
     */
    public int maxLevelSum(TreeNode root) {
        //树中的节点数在 [1, 104]范围内
        int resLevel = -1;
        int maxSum = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelCnt = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            int sum = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            if(sum > maxSum){
                maxSum = sum;
                resLevel =levelCnt;
            }
            levelCnt++;
        }
        return resLevel;
    }
}

package com.lmz.leetcode.practice.data_structure.tree.binary_tree.un_sorted;


import com.lmz.leetcode.data_structure.binary_tree.po.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class maxDepth104 {
    /**
     * 递归版本
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 迭代版本，利用层次遍历；（广度优先搜索）
     *
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++){
                root = queue.poll();
                if(root.left != null){
                    queue.offer(root.left);
                }
                if(root.right != null){
                    queue.offer(root.right);
                }
            }
            depth++;
        }
        return depth;
    }










}

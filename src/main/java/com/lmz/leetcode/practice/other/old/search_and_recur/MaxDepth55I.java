package com.lmz.leetcode.practice.other.old.search_and_recur;

import com.lmz.leetcode.data_structure.binary_tree.po.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth55I {
    /**
     * 思路：bfs
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int deep = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            deep++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return deep;
    }

    /**
     * 思路：递归
     */
    public int maxDepth1(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }


}

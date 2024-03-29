package com.lmz.leetcode.practice.p.old.everyday;


import com.lmz.leetcode.data_structure.binary_tree.po.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftValue513 {
    /**
     * 层次遍历即可
     */
    public int findBottomLeftValue(TreeNode root) {
    //    假设二叉树中至少有一个节点。
        Queue<TreeNode> queue = new LinkedList<>();
        int res = root.val;
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            res = cur.val;
            if(cur.right != null){
                queue.add(cur.right);
            }
            if(cur.left != null){
                queue.add(cur.left);
            }
        }
        return res;
    }

}

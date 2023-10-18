package com.lmz.algorithm_practice.other.old.everyday;

import com.lmz.leetcode.binary_tree.po.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValues515 {
    /**
     * 层次遍历-按层统计
     * ：每次遍历queue.size()[每一层的个数]；
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();

            int maxVal = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                maxVal = Math.max(maxVal,cur.val);
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
            }
            res.add(maxVal);
        }
        return res;
    }
}

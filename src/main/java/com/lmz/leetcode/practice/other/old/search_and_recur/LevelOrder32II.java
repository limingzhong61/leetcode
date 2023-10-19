package com.lmz.leetcode.practice.other.old.search_and_recur;

import com.lmz.leetcode.data_structure.binary_tree.po.TreeNode;

import java.util.*;

public class LevelOrder32II {
    /**
     * 法一：
     * 层次遍历
     * 利用一个指针记录一层遍历的最后一个结点
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        TreeNode lastNode = root;
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            list.add(cur.val);
            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
            //已经遍历完一层的最后一个节点
            if(lastNode == cur){
                res.add(list);
                lastNode = queue.peekLast();
                list = new ArrayList<>();
            }
        }
        return res;
    }

    /**
     * 法二：
     * 层次遍历
     * 每次开始遍历取k = queue.size()，遍历的k个元素都是同一层
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
            }
            res.add(list);
            list = new ArrayList<>();
        }
        return res;
    }
}

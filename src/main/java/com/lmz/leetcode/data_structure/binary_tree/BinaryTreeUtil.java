package com.lmz.leetcode.data_structure.binary_tree;

import com.lmz.leetcode.data_structure.binary_tree.po.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: limingzhong
 * @create: 2023-06-07 11:45
 */
public class BinaryTreeUtil {




    /**
     * 递归版本
     *
     * @param root
     * @return 二叉树的最大深度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    /**
     * 层次遍历
     * 利用队列长度
     * @param root
     * @return 层次遍历后的list结果
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return res;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();
            for(int i = 0; i < currentLevelSize; i++){
                root = queue.poll();
                level.add(root.val);
                if(root.left != null){
                    queue.offer(root.left);
                }
                if(root.right != null){
                    queue.offer(root.right);
                }
            }
            res.add(level);
        }
        return res;
    }


    /**
     * 递归解法
     * @param root
     * @return 递归遍历的结果list
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if(root == null) {
            return;
        }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }

    /**
     * 返回前序遍历的结果list
     *
     * @param root
     * @return
     */
    public static List<TreeNode> preOrderList(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    private static void preOrder(TreeNode root, ArrayList<TreeNode> list) {
        if (root == null) return;
        list.add(root);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }


}

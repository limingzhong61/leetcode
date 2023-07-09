package com.lmz.algorithm.data_structure.tree.binary_tree.complete_bt;

import com.lmz.leetcode.binary_tree.po.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: limingzhong
 * @create: 2023-03-15 14:38
 */
public class CBTInserterII043 {

    class CBTInserter {
        /**
         * 维护一个插入结点队列，就不用遍历二叉树了
         */
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root;
        public CBTInserter(TreeNode root) {
            this.root = root;
            Queue<TreeNode> q = new ArrayDeque<>();
            q.add(root);
            while(!q.isEmpty()){
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = q.poll();
                    if (poll.left != null) {
                        q.add(poll.left);
                    }
                    if (poll.right != null) {
                        q.add(poll.right);
                    }
                    if (poll.left == null || poll.right == null) {
                        queue.add(poll);
                    }
                }
            }
        }

        public int insert(int v) {
            TreeNode node = queue.peek();
            if(node.left == null){
                node.left = new TreeNode(v,null,null);
                queue.add(node.left);
            }else{
                node.right = new TreeNode(v,null,null);
                queue.add(node.right);
                queue.poll();
            }
            return node.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }
}

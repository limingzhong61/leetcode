package com.lmz.leetcode.practice.p.p_0_1000;

import com.lmz.leetcode.data_structure.binary_tree.po.TreeNode;

import java.util.*;

/**
 * @author: limingzhong
 * @create: 2023-09-04 9:09
 */
public class Codec449 {
    /**
     * 反序列化时，需要先将字符串解码成后序遍历的数组。在将后序遍历的数组恢复成二叉搜索树时，不需要先排序得到中序遍历的数组再根据中序和后序遍历的数组来恢复二叉树，
     * 而可以根据有序性直接由后序遍历的数组恢复二叉搜索树。后序遍历得到的数组中，根结点的值位于数组末尾，左子树的节点均小于根节点的值，右子树的节点均大于根节点的值，
     * 可以根据这些性质设计递归函数恢复二叉搜索树。
     */
    public class Codec {

        public String serialize(TreeNode root) {
            List<Integer> list = new ArrayList<Integer>();
            postOrder(root, list);
            String str = list.toString();
            return str.substring(1, str.length() - 1);
        }

        public TreeNode deserialize(String data) {
            if (data.isEmpty()) {
                return null;
            }
            String[] arr = data.split(", ");
            Deque<Integer> stack = new ArrayDeque<Integer>();
            int length = arr.length;
            for (int i = 0; i < length; i++) {
                stack.push(Integer.parseInt(arr[i]));
            }
            return construct(Integer.MIN_VALUE, Integer.MAX_VALUE, stack);
        }

        private void postOrder(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            postOrder(root.left, list);
            postOrder(root.right, list);
            list.add(root.val);
        }

        private TreeNode construct(int lower, int upper, Deque<Integer> stack) {
            if (stack.isEmpty() || stack.peek() < lower || stack.peek() > upper) {
                return null;
            }
            int val = stack.pop();
            TreeNode root = new TreeNode(val);
            root.right = construct(val, upper, stack);
            root.left = construct(lower, val, stack);
            return root;
        }
    }
}

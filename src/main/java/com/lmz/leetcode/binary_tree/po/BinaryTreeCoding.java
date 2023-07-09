package com.lmz.leetcode.binary_tree.po;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: limingzhong
 * @create: 2023-07-07 11:43
 * leetcode 二叉树的序列化与反序列化
 * 来源：297. 二叉树的序列化与反序列化
 */
public class BinaryTreeCoding {
    final static String nullStr = "null";

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root == null){
            return "[]";
        }
        StringBuilder ans = new StringBuilder();
        ans.append('[');
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        ans.append(root.val);

        while (!q.isEmpty()) {
            int size = q.size();
            // mark next layer has value?
            boolean hasValue = false;
            StringBuilder nextLayerSB = new StringBuilder();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                nextLayerSB.append(',');
                if (node.left != null) {
                    hasValue = true;
                    q.add(node.left);
                    nextLayerSB.append(node.left.val);
                } else {
                    nextLayerSB.append(nullStr);
                }

                nextLayerSB.append(',');
                if (node.right != null) {
                    hasValue = true;
                    q.add(node.right);
                    nextLayerSB.append(node.right.val);
                } else {
                    nextLayerSB.append(nullStr);
                }
            }
            if (hasValue)
                ans.append(nextLayerSB);
        }
        ans.append(']');
        return ans.toString();
    }

    /**
     * 输入格式： [1,2,3,null,null,4,5]
     *
     * @param data
     * @return
     */
    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        // 去掉 []
        data = data.substring(1, data.length() - 1);
        if(data.isBlank()){
            return null;
        }
        //拆分
        String[] nodeValues = data.split(",");


        int idx = 0, length = nodeValues.length;
        Queue<TreeNode> q = new ArrayDeque<>(length);
        TreeNode root = getNode(nodeValues[idx++]);
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (idx >= length) break;
            node.left = getNode(nodeValues[idx++]);
            if (node.left != null) { //队列不能添加null
                q.add(node.left);
            }
            if (idx >= length) break;
            node.right = getNode(nodeValues[idx++]);
            if (node.right != null) { //队列不能添加null
                q.add(node.right);
            }
        }
        return root;
    }

    private static TreeNode getNode(String nodeValue) {
        if (nullStr.equals(nodeValue)) return null;
        return new TreeNode(Integer.parseInt(nodeValue));
    }

    public static void main(String[] args) {
        testCase("[1,2,3,null,null,4,5]");
        testCase("[]");
    }

    private static void testCase(String data) {
        TreeNode treeNode = BinaryTreeCoding.deserialize(data);
        System.out.println(BinaryTreeCoding.serialize(treeNode));
    }
}

package codeofli.my.leetcode;

import codeofli.leetcode.data_structure.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 将leetcode字符串转换为二叉树
 */
public  class EncodeTree {
    /**
     * 提示: 输入输出格式与 LeetCode 目前使用的方式一致.。
     * 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
     * 思路：层次遍历
     *
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int nullValue = 2022; //补充结点的值
        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println(sb);
            System.out.println(queue.size());
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (root.val == nullValue) { //补充结点，之前为null
                    continue;
                }
                if (root.left != null) {
                    queue.add(root.left);
                } else {
                    queue.add(new TreeNode(nullValue));//补充结点
                }
                if (root.right != null) {
                    queue.add(root.right);
                } else {
                    queue.add(new TreeNode(nullValue));//补充结点
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        System.out.println(sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);
        String[] split = data.split(",");
        if (split.length <= 0) {
            return null;
        }
        TreeNode[] nodes = new TreeNode[split.length];
        if ("null".equals(split[0])) {
            return null;
        }
        nodes[0] = new TreeNode(Integer.parseInt(split[0]));
        //nodes[0].val = Integer.parseInt(split[0]);
        int depth = 1;
        int start = 0;
        int nextStart = 0;

        for (int i = 1; i < split.length; ) {
            int levelSize = 1 << (depth - 1);
            start = nextStart;
            nextStart = start + levelSize;
            //System.out.println("start：" + start + ",nextStart:" + nextStart);
            for (int j = start; j < nextStart; j++) {
                if ("null".equals(split[j])) {
                    continue;
                }
                //TreeNode tmp = null;
                if (!"null".equals(split[i])) {
                    nodes[i] = new TreeNode(Integer.parseInt(split[i]));
                }
                nodes[j].left = nodes[i++];
                //TreeNode tmp = null;
                if (!"null".equals(split[i])) {
                    nodes[i] = new TreeNode(Integer.parseInt(split[i]));
                }
                nodes[j].right = nodes[i++];
            }
        }
        return nodes[0];
    }
}

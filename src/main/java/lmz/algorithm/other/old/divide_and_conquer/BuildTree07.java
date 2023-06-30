package lmz.algorithm.other.old.divide_and_conquer;

import lmz.algorithm.data_structure.tree.binary_tree.util.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class BuildTree07 {
    /**
     * my:分治算法，迭代算法
     * preorder: 中左右，inorder:左中右
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 0; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            //u(inorder[index])一定是v(preorder[i])的左子节点，反证法。
            //如果不是，则v没有左子节点，则中序遍历时u应该就是v本身
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else { //相等，中序遍历时u就是v本身
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

    /**
     * my:分治算法
     * preorder: 中左右，inorder:左中右
     */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        //preorder 和 inorder 均 无重复 元素，故可用hashMap找到根结点
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur(0, inorder.length - 1, preorder, inorder, map);
    }

    int preIndex = 0;

    private TreeNode recur(int inLeft, int inRight, int[] preorder, int[] inorder, Map<Integer, Integer> map) {
        if (inLeft > inRight) {
            return null;
        }

        //先左后右
        Integer rootIndex = map.get(preorder[preIndex++]);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        root.left = recur(inLeft, rootIndex - 1, preorder, inorder, map);
        root.right = recur(rootIndex + 1, inRight, preorder, inorder, map);
        return root;
    }
}

package lmz.leetcode.data_structure.tree.binary_tree.bst;


import lmz.leetcode.data_structure.tree.binary_tree.normal.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class IsValidBST98 {
    /**
     * my: 递归版
     * 注意：结点应该在整棵树上符合bst规律
     * 思路： 利用中序遍历,二叉排序树有序
     * @param root
     * @return
     */
    TreeNode preNode = null;

    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if (preNode != null) {
            boolean judge = preNode.val < root.val;
            System.out.println("judge:" + judge + ",root:" + root.val);
            if (judge == false) return false;
        }
        boolean right = isValidBST(root.right);
        System.out.println("left:" + left + ",right:" + right);
        return left && right;
    }

    /**
     * my: 非递归版中序遍历
     * 注意：结点应该在整棵树上符合bst规律
     * 思路： 利用中序遍历,二叉排序树有序
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        long preValue = Long.MIN_VALUE;
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (preValue >= root.val) {  // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
                return false;
            }
            preValue = root.val;
            root = root.right;
        }
        return true;
    }

    /**
     * 递归传递下界
     * [low,high] 表示该节点应该符合的范围
     * 其左节点范围 [low,root.val],右节点范围 [root.val,high]
     * 注意： 边界，可以为Integer.MAX_VALUE;用long解决
     */
    public boolean isValidBST1(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean check(TreeNode root, long low, long high) {
        if (root == null) {
            return true;
        }
        if (root.val >= high || root.val <= low) {
            return false;
        }
        return check(root.left, low, root.val) && check(root.right, root.val, high);
    }
}

package lmz.leetcode.data_structure.tree.binary_tree.bst;

import lmz.leetcode.data_structure.tree.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BSTIterator173 {
    /**
     * 中序遍历+数组记录
     */
    class BSTIterator {
        private List<Integer> orderList;
        int cur;
        public BSTIterator(TreeNode root) {
            orderList = new ArrayList<Integer>();
            inorderTraversal(root, orderList);
        }
        private void inorderTraversal(TreeNode root,List<Integer> orderList) {
            if(root == null){
                return;
            }
            inorderTraversal(root.left,orderList);
            orderList.add(root.val);
            inorderTraversal(root.right,orderList);
        }

        //假设 next() 调用总是有效的
        public int next() {
            return orderList.get(cur++);
        }

        public boolean hasNext() {
            return  cur < orderList.size();
        }
    }
    /**
     * 中序遍历+hashMap
     * 中序遍历有序，用hashMap记录后继节点的关系。
     */
    class BSTIterator2 {
        HashMap<TreeNode,TreeNode> nextMap = new HashMap<>();
        TreeNode cur;
        public BSTIterator2(TreeNode root) {
            inOrder(root);
        }
        private  TreeNode pre = null;
        private void inOrder(TreeNode root) {
            if(root == null){
                return;
            }
            inOrder(root.left);
            if(pre != null){
                nextMap.put(pre,root);
            }else{
                cur = new TreeNode(-1); //指针初始化为一个不存在于 BST 中的数字
                nextMap.put(cur,root);
            }
            pre = root;
            inOrder(root.right);
        }

        //假设 next() 调用总是有效的
        public int next() {
            cur =  nextMap.get(cur);
            return cur.val;
        }

        public boolean hasNext() {
            return  nextMap.containsKey(cur);
        }
    }
}

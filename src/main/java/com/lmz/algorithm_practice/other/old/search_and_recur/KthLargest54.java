package com.lmz.algorithm_practice.other.old.search_and_recur;


import com.lmz.leetcode.binary_tree.po.TreeNode;

public class KthLargest54 {
    /**
     * 中序遍历，左中右，从小到大
     右中左，从大到小
     */
    int kth;
    int ans = 0;
    public int kthLargest(TreeNode root, int k) {
        kth = k;
        order(root);
        return ans;
    }

    private void order(TreeNode root) {
        if(root == null){
            return ;
        }
        order(root.right);
        if(kth == 1){
            //因为遍历完右边，有可能回退到父节点（此时kth任然没被改变）
            kth--;
            ans = root.val;
            return;
        }
        kth--;
        order(root.left);
    }

    public static void main(String[] args) {
        KthLargest54 kthLargest54 = new KthLargest54();
        //System.out.println(kthLargest54.kthLargest(EncodeTree.deserialize("[3,1,4,null,2]"), 1));
    }
}

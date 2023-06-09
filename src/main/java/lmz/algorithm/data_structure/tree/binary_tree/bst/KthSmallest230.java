package lmz.algorithm.data_structure.tree.binary_tree.bst;

import lmz.algorithm.data_structure.tree.binary_tree.un_sorted.TreeNode;
import lmz.my.leetcode.EncodeTree2;

public class KthSmallest230 {

    /**
     * 中序遍历有序，第k个为第k小
     * 1 <= k <= n <= 10^4
     */
    int k = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return -1;
        }
        this.k  = k;
        return inOrder(root);
    }

    private int inOrder(TreeNode root) {
        int res = kthSmallest(root.left,k);
        if(res != -1){
            return res;
        }
        --k;
        if(k == 0){
            return root.val;
        }
        res = kthSmallest(root.right,k);
        return res;
    }

    public static void main(String[] args) {
        KthSmallest230 kthSmallest230 = new KthSmallest230();
        System.out.println(kthSmallest230.kthSmallest(EncodeTree2.deserialize("[5,3,6,2,4,null,null,1]"), 3));
    }
}

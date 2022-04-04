package mars.leetcode.binary_tree.build_tree;

import mars.leetcode.binary_tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class KnowPreorderAndPostorder {
    Map<Integer, Integer> idxMap = new HashMap();

    /**
     * 递归版本
     * 1.后序：左右中，则每次最后一个结点midRoot为当前子树根结点
     * 2.用找到的midRoot，划分中序遍历（左中右），则将结点分为左右子树，
     * 3.后序遍历用相同数目同样可以划分为子树，如此递归即可。
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 建立（元素，下标）键值对的哈希表
        int idx = 0;
        for (Integer val : inorder) {
            idxMap.put(val, idx++);
        }
        return buildTree(inorder,preorder,
                0,inorder.length-1,0,preorder.length-1);

    }

    public TreeNode buildTree(int[] inorder, int[] preorder,
                              int inLeft,int inRight,int preLeft,int preRight){

        if(inLeft > inRight) return null;
        //1.后序：左右中，则每次最后一个结点midRoot为当前子树根结点
        int midVal = preorder[preLeft];
        TreeNode midRoot = new TreeNode(midVal);
        int midIndex = idxMap.get(midVal);
        int leftCount = midIndex-inLeft;
        midRoot.left = buildTree(inorder,preorder,
                inLeft,midIndex-1,preLeft+1,preLeft+leftCount);

        midRoot.right = buildTree(inorder,preorder,
                midIndex+1,inRight,leftCount +preLeft+1,preRight);
        return midRoot;
    }



}

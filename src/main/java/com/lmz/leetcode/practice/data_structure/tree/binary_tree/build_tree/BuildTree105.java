package com.lmz.leetcode.practice.data_structure.tree.binary_tree.build_tree;

import com.lmz.leetcode.data_structure.binary_tree.po.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: limingzhong
 * @create: 2023-06-11 17:38
 */
public class BuildTree105 {
    /**
     * preorder 和 inorder 均 无重复 元素
     */
    Map<Integer, Integer> idxMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        idxMap = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            idxMap.put(inorder[i], i);
        }
        return build(preorder,inorder,0,n-1,0,n-1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if(pr - pl < 0) return null;
        TreeNode root = new TreeNode(preorder[pl]);
        Integer midIdx = idxMap.get(preorder[pl]);
        int leftLen = midIdx - il;
        int rightLen = ir - midIdx;
        root.left = build(preorder,inorder,pl+1,pl+leftLen,il,midIdx-1);
        root.right = build(preorder,inorder,pl+leftLen+1,pr,midIdx+1,ir);
        return root;
    }
}

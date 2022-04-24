package mars.leetcode.binary_tree.build_tree;

import mars.leetcode.binary_tree.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KnowInorderAndPostorder106 {
    Map<Integer, Integer> idxMap = new HashMap();

    /**
     * leetcode 递归版本
     * 1.后序：左右中，则每次最后一个结点midRoot为当前子树根结点
     * 2.用找到的midRoot，划分中序遍历（左中右），则将结点分为左右子树，
     * 3.后序遍历用相同数目同样可以划分为子树，如此递归即可。
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        // 从后序遍历的最后一个元素开始
        postIndex = postorder.length - 1;
        // 建立（元素，下标）键值对的哈希表

        int idx = 0;
        for (Integer val : inorder) {
            idxMap.put(val, idx++);
        }
        return buildTree(inorder, 0, inorder.length - 1);

    }

    int[] postorder;
    int postIndex;

    public TreeNode buildTree(int[] inorder, int inLeft, int inRight) {

        if (inLeft > inRight) return null;
        //1.后序：左右中，则每次最后一个结点midRoot为当前子树根结点
        int midVal = postorder[postIndex];
        TreeNode midRoot = new TreeNode(midVal);
        int midIndex = idxMap.get(midVal);
        // 下标减一
        postIndex--;
        // 构造右子树
        midRoot.right = buildTree(inorder,
                midIndex + 1, inRight);
        // 构造左子树
        midRoot.left = buildTree(inorder,
                inLeft, midIndex - 1);

        return midRoot;
    }

    /**
     * my 递归版本
     * 1.后序：左右中，则每次最后一个结点midRoot为当前子树根结点
     * 2.用找到的midRoot，划分中序遍历（左中右），则将结点分为左右子树，
     * 3.后序遍历用相同数目同样可以划分为子树，如此递归即可。
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        // 建立（元素，下标）键值对的哈希表
        int idx = 0;
        for (Integer val : inorder) {
            idxMap.put(val, idx++);
        }
        return buildTree(inorder, postorder,
                0, inorder.length - 1, 0, postorder.length - 1);

    }

    public TreeNode buildTree(int[] inorder, int[] postorder,
                               int inLeft, int inRight, int postLeft, int postRight) {

        if (inLeft > inRight) return null;
        //1.后序：左右中，则每次最后一个结点midRoot为当前子树根结点
        int midVal = postorder[postRight];
        TreeNode midRoot = new TreeNode(midVal);
        int midIndex = idxMap.get(midVal);
        int leftCount = midIndex - inLeft;
        midRoot.left = buildTree(inorder, postorder,
                inLeft, midIndex - 1, postLeft, postLeft + leftCount - 1);

        midRoot.right = buildTree(inorder, postorder,
                midIndex + 1, inRight, leftCount + postLeft, postRight - 1);
        return midRoot;
    }


}

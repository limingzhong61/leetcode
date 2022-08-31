package codeofli.leetcode.data_structure.tree.binary_tree.build_tree;


import codeofli.leetcode.data_structure.tree.binary_tree.TreeNode;

import java.util.*;

public class KnowPreorderAndPostorder105 {
    /**
     * 迭代版本
     * 前序：中左右，
     * 中序：左中右
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //用一个栈 stack 来维护「当前节点的所有还没有考虑过右儿子的祖先节点」
        Deque<TreeNode> stack = new LinkedList<>();
        //用一个指针 index 指向中序遍历的某个位置，初始值为 0
        int inorderIndex = 0;
        //前序遍历第一个结点为根结点
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);

        for(int i = 1; i < preorder.length; i++){

            TreeNode node = stack.peek();
            //最左节点不为栈顶节点，则下一个结点比为栈顶节点的左子
            if(inorder[inorderIndex] != node.val){
                node.left = new TreeNode(preorder[i]);
                stack.push(node.left);
            }else{//最左节点为栈顶节点，则下一个结点比为栈中某一个结点的右子结点
                for(; !stack.isEmpty() && stack.peek().val == inorder[inorderIndex]; inorderIndex++){
                    node =  stack.pop();
                }
                node.right = new TreeNode(preorder[i]);
                stack.push(node.right);
            }

        }
        return  root;
    }






    Map<Integer, Integer> idxMap = new HashMap();

    /**
     * 递归版本
     * 1.后序：左右中，则每次最后一个结点midRoot为当前子树根结点
     * 2.用找到的midRoot，划分中序遍历（左中右），则将结点分为左右子树，
     * 3.后序遍历用相同数目同样可以划分为子树，如此递归即可。
     * @param inorder
     * @return
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
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

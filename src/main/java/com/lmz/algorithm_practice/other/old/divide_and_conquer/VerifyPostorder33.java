package com.lmz.algorithm_practice.other.old.divide_and_conquer;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Locale;

public class VerifyPostorder33 {
    /**
     * 辅助单调栈
     */
    public boolean verifyPostorder(int[] postorder) {
        Deque<Integer> stack = new LinkedList<>();
        int root = Integer.MAX_VALUE;
        for(int i = postorder.length-1; i >= 0; i--){
            if(postorder[i] > root){
                return false;
            }
            while (!stack.isEmpty() && stack.peek() > postorder[i]){
                //维持root为大于 postorder[i]的最小值
                root = stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;
    }

    // 要点：二叉搜索树中根节点的值大于左子树中的任何一个节点的值，小于右子树中任何一个节点的值，子树也是
    public boolean verifyPostorder2(int[] postorder) {
        if (postorder.length < 2) return true;
        return verify(postorder, 0, postorder.length - 1);
    }

    // 递归实现
    private boolean verify(int[] postorder, int left, int right){
        if (left >= right) return true; // 当前区域不合法的时候直接返回true就好

        int rootValue = postorder[right]; // 当前树的根节点的值

        int k = left;
        while (k < right && postorder[k] < rootValue){ // 从当前区域找到第一个大于根节点的，说明后续区域数值都在右子树中
            k++;
        }

        for (int i = k; i < right; i++){ // 进行判断后续的区域是否所有的值都是大于当前的根节点，如果出现小于的值就直接返回false
            if (postorder[i] < rootValue) return false;
        }

        // 当前树没问题就检查左右子树
        if (!verify(postorder, left, k - 1)) return false; // 检查左子树

        if (!verify(postorder, k, right - 1)) return false; // 检查右子树

        return true; // 最终都没问题就返回true
    }
    /**
     * my:递归遍历
     * 后序遍历：左右中，
     * 二叉搜索树的 根结点>所有左节点,根结点<所有右节点，能划分为左右子树
     */
    public boolean verifyPostorder1(int[] postorder) {
        if(postorder == null || postorder.length == 0){
            return true;
        }
        return check(0, postorder.length - 1, postorder);
    }

    private boolean check(int left, int right, int[] postorder) {
        //只有一个结点就是二叉搜索树
        if(left == right){
            return true;
        }
        int rootVal = postorder[right];
        int leftEnd = left;
        //找到左子树的范围[left,leftEnd-1]
        while (postorder[leftEnd] < rootVal) {
            leftEnd++;
        }
        //只有左子树
        if(leftEnd == right){
            return check(left, leftEnd - 1, postorder);
        }
        //找到右子树的范围[leftEnd,rightEnd-1]
        int rightEnd = leftEnd;
        while (postorder[rightEnd] > rootVal) {
            rightEnd++;
        }
        if (rightEnd != right) {
            return false;
        }
        //只有右子树
        if(leftEnd == left){
            return  check(leftEnd, rightEnd-1, postorder);
        }
        //左右两棵子树都有
        return check(left, leftEnd - 1, postorder) &&
                check(leftEnd, rightEnd-1, postorder);
    }

    public static void main(String[] args) {
        VerifyPostorder33 verifyPostorder33 = new VerifyPostorder33();
        System.out.println(verifyPostorder33.verifyPostorder(TransformUtil.toIntArray("[1,6,3,2,5]")));
        System.out.println(String.valueOf(
                        verifyPostorder33.verifyPostorder(TransformUtil.toIntArray("[1,6,3,2,5]")) == false
                ).toUpperCase(Locale.ROOT));
        System.out.println(verifyPostorder33.verifyPostorder(TransformUtil.toIntArray("[1,3,2,6,5]")));
        System.out.println(String.valueOf(
                        verifyPostorder33.verifyPostorder(TransformUtil.toIntArray("[1,3,2,6,5]")) == true
                ).toUpperCase(Locale.ROOT));
        System.out.println(verifyPostorder33.verifyPostorder(TransformUtil.toIntArray("[1,2,5,10,6,9,4,3]")));
        System.out.println(String.valueOf(
                        verifyPostorder33.verifyPostorder(TransformUtil.toIntArray("[1,2,5,10,6,9,4,3]")) == false
                ).toUpperCase(Locale.ROOT));
        System.out.println(verifyPostorder33.verifyPostorder(TransformUtil.toIntArray("[4, 6, 7, 5]")));
        System.out.println(String.valueOf(
                        verifyPostorder33.verifyPostorder(TransformUtil.toIntArray("[4, 6, 7, 5]")) == true
                ).toUpperCase(Locale.ROOT));
        System.out.println(verifyPostorder33.verifyPostorder(TransformUtil.toIntArray("[5, 4, 3, 2, 1]")));
        System.out.println(String.valueOf(
                        verifyPostorder33.verifyPostorder(TransformUtil.toIntArray("[5, 4, 3, 2, 1]")) == true
                ).toUpperCase(Locale.ROOT));
        System.out.println(verifyPostorder33.verifyPostorder(TransformUtil.toIntArray("[]")));
        System.out.println(String.valueOf(
                        verifyPostorder33.verifyPostorder(TransformUtil.toIntArray("[]")) == true
                ).toUpperCase(Locale.ROOT));
    }
}

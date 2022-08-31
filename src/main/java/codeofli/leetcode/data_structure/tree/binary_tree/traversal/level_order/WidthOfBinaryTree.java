package codeofli.leetcode.data_structure.tree.binary_tree.traversal.level_order;

import codeofli.leetcode.data_structure.tree.binary_tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class WidthOfBinaryTree {
    /**
     * bfs：每次向下遍历时，记录结点与中心的偏离值，最左和最右的偏离值就是最大宽度
     */
    public int widthOfBinaryTree(TreeNode root) {
        //树中节点的数目范围是 [1, 3000]
        Queue<Combine> queue = new LinkedList<>();
        //queue.add(new Combine(root, 0, false));
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        if(root.left != null){
            queue.add(new Combine(root.left,-1));
            left = -1;
        }
        if(root.right != null){
            queue.add(new Combine(root.right,1));
            right = 1;
        }

        int width = 1;
        if(left == -1 && right == 1){
            width = 2;
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            left = Integer.MAX_VALUE;
            right = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                Combine combine = queue.poll();
                TreeNode node = combine.node;
                int dist = combine.dist;
                if(dist > 0){ // right
                    if (node.left != null) {
                        int leftDist = dist * 2 - 1;
                        left = Math.min(left,leftDist);
                        right = Math.max(right,leftDist);
                        queue.add(new Combine(node.left, leftDist));
                    }
                    if (node.right != null) {
                        int rightDist = dist * 2 ;
                        left = Math.min(left,rightDist);
                        right = Math.max(right,rightDist);
                        queue.add(new Combine(node.right, rightDist));
                    }
                }else{ //left
                    dist  = -dist;
                    if (node.left != null) {
                        int leftDist = dist * 2;
                        leftDist = - leftDist;
                        left = Math.min(left,leftDist);
                        right = Math.max(right,leftDist);
                        queue.add(new Combine(node.left, leftDist));
                    }
                    if (node.right != null) {
                        int rightDist = dist * 2 - 1;
                        rightDist = - rightDist;
                        left = Math.min(left,rightDist);
                        right = Math.max(right,rightDist);
                        queue.add(new Combine(node.right, rightDist));
                    }
                }
            }
            // System.out.println("left:" + left +";right:" + right);
            if(left != Integer.MAX_VALUE && right != Integer.MIN_VALUE){
                int dist = right - left;
                // 同侧计算，因为两遍都是关于根结点root的偏移，故需要+1
                if(left < 0 && right < 0){
                    dist++;
                }else if(left > 0 && right > 0){
                    dist++;
                }
                width = Math.max(width,dist);
            }
        }
        return width;
    }

    class Combine {
        TreeNode node;
        int dist = 1;

        Combine(TreeNode node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    /**
     * 如果一颗树每层只有2个结点，则最多有2^1500-1，会超时的。
     * bfs:层次遍历
     * <p>
     * 将null结点也添加进去，用一个值表示null的结点，用125.添加完后，移除最左和最右的null结点
     * -100 <= Node.val <= 100
     */
    public int widthOfBinaryTree1(TreeNode root) {
        //树中节点的数目范围是 [1, 3000]
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int width = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                if (node == null) {
                    queue.addLast(null);
                    queue.addLast(null);
                    continue;
                }
                if (node.left != null) {
                    queue.addLast(node.left);
                } else {
                    queue.addLast(null);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                } else {
                    queue.addLast(null);
                }
            }
            while (!queue.isEmpty() && queue.peekFirst() == null) { //移除最左边的null结点
                queue.pollFirst();
            }
            while (!queue.isEmpty() && queue.peekLast() == null) { //移除最右边的null结点
                queue.pollLast();
            }
            width = Math.max(width, queue.size());
        }
        return width;
    }
}

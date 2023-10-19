package com.lmz.leetcode.practice.data_structure.tree.binary_tree.summary;

import java.util.LinkedList;
import java.util.Queue;

public class Connect116 {

    /**
     * 指针版本，利用建立的next来遍历二叉树
     *注意：完全二叉树条件，
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if(root == null) return null;
        Node leftMost = root;
        //boolean beginLeft = true;
        Node nextLeftMost = null;
        while(leftMost.left != null){
            if(nextLeftMost == null){
                nextLeftMost = leftMost.left;
            }
            //连接左子节点->右子结点
            leftMost.left.next = leftMost.right;
            //当前结点右子->下一个结点（右侧结点）左子结点
            if(leftMost.next != null){
                leftMost.right.next = leftMost.next.left;
                leftMost = leftMost.next;
            }else{
                leftMost = nextLeftMost;
                nextLeftMost = null; //重置标记
            }
        }
        return root;
    }

    //public NOde connect(Node root){}


    /**
     * 迭代版本，bfs，层次遍历
     */
    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }
        Node tmp = root;
        Queue<Node> queue = new LinkedList();
        queue.offer(root);

        while(!queue.isEmpty()){
            Node lastNode = null;
            int queueSize = queue.size();
            while (queueSize-- != 0){
                root = queue.poll();
                if(lastNode != null){ //第一个结点，没有上一个结点
                    lastNode.next = root;
                }
                lastNode = root;
                if(root.left != null){
                    queue.offer(root.left);
                }
                if(root.right != null){
                    queue.offer(root.right);
                }
            }
            root.next = null;
        }
        return tmp;
    }


}

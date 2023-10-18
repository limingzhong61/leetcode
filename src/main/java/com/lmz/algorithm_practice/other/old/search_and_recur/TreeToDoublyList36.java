package com.lmz.algorithm_practice.other.old.search_and_recur;


public class TreeToDoublyList36 {
    /**
     思路：中序遍历，利用一个prev指向之前的结点
     */
    Node prev = new Node();
    public Node treeToDoublyList(Node root) {
        if(root == null){
            return null;
        }
        Node temp = prev;
        innerOrder(root);
        //最后首尾相连
        prev.right = temp.right;
        temp.right.left = prev;
        return temp.right;
    }

    private void innerOrder(Node root) {
        if (root == null) {
            return;
        }
        innerOrder(root.left);
        root.left = prev;
        prev.right = root;
        prev = root;
        innerOrder(root.right);
    }

    public static void main(String[] args) {
        TreeToDoublyList36 treeToDoublyList36 = new TreeToDoublyList36();
        //Node deserialize = EncodeTreeByNode.deserialize("[4,2,5,1,3]");
        //Node node = treeToDoublyList36.treeToDoublyList(deserialize);
    }
}

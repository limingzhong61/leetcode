package lmz.algorithm.data_structure.linked_list;


import java.util.HashMap;

public class CopyRandomList138 {
    /**
     * 先next遍历，构造整个链表
     * 然后再遍历一遍，实现random指向
     * random拷贝
     * 先转化为map{originalNode:newNode}
     */
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();


        Node dummy = new Node(0);
        Node p = dummy;
        Node cur = head;

        while (cur != null) {
            p.next = new Node(cur.val);
            p = p.next;
            map.put(cur, p);
            cur = cur.next;
        }

        p = dummy.next;
        cur = head;
        while (p != null) {
            p.random = map.get(cur.random);
            p = p.next;
            cur = cur.next;
        }

        return dummy.next;
    }

    /**
     * leetcode: 方法二：迭代 + 节点拆分
     * 关键：将复制结点安排在被复制结点的后面，这样就能找到random指向
     * 减少了HashMap的空间，
     */
    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        //插入结点
        while (cur != null) {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }
        /*
        然后再遍历一遍，实现random拷贝
        * */
        cur = head;
        while (cur != null) {
            Node newNode = cur.next;
            //注意:要判断是否为cur.random == null
            newNode.random = cur.random == null ? null : cur.random.next;
            cur = newNode.next;
        }
        /*
        然后再遍历一遍，实现拷贝结点的连接。
        和复原原链表
        * */

        cur = head;
        Node newHead = head.next;
        Node newCur = newHead;
        printLinkedList(cur);
        while (newCur != null && newCur.next != null) {
            cur.next = cur.next.next;
            cur = cur.next;
            newCur.next = newCur.next.next;
            newCur = newCur.next;
        }

        cur.next = null;
        printLinkedList(head);
        printLinkedList(newHead);
        return newHead;
    }

    public void printLinkedList(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(";");
            System.out.print(cur.val + ",");
            System.out.print(cur.random == null ? "null" : cur.random.val);
            cur = cur.next;
        }
        System.out.println();
    }

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

package lmz.leetcode.data_structure.linked_list;


import java.util.Deque;
import java.util.LinkedList;

// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

public class Flatten430 {
    /**
     * 递归遍历：深度优先遍历
     */
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    public Node dfs(Node head){
        Node cur = head;
        Node last = null;
        while(cur != null){
            //先处理child
            if(cur.child != null){
                //获取上一个head.child的last（最后一个）结点
                last = dfs(cur.child);
                //  如果 cur.next 不为空，就将 last 与 next 相连
                if(cur.next != null){
                    last.next = cur.next;
                    cur.next.prev = last;
                }

                //连接head->head.child
                cur.next = cur.child;
                cur.child.prev = cur;
                //chuld置为空
                cur.child = null;
                last = cur;
                cur = cur.next;
            }else{
                last = cur;
                cur = cur.next;
            }
        }
        return last;
    }


    /**
     * 迭代：用stack记录下一次需要遍历的结点
     * 注意：是双向链表
     */
    public Node flatten1(Node head) {
        Node DummyHead = new Node();
        DummyHead.next = head;
        Node cur = head;
        Deque<Node> stack = new LinkedList();
        Node pre = head;
        while (cur != null || !stack.isEmpty()) {
            if(cur == null){
                pre.next = stack.pop();
                cur = pre.next;
                cur.prev = pre;
            }
            while (cur.child != null) {
                if(cur.next != null){
                    stack.push(cur.next);
                }
                cur.next = cur.child;
                cur.child = null;
                pre = cur;
                cur = cur.next;
                cur.prev = pre;
            }
            pre = cur;
            cur = cur.next;
        }
        return DummyHead.next;
    }

    public void printLinkedList(Node head){
        Node cur = head;
        while(head != null){
            System.out.print("node:");
            System.out.print(head.val);
            System.out.print(head.child);
            System.out.print(head.val);
        }
    }
}

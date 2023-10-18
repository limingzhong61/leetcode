package com.lmz.algorithm_practice.data_structure.linked_list;

/**
 * @author: limingzhong
 * @create: 2023-02-03 14:55
 */
public class FlattenII028 {
    /**
     * 迭代
     */
    public Node flatten(Node head) {
        Node p = head;
        while(p != null){
            while(p.child != null){

                //找到下一层的尾结点
                Node q = p.child;
                while(q.next != null){
                    q = q.next;
                }
                if(p.next != null){
                    p.next.prev = q;
                }

                q.next = p.next;
                p.next = p.child;
                p.child.prev = p;
                p.child = null; //置空
                p = p.next;
            }

            p = p.next;
        }
        return head;
    }
}

package com.lmz.algorithm.data_structure.linked_list.create;

public class MyLinkedList707 {


}

/*双链表*/
class MyLinkedList {
    class DoublyLinkedNode {
        int val;
        DoublyLinkedNode next;
        DoublyLinkedNode pre;

        public DoublyLinkedNode(int val, DoublyLinkedNode pre, DoublyLinkedNode next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }

    private DoublyLinkedNode head;    //使用头节点，头节点不存储数据，方便操作
    /**
     * 尾结点，在插入和删除结点时都需要做特殊判断
     */
    private DoublyLinkedNode tail;    //使用尾节点，方便插入队尾O(1)

    public MyLinkedList() {
        head = new DoublyLinkedNode(0, null, null);
        tail = head;
    }

    /**
     * 从0开始的
     *
     * @param index
     * @return
     */
    public int get(int index) {
        if (index < 0) {
            return -1;
        }
        DoublyLinkedNode cur = head.next;
        for (int i = 0; i < index && cur != null; i++) {
            cur = cur.next;
        }
        if (cur == null) {
            return -1;
        }
        // System.out.println("getIndex:"+index+",val:"+cur.val);
        // printLinkedList();
        return cur.val;
    }

    /*
    在头结点添加，tail需要特殊处理
    * */
    public void addAtHead(int val) {
        DoublyLinkedNode newNode = new DoublyLinkedNode(val, head, head.next);
        //空链表处理
        if (head == tail) {
            tail = newNode;
        }
        if (head.next != null) {
            head.next.pre = newNode;
        }
        head.next = newNode;
    }

    public void addAtTail(int val) {
        DoublyLinkedNode newNode = new DoublyLinkedNode(val, tail, null);
        tail.next = newNode;
        tail = newNode;
    }

    /**
     * 在链表中的第index个节点之前添加值为val 的节点。
     * 如果index等于链表的长度，则该节点将附加到链表的末尾。
     * 如果 index 大于链表长度，则不会插入节点。
     * 如果index小于0，则在头部插入节点。
     *
     * @param index 从0开始
     * @param val
     */
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            addAtHead(val);
        }
        DoublyLinkedNode cur = head;
        for (int i = 0; i < index && cur != null; i++) {
            cur = cur.next;
        }
        //如果 index 大于链表长度，则不会插入节点。
        if (cur == null) {
            return;
        }
        //尾结点插入
        if (cur.next == null) {
            addAtTail(val);
            return;
        }
        DoublyLinkedNode newNode = new DoublyLinkedNode(val, cur, cur.next);
        //cur.next != null
        cur.next.pre = newNode;
        cur.next = newNode;

    }

    /**
     * 如果索引 index 有效，则删除链表中的第 index 个节点。
     *
     * @param index 从0开始
     */
    /**
     * 如果索引 index 有效，则删除链表中的第 index 个节点。
     *
     * @param index 从0开始
     */
    public void deleteAtIndex(int index) {
        if (index < 0) {
            return;
        }
        DoublyLinkedNode cur = head.next;
        for (int i = 0; i < index && cur != null; i++) {
            cur = cur.next;
        }
        //index有效
        if (cur != null) {
            cur.pre.next = cur.next;
            //pre是尾结点，尾结点需要更新
            if (cur.next == null) {
                tail = cur.pre;
            }else{//
                cur.next.pre = cur.pre;
            }
        }
    }

    private void printLinkedList(){
        DoublyLinkedNode cur = head.next;
        while(cur != null){
            System.out.print(cur.val + ",");
            cur = cur.next;
        }
        System.out.println();
    }



    private void testCase1() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3
        System.out.println(linkedList.get(1)); // 2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(linkedList.get(1));// 3
    }

    private static boolean testCase2() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(7);
        linkedList.addAtHead(2);
        linkedList.addAtHead(3);
        linkedList.addAtIndex(3, 0);
        linkedList.deleteAtIndex(2);
        linkedList.addAtHead(6);
        linkedList.addAtTail(4);
        System.out.println(linkedList.get(4));
        if (linkedList.get(4) != 4) {
            return false;
        }
        linkedList.addAtHead(4);
        linkedList.addAtIndex(5, 0);
        linkedList.addAtHead(6);
        return true;
    }

    private static boolean testCase3() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtHead(3);
        linkedList.addAtIndex(1, 2);
        System.out.println(linkedList.get(1));
        if (linkedList.get(1) != 2) {
            return false;
        }
        linkedList.deleteAtIndex(0);
        System.out.println(linkedList.get(0));
        if (linkedList.get(0) != 2) {
            return false;
        }

        return true;
    }

    private static boolean testCase4() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtIndex(1, 0);
        System.out.println(linkedList.get(0));
        if (linkedList.get(0) != -1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(testCase2());
        System.out.println(testCase3());
        System.out.println(testCase4());
    }
}

/*单链表*/
class SingleLinkedList {
    class LinkedNode {
        int val;
        LinkedNode next;

        public LinkedNode(int val, LinkedNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private LinkedNode head;    //使用头节点，头节点不存储数据，方便操作
    /**
     * 尾结点，在插入和删除结点时都需要做特殊判断
     */
    private LinkedNode tail;    //使用尾节点，方便插入队尾O(1)

    public SingleLinkedList() {
        head = new LinkedNode(0, null);
        tail = head;
    }

    /**
     * 从0开始的
     *
     * @param index
     * @return
     */
    public int get(int index) {
        if (index < 0) {
            return -1;
        }
        LinkedNode cur = head.next;
        for (int i = 0; i < index && cur != null; i++) {
            cur = cur.next;
        }
        if (cur == null) {
            return -1;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        LinkedNode newNode = new LinkedNode(val, head.next);
        //空链表处理
        if (head == tail) {
            tail = newNode;
        }
        head.next = newNode;
    }

    public void addAtTail(int val) {
        LinkedNode newNode = new LinkedNode(val, null);
        tail.next = newNode;
        tail = newNode;
    }

    /**
     * 在链表中的第index个节点之前添加值为val 的节点。
     * 如果index等于链表的长度，则该节点将附加到链表的末尾。
     * 如果 index 大于链表长度，则不会插入节点。
     * 如果index小于0，则在头部插入节点。
     *
     * @param index 从0开始
     * @param val
     */
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            addAtHead(val);
        }
        LinkedNode cur = head;
        for (int i = 0; i < index && cur != null; i++) {
            cur = cur.next;
        }
        //如果 index 大于链表长度，则不会插入节点。
        if (cur == null) {
            return;
        }
        //尾结点插入
        if (cur.next == null) {
            addAtTail(val);
            return;
        }
        LinkedNode newNode = new LinkedNode(val, cur.next);
        cur.next = newNode;
    }

    /**
     * 如果索引 index 有效，则删除链表中的第 index 个节点。
     *
     * @param index 从0开始
     */
    public void deleteAtIndex(int index) {
        if (index < 0) {
            return;
        }
        LinkedNode pre = head;
        LinkedNode cur = head.next;
        for (int i = 0; i < index && cur != null; i++) {
            //pre需要同步移除
            pre = pre.next;
            cur = cur.next;
        }
        //index有效
        if (cur != null) {
            pre.next = cur.next;
            //pre是尾结点，尾结点需要更新
            if (pre.next == null) {
                tail = pre;
            }
        }
    }


    private void testCase1() {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3
        System.out.println(linkedList.get(1)); // 2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(linkedList.get(1));// 3
    }

    private static boolean testCase2() {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addAtHead(7);
        linkedList.addAtHead(2);
        linkedList.addAtHead(3);
        linkedList.addAtIndex(3, 0);
        linkedList.deleteAtIndex(2);
        linkedList.addAtHead(6);
        linkedList.addAtTail(4);
        System.out.println(linkedList.get(4));
        if (linkedList.get(4) != 4) {
            return false;
        }
        linkedList.addAtHead(4);
        linkedList.addAtIndex(5, 0);
        linkedList.addAtHead(6);
        return true;
    }

    private static boolean testCase3() {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtHead(3);
        linkedList.addAtIndex(1, 2);
        System.out.println(linkedList.get(1));
        if (linkedList.get(1) != 2) {
            return false;
        }
        linkedList.deleteAtIndex(0);
        System.out.println(linkedList.get(0));
        if (linkedList.get(0) != 2) {
            return false;
        }

        return true;
    }

    private static boolean testCase4() {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.addAtIndex(1, 0);
        System.out.println(linkedList.get(0));
        if (linkedList.get(0) != -1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(testCase2());
        System.out.println(testCase3());
        System.out.println(testCase4());
    }
}
package mars.leetcode.linkedList;

public class MyLinkedList {
    class LinkedNode{
        int val;
        LinkedNode next;

        public LinkedNode(int val, LinkedNode next) {
            this.val = val;
            this.next = next;
        }
    }
    private LinkedNode head;    //使用头节点，头节点不存储数据，方便操作
    private LinkedNode tail;    //使用尾节点，方便插入队尾O(1)
    public MyLinkedList() {
        head = new LinkedNode(0,null);
        tail = new LinkedNode(0,null);
    }

    /**
     * 从0开始的
     * @param index
     * @return
     */
    public int get(int index) {
        if(index < 0 ){
            return -1;
        }
        LinkedNode cur = head.next;
        for(int i = 0; i < index && cur != null; i++){
            cur = cur.next;
        }
        if(cur == null){
            return -1;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        LinkedNode newNode = new LinkedNode(val, head.next);
        head.next = newNode;
    }

    public void addAtTail(int val) {
        LinkedNode newNode  = new LinkedNode(val,null);
        tail.next = newNode;
        tail = newNode;
    }

    public void addAtIndex(int index, int val) {
        if(index < 0){
            addAtHead(val);
        }
        //for(int i = )
    }

    public void deleteAtIndex(int index) {

    }
}

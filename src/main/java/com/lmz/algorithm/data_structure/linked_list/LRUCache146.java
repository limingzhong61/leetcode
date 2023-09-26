package com.lmz.algorithm.data_structure.linked_list;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache146 {

    /**
     * 使用LinkedListHashMap
     */
    class LRUCache4 extends LinkedHashMap<Integer, Integer> {
        int capacity;

        public LRUCache4(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return super.size() > capacity;
        }
    }


    /**
     * 不使用LinkedHashMap:
     * 双向链表+hashMap
     */
    class LRUCache2 {
        private int capacity;
        private int size;
        HashMap<Integer, Node> map = new HashMap<>();
        LinkedList<Node> list = new LinkedList<>();

        public LRUCache2(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                updateNode(key);
                return map.get(key).value;
            }
            return -1;
        }


        public void put(int key, int value) {
            // 包含了
            if (map.containsKey(key)) {
                updateNode(key);
                map.get(key).value = value;
                return;
            }
            if (size < capacity) { // 头插入
                Node now = new Node(key, value);
                map.put(key, now);
                size++;
                // now节点插入头部
                list.addFirst(now);
            } else { // 超过容量
                // 删除尾节点
                map.remove(list.getLast().key);
                list.removeLast();
                //头插入
                Node newNode = new Node(key, value);
                list.addFirst(newNode);
                map.put(key, newNode);
            }

            // print();
        }

        private void updateNode(int key) {
            // 删除当前节点
            Node now = map.get(key);
            list.remove(now);
            list.addFirst(now);
        }


        class Node {
            int key;
            int value;
            Node next;

            Node pre;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        void print() {
            for (Node cur : list) {
                System.out.print(cur.key + ",");
                cur = cur.next;
            }
            System.out.print("tail:" + list.getLast().key);
            System.out.println();
        }
    }

    /**
     * 不使用LinkedHashMap:
     * 自己手写双向链表
     */
    class LRUCache3 {
        private int capacity;
        private int size;
        HashMap<Integer, Node> map = new HashMap<>();
        Node dummy = new Node(0, 0);
        Node tail = dummy;

        public LRUCache3(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                updateNode(key);
                return map.get(key).value;
            }
            return -1;
        }


        public void put(int key, int value) {
            // 包含了

            if (map.containsKey(key)) {
                updateNode(key);
                map.get(key).value = value;
                return;
            }
            if (size < capacity) { // 头插入
                Node now = new Node(key, value);
                map.put(key, now);
                size++;
                // now节点插入头部
                insertHead(now);
            } else { // 超过容量
                // 删除尾节点
                Node node = map.get(tail.key);
                Node pre = node.pre;
                map.remove(tail.key);

                pre.next = null;
                tail = pre;

                //头插入
                Node newNode = new Node(key, value);
                insertHead(newNode);
                map.put(key, newNode);
            }

            //print(dummy);
        }

        private void updateNode(int key) {
            // 删除当前节点
            Node now = map.get(key);
            Node pre = now.pre;
            if (now == tail) { // update tail;
                tail = pre;
            }

            pre.next = now.next;
            if (now.next != null) {
                now.next.pre = pre;
            }
            // now节点插入头部
            insertHead(now);
        }

        private void insertHead(Node now) {
            now.next = dummy.next;
            if (now.next != null) {
                now.next.pre = now;
            }
            if (dummy == tail) {
                tail = now;
            }
            now.pre = dummy;
            dummy.next = now;
        }

        class Node {
            int key;
            int value;
            Node next;

            Node pre;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }

}


class Solution {
    /**
     * 使用 双向循环链表+tHashMap
     * 1. 规定最新的结点放在链表的头部，最老的结点在尾部
     * 2. 规定新加入的结点放入链表的头部，那么超出容量要淘汰的结点就在尾部
     */
    class LRUCache {
        class Node {
            int key, value;
            Node pre,next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        int capacity;

        // 哨兵节点
        Node dummy = new Node(0, 0);
        HashMap<Integer, Node> keyToNode = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
            // 形成双向链表
            dummy.next = dummy;
            dummy.pre = dummy;
        }

        public int get(int key) {
            Node keyNode = getNode(key);
            // System.out.println(dummy.next.value);
            return keyNode == null ? - 1 : keyNode.value;
        }

        private Node getNode(int key) {
            Node keyNode = keyToNode.get(key);
            // 没有这个结点
            if(keyNode == null){
                return null;
            }
            // 移除当前结点
            removeNode(keyNode);
            // 插入到头部
            addHead(keyNode);
            return keyNode;
        }


        // 在链表头添加一个节点
        public void put(int key, int value) {
            // put 操作如果找到已经存在的结点，也同样需要把这个结点移动到最前面
            Node keyNode = getNode(key);

            if (keyNode != null) {   // 有这个结点
                keyNode.value = value; // 更新 value
                return;
            }
            // 新结点, 追加到头结点
            Node node = new Node(key, value);
            keyToNode.put(key, node);
            addHead(node);  // 放在最前面
            if (keyToNode.size() > capacity) {    // 结点太多了
                // 去掉最后一个结点
                Node backNode = dummy.pre;
                removeNode(backNode);
                keyToNode.remove(backNode.key);
            }
            // System.out.println(dummy.next.value);
        }

        // 删除一个节点
        private void removeNode(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        // 在链表头添加一个节点
        private void addHead(Node node) {
            node.pre = dummy;
            node.next = dummy.next;
            node.pre.next = node;
            node.next.pre = node;
        }
    }
}

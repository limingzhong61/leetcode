package lmz.algorithm.data_structure.linked_list;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache146 {
    /**
     * 不使用LinkedHashMap:
     * 双向链表+hashMap
     */
    class LRUCache {
        private int capacity;
        private int size;
        HashMap<Integer, Node> map = new HashMap<>();
        LinkedList<Node> list = new LinkedList<>();

        public LRUCache(int capacity) {
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
    class LRUCache2 {
        private int capacity;
        private int size;
        HashMap<Integer, Node> map = new HashMap<>();
        Node dummy = new Node(0, 0);
        Node tail = dummy;

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

        //void print(Node list) {
        //    Node cur = list;
        //    while (cur != null) {
        //        System.out.print(cur.key + ",");
        //        cur = cur.next;
        //    }
        //    System.out.print("tail:" + tail.key);
        //    System.out.println();
        //}
    }

    class LRUCache1 extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache1(int capacity) {
            //accessOrder为true
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
            return size() > capacity;
        }
    }
}

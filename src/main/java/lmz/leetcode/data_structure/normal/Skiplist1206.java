package lmz.leetcode.data_structure.normal;

import lmz.my.leetcode.TransformUtil;

import java.util.ArrayList;
import java.util.List;

public class Skiplist1206 {
    /**
     * 投机取巧，直接hash
     * 0 <= num, target <= 2 * 10^4
     */
    class Skiplist2 {
        int[] map = new int[20001];

        public Skiplist2() {

        }

        public boolean search(int target) {
            return map[target] != 0;
        }

        public void add(int num) {
            map[num]++;
        }

        /**
         * 在跳表中删除一个值，如果 num 不存在，直接返回false.
         * 如果存在多个 num ，删除其中任意一个即可
         */
        public boolean erase(int num) {
            if (map[num] == 0) {
                return false;
            }
            map[num]--;
            return true;
        }
    }

    static class Skiplist {
        //当前层数
        private int curLevel;
        //头结点，不保存值
        private Node head;
        //跳表中元素个数
        private int size;
        //用于生成随机层数
        private static final double PROBABILITY = 0.5;
        //最大层数,也可以写成通过构造函数注入的方式动态设置
        private static final int maxLevel = 8;

        /**
         * 封装信息，构造链表
         */
        class Node {
            //保存值
            int val;
            //保存了每一层上的节点信息（每一层下一个结点），可能为null
            List<Node> forwards;

            //将每层设置为null
            Node(int val) {
                this.val = val;
                forwards = new ArrayList<>(maxLevel);
                //事先把每一层都置为null，虽然空间利用率没那么高，但是简化了实现
                //也可以通过自定义列表(比如B树实现中用到的Vector)来实现，就可以不用下面的操作
                for (int i = 0; i <= maxLevel; i++) {
                    forwards.add(null);
                }
            }

            //得到当前节点level层上的下一个(右边一个)节点
            Node next(int level) {
                return forwards.get(level);
            }
        }


        public Skiplist() {
            //初始化head,head头结点，不保存值
            head = new Node(-1);
        }

        /**
         * 生成随机层数[0,maxLevel)
         * 生成的值越大，概率越小
         *
         * @return
         */
        private int randomLevel() {
            int level = 0;
            while (Math.random() < PROBABILITY && level < maxLevel - 1) {
                ++level;
            }
            return level;
        }

        /**
         * 查找
         */
        public boolean search(int target) {
            int level = this.curLevel;
            Node startHead = head; // 最开始从head找
            //从上到下，逐层查找
            while (level >= 0) {
                Node pre = startHead;
                Node cur = startHead.next(level);
                // 找到cur为>= num或为null,即pre后为插入位置
                while (cur != null) {
                    if (cur.val == target) {
                        return true;
                    } else if (cur.val > target) {
                        break;
                    }
                    pre = cur;
                    cur = cur.next(level);
                }
                startHead = pre; // 此时肯定在范围【pre,pre.next(level)】中查找
                level--;
            }
            return false;
        }

        /**
         * 插入一个元素到跳表。
         * @param num
         */
        public void add(int num) {
            //if (search(num)) { //已经存在
            //    return;
            //}
            int level = this.randomLevel();
            //更新当前层数
            if (curLevel < level) {
                curLevel = level;
            }
            Node newNode = new Node(num);
            Node startHead = head; // 最开始从head找
            //从上到下，逐层插入
            while (level >= 0) {
                Node pre = startHead;
                Node cur = startHead.next(level);
                // 找到cur为>= num或为null,即pre后为插入位置
                while (cur != null && cur.val < num) {
                    pre = cur;
                    cur = cur.next(level);
                }
                startHead = pre;
                //cur == pre.next(level)
                newNode.forwards.set(level, pre.next(level));
                pre.forwards.set(level, newNode);
                level--;
            }
            this.size++;
            //System.out.println("add : " + num);
        }

        public boolean erase(int target) {
            if (size == 0) {
                return false;
            }
            int level = this.curLevel;
            Node startHead = head; // 最开始从head找
            //从上到下，逐层查找，找到删除
            boolean find = false;
            while (level >= 0) {
                Node pre = startHead;
                Node cur = startHead.next(level);
                // 找到cur为>= num或为null,即pre后为插入位置
                while (cur != null) {
                    if (cur.val == target) {
                        pre.forwards.set(level, cur.next(level)); // 删除元素
                        find = true;
                        break;
                    } else if (cur.val > target) {
                        break;
                    }
                    pre = cur;
                    cur = cur.next(level);
                }
                startHead = pre; // 此时肯定在范围【pre,pre.next(level)】中查找
                level--;
            }
            //System.out.println("earse : " + target);
            if (find) {
                this.size--;
            }
            return find;
        }
    }

    public static void main(String[] args) {
        String[] opts = TransformUtil.toStringArray("[\"Skiplist\",\"add\",\"add\",\"add\",\"add\"" +
                ",\"search\",\"erase\",\"search\",\"search\",\"search\"]");
        int[] vals = TransformUtil.toIntArray("[[-1],[0],[5],[2],[1],[0],[5],[2],[3],[2]]");
        Skiplist skiplist = new Skiplist();
        for (int i = 1; i < opts.length; i++) {
            if ("add".equals(opts[i])) {
                skiplist.add(vals[i]);
            } else if ("search".equals(opts[i])) {
                System.out.println(skiplist.search(vals[i]));
            } else {
                System.out.println(skiplist.erase(vals[i]));
            }
        }
        System.out.println(new Skiplist().randomLevel());
    }
}

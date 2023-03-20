package lmz.leetcode.bruce_solution.bruce_search.my.solution_template.skip_list;



import java.util.*;

/**

 * 跳表
 */
public class SkipList<E extends Comparable<? super E>> implements Iterable<E> {
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

    public SkipList() {
        size = 0;
        curLevel = 0;
        head = new Node(null);
    }

    public int size() {
        return size;
    }

    /**
     * 添加操作，重复元素不会插入
     * @param e
     * @return
     */
    public boolean add(E e) {
        if (contains(e)) {
            return false;
        }
        int level = randomLevel();
        if (level > curLevel) {
            curLevel = level;
        }
        Node newNode = new Node(e);
        Node current = head;
        //插入方向由上到下
        while (level >= 0) {
            //找到比e小的最大节点
            current = findNext(e, current, level);
            //将newNode插入到current后面
            //newNode的next指针指向该节点的后继
            newNode.forwards.add(0, current.next(level));
            //该节点的next指向newNode
            current.forwards.set(level, newNode);
            level--;//每层都要插入
        }
        size++;
        return true;
    }

    //返回给定层数中小于e的最大者
    private Node findNext(E e, Node current, int level) {
        Node next = current.next(level);
        while (next != null) {
            if (e.compareTo(next.data) < 0) {
                break;
            }
            //到这说明e >= next.data
            current = next;
            next = current.next(level);
        }
        return current;
    }

    public Node find(E e) {
        if (empty()) {
            return null;
        }
        return find(e, head, curLevel);
    }

    private Node find(E e, Node current, int level) {
        while (level >= 0) {
            current = findNext(e, current, level);
            level--;
        }
        return current;
    }

    public boolean empty() {
        return size == 0;
    }

    /**

     * O(logN)的删除算法
     *
     * @param e
     * @return
     */
    public boolean remove(E e) {
        if (empty()) {
            return false;
        }
        boolean removed = false;//记录是否删除
        int level = curLevel;
        //current用于遍历,pre指向待删除节点前一个节点
        Node current = head.next(level), pre = head;
        while (level >= 0) {
            while (current != null) {
                //e < current.data
                if (e.compareTo(current.data) < 0) {
                    break;
                }
                //只有e >= current.data才需要继续
                //如果e == current.data
                if (e.compareTo(current.data) == 0) {
                    //pre指向它的后继
                    pre.forwards.set(level, current.next(level));
                    //设置删除标记
                    removed = true;
                    //跳出循环内层循环
                    break;
                }
                pre = current;
                current = current.next(level);
            }
            //继续搜索下一层
            level--;
            if (level < 0) {
                //防止next(-1)
                break;
            }
            //往下一层,从pre开始往下即可，不需要从头(header)开始
            current = pre.next(level);
        }
        if (removed) {
            size--;//不要忘记size--
            return true;
        }
        return false;
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

    public boolean contains(E e) {
        Node node = find(e);
        return node != null && node.data != null && node.data.compareTo(e) == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new SkipListIterator();
    }

    private class SkipListIterator implements Iterator<E> {
        Node current = head;

        @Override
        public boolean hasNext() {
            return current.next(0) != null;
        }

        @Override
        public E next() {
            current = current.next(0);
            return current.data;
        }

    }

    private class Node {
        //保存值
        E data;
        //保存了每一层上的节点信息，可能为null
        List<Node> forwards;

        Node(E data) {
            this.data = data;
            forwards = new ArrayList<>();
            //事先把每一层都置为null，虽然空间利用率没那么高，但是简化了实现
            //也可以通过自定义列表(比如B树实现中用到的Vector)来实现，就可以不用下面的操作
            for (int i = 0; i <= maxLevel; i++) {
                forwards.add(null);
            }
        }

        @Override
        public String toString() {
            return data == null ? " " : "" + data;
        }

        /**
         * 得到当前节点level层上的下一个(右边一个)节点
         *
         * @param level
         * @return
         */
        Node next(int level) {
            return this.forwards.get(level);
        }

    }

    public void print() {
        //记录了第0层值对应的索引，从1开始
        Map<E, Integer> indexMap = new HashMap<>();
        Node current = head.next(0);
        int index = 1;
        int maxWidth = 1;//值的最大宽度，为了格式化好看一点
        while (current != null) {
            int curWidth = current.data.toString().length();
            if (curWidth > maxWidth) {
                maxWidth = curWidth;//得到最大宽度
            }
            indexMap.put(current.data, index++);
            current = current.next(0);
        }
        print(indexMap, maxWidth);
    }

    private void print(int level, Node current, Map<E, Integer> indexMap, int width) {
        System.out.print("Level " + level + ": ");
        int preIndex = 0;//该层前一个元素的索引
        while (current != null) {
            //当前元素的索引
            int curIndex = indexMap.get(current.data);
            if (level == 0) {
                //第0层直接打印即可
                printSpace(curIndex - preIndex);
            } else {
                //其他层稍微复杂一点
                //计算空格数
                //相差的元素个数 + 相差的元素个数乘以宽度
                int num = (curIndex - preIndex) + (curIndex - preIndex - 1) * width;
                printSpace(num);
            }
            System.out.printf("%" + width + "s", current.data);
            preIndex = curIndex;
            current = current.next(level);
        }
        System.out.println();
    }

    /**

     * 打印num个空格
     *
     * @param num
     */
    private void printSpace(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print(' ');
        }
    }

    private void print(Map<E, Integer> map, int width) {
        //从顶层开始打印
        int level = curLevel;
        while (level >= 0) {
            print(level, head.next(level), map, width);
            level--;
        }
    }

    public static void main(String[] args) {
        //Random random = new Random();
        //int[] values = random.ints(2000, 1, 10000).toArray();
        int[] values = {1, 6, 9, 3, 5, 7, 4, 8};
        SkipList<Integer> list = new SkipList<>();
        for (int value : values) {
            //System.out.println("add: " + value);
            list.add(value);
            //list.print();
            //System.out.println();
        }

        System.out.println("before remove:");
        list.print();
        System.out.println();


        for (int value : values) {
            list.remove(value);
            System.out.println("remove: " + value);
            list.print();
            System.out.println();
        }

    }

}

package lmz.leetcode.other.old.everyday;

import lmz.leetcode.data_structure.linked_list.ListNode;

import java.util.ArrayList;
import java.util.Random;

public class GetRandom382 {
    /**
     * 蓄水池抽象算法
     */
    class Solution {
        ListNode head;
        Random random = new Random();
        public Solution(ListNode _head) {
            head = _head;
        }
        public int getRandom() {
            int ans = 0, idx = 0;
            ListNode t = head;
            while (t != null && ++idx >= 0) {
                // 1/idx的概率：在[0,idx)中取i
                if (random.nextInt(idx) == 0) ans = t.val;
                t = t.next;
            }
            return ans;
        }
    }
    class Solution2 {
        Random random = new Random();
        ArrayList<Integer> list;

        public Solution2(ListNode head) {
            ListNode cur = head;
            this.list = new ArrayList<>();
            while (cur != null) {
                list.add(cur.val);
                cur = cur.next;
            }
        }

        /**
         * 每个节点 被选中的概率一样 。
         */
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}

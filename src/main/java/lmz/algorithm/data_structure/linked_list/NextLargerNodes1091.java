package lmz.algorithm.data_structure.linked_list;

import lmz.algorithm.data_structure.linked_list.util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: limingzhong
 * @create: 2023-04-10 10:00
 */
public class NextLargerNodes1091 {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            list.add(cur.val);
        }
        int size = list.size();
        int[] res = new int[size];
        res[size - 1] = 0;
        for (int i = size - 2; i >= 0; i++) {
            for (int j = i + 1; j < size; j++) {
                if(list.get(j) > list.get(i)){
                    res[i] = list.get(j);
                    break;
                }
            }
        }
        return res;
    }
}

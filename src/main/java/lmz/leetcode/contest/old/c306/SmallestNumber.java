package lmz.leetcode.contest.old.c306;

import java.util.Deque;
import java.util.LinkedList;

public class SmallestNumber {
    /**
     * 长度很小直接改
     * 1 <= pattern.length <= 8
     * pattern 只包含字符 'I' 和 'D'
     */
    public String smallestNumber(String pattern) {
        int len = pattern.length();
        char[] cs = pattern.toCharArray();
        Deque<Integer> deque = new LinkedList<>();
        deque.push(1);
        int preMaxNum = 1;

        for (int i = 0; i < len; i++) {
            if (pattern.charAt(i) == 'I') {
                deque.addLast(preMaxNum + 1);
                preMaxNum = preMaxNum+1;
            } else { // 'D'
                deque.pollLast(); //前一个数填充错误

                int pre = deque.isEmpty() ? -1 : deque.peekLast();
                //统计D的个数
                int cntD = 0;
                for(int j = i; j < len && pattern.charAt(j) == 'D'; j++){
                        cntD++;
                }
                int start = cntD +pre + 1;
                i = i-1; //从前一个I开始
                for(int j = 0; j <= cntD; j++){
                    deque.addLast(start--);
                    i++;
                }
                //if()
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append((char) ('0' + deque.pollFirst()));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SmallestNumber smallestNumber = new SmallestNumber();
        System.out.println(smallestNumber.smallestNumber("IIIDIDDD"));
    }
}

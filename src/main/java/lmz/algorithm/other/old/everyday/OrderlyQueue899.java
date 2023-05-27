package lmz.algorithm.other.old.everyday;

import java.util.Arrays;

public class OrderlyQueue899 {
    /**
     * leetcode
     * 当 K == 1 时， 只能循环移动每个元素，无法改变相对位置。因此只需要获取循环移动过程中字典序最小的序列。
     * 当 K > 1 时， 可以生成当前字符串的任意序列。因此将原字符串排序生成字典序最小的序列。
     * 1 <= k <= S.length <= 1000
     * s 只由小写字母组成
     */
    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return String.valueOf(chars);
        } else {
            StringBuilder sb = new StringBuilder(s);
            String smallest = s;
            int len = s.length();
            for (int i = 1; i < len; i++) {
                char c = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(c);
                if (sb.toString().compareTo(smallest) < 0) {
                    smallest = sb.toString();
                }
            }
            return smallest;
        }
    }

    public static void main(String[] args) {
        OrderlyQueue899 orderlyQueue899 = new OrderlyQueue899();
        System.out.println(orderlyQueue899.orderlyQueue("cba", 1));
        System.out.println(orderlyQueue899.orderlyQueue("cba", 1).equals("acb"));
        System.out.println(orderlyQueue899.orderlyQueue("baaca", 3));
        System.out.println(orderlyQueue899.orderlyQueue("baaca", 3).equals("aaabc"));
    }
}

package com.lmz.algorithm_practice.two_pointer.same_direction_aka_slide_window;

/**
 * @author: limingzhong
 * @create: 2023-06-21 11:31
 */
public class MinWindow76 {
    //s 和 t 由英文字母组成
    public String minWindow(String s, String t) {


        int[] need = new int[128];
        //记录需要的字符的个数
        for (char c : t.toCharArray()) {
            need[c]++;
        }
        char[] cs = s.toCharArray();
        int n = cs.length;
        int minLen = n + 1;
        //left是当前左边界，right是当前右边界，minLen记录窗口大小，needCnt是需求的字符个数，start是最小覆盖串开始的index
        int left = 0, right = 0;
        int start = -1, needCnt = t.length();
        for (; right < n; right++) {
            char c = cs[right];
            if (need[c] > 0) { //需要字符c
                needCnt--;
            }
            need[c]--;//把右边的字符加入窗口
            if (needCnt == 0) {//窗口中已经包含所有字符,找到一个[left,right] 满足条件的
                while (left < right && need[cs[left]] < 0) {
                    need[cs[left]]++;//释放右边移动出窗口的字符
                    left++;//指针右移
                }
                int len = right - left + 1;
                if (len < minLen) { //不能右移时候挑战最小窗口大小，更新最小窗口开始的start
                    minLen = len;
                    start = left; //记录下最小值时候的开始位置，最后返回覆盖串时候会用到
                }
                //l向右移动后窗口肯定不能满足了 重新开始循环
                need[cs[left]]++;
                left++;
                needCnt++;
            }
        }

        return start != -1 ? s.substring(start, start + minLen) : "";
    }
}

package com.lmz.algorithm.other.n1_1000;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author: limingzhong
 * @create: 2023-08-15 11:47
 */
public class PredictPartyVictory649 {
    /**
        官方题解： 更优解
        用两个队列q1,q2保存idx，每次比较idx，并两个队头取出，
        小的能将当前的idx+n 添加到自己队列中；
        即添加小的idx到队列末尾idx+n，大的删除（被禁止使用权利）
     */
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<Integer>();
        Queue<Integer> dire = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int radiantIndex = radiant.poll(), direIndex = dire.poll();
            if (radiantIndex < direIndex) {
                radiant.offer(radiantIndex + n);
            } else {
                dire.offer(direIndex + n);
            }
        }
        return !radiant.isEmpty() ? "Radiant" : "Dire";
    }


    //1 <= n <= 104
    public String predictPartyVictory1(String senate) {
        int n = senate.length();

        char[] cs = senate.toCharArray();
        ArrayList<Character> list = new ArrayList<>(n);
        for (char c : senate.toCharArray()) {
            list.add(c);
        }
        while (n > 0) {
            boolean[] forbid = new boolean[n];
            ArrayList<Character> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if(forbid[i]) continue;
                if (list.get(i) == 'R') {
                    // 应该立马禁止后面的，因为后面的有权利执行
                    for (int j = (i+1)%n; j != i; j = (j+1) % n) {
                        if (list.get(j) == 'D' && !forbid[j]) {
                            forbid[j] = true;
                            break;
                        }
                    }
                } else {
                    for (int j = (i+1)%n; j != i; j = (j+1) % n) {
                        if (list.get(j) == 'R' && !forbid[j]) {
                            forbid[j] = true;
                            break;
                        }
                    }
                }
            }
            int cntR = 0;
            for (int j = 0; j < n; j++) {
                if (!forbid[j]) {
                    if (list.get(j) == 'R') cntR++;
                    temp.add(list.get(j));
                }

            }
            System.out.printf("%d,%d\n", cntR, temp.size());
            System.out.println(Arrays.toString(forbid));
            if (cntR == 0) return "Dire";
            else if (cntR == temp.size()) return "Radiant";
            list = temp;
            n = temp.size();
        }
        return "";
    }
}

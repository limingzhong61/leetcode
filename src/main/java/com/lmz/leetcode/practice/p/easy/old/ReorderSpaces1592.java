package com.lmz.leetcode.practice.p.easy.old;

import java.util.ArrayList;
import java.util.List;

public class ReorderSpaces1592 {
    public String reorderSpaces(String text) {
        int len = text.length();
        int cntSpace = 0;
        List<String> words = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                cntSpace++;
            } else {
                StringBuilder sb = new StringBuilder();
                while (i < len && text.charAt(i) != ' ') {
                    sb.append(text.charAt(i));
                    i++;
                }
                words.add(sb.toString());
                i--;
            }
        }
        StringBuilder res = new StringBuilder();
        res.append(words.get(0));
        if (words.size() > 1) {
            int maxSpace = cntSpace / (words.size() - 1);
            for (int i = 1; i < words.size(); i++) {
                res.append(" ".repeat(Math.max(0, maxSpace)));
                res.append(words.get(i));
            }
            res.append(" ".repeat(Math.max(0, cntSpace - maxSpace * (words.size() - 1))));
        }else{
            res.append(" ".repeat(cntSpace));
        }
        return res.toString();
    }
}

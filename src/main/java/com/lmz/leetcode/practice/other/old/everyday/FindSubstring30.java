package com.lmz.leetcode.practice.other.old.everyday;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.*;

public class FindSubstring30 {
    /**
     * leetcode
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int m = words.length, oneLen = words[0].length(), ls = s.length();
        for (int i = 0; i < oneLen; i++) {
            if (i + m * oneLen > ls) {
                break;
            }
            Map<String, Integer> differ = new HashMap<>();
            for (int j = 0; j < m; j++) {
                String word = s.substring(i + j * oneLen, i + (j + 1) * oneLen);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                if (differ.get(word) == 0) {
                    differ.remove(word);
                }
            }
            for (int start = i; start < ls - m * oneLen + 1; start += oneLen) {
                if (start != i) {
                    String word = s.substring(start + (m - 1) * oneLen, start + m * oneLen);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                    word = s.substring(start - oneLen, start);
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                }
                if (differ.isEmpty()) {
                    res.add(start);
                }
            }
        }
        return res;
    }

    /**
     * 滑动窗口：关键words中字符串长度相同均为oneLen。
     * 将字符串划分为oneLen个长度的数组[i,i+m*oneLen]，进行滑动数组匹配。
     * 用hashmap统计是否匹配；
     */
    public List<Integer> findSubstring1(String s, String[] words) {
        //1 <= words.length <= 5000
        int ls = s.length(), m = words.length, oneLen = words[0].length();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < oneLen; i++) {
            if (i + m * oneLen > ls) {
                break;
            }
            Map<String, Integer> originalMap = new HashMap<>();
            for (String word : words) {
                originalMap.put(word, originalMap.getOrDefault(word, 0) + 1);
            }
            Map<String, Integer> map = new HashMap<>(originalMap);
            int cnt = 0; // 记录到匹配单词的次数；
            for (int start = i, end = i; end + oneLen <= ls; end += oneLen) {
                String word = s.substring(end, end + oneLen);
                if (map.containsKey(word)) {
                    Integer wordCnt = map.get(word);
                    if (wordCnt ==  0) { // 多包含，滑动匹配
                        String startStr = s.substring(start, start + oneLen);
                        while(!startStr.equals(word) ){ // 移动start，直到删除一个wordCnt（因为多了一个）
                            start = start + oneLen; //移动start
                            map.put(startStr, map.get(startStr) + 1); // 减去已经匹配成功的
                            cnt --; //少匹配一个
                            startStr = s.substring(start, start + oneLen);
                        }
                        start = start + oneLen; //移动start
                        continue;
                    }
                    map.put(word, wordCnt - 1);
                    cnt++;
                    if (cnt == m) { // 匹配成功
                        res.add(start);
                        String startStr = s.substring(start, start + oneLen);
                        //加上滑动失去的startStr;
                        map.put(startStr, map.get(startStr) + 1);
                        start += oneLen; //start前进一格
                        cnt--;
                    }
                } else { //不包含，重新匹配
                    start = end + oneLen;
                    cnt = 0;
                    map = new HashMap<>(originalMap); //重置map
                    continue;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindSubstring30 findSubstring30 = new FindSubstring30();

        System.out.println(findSubstring30.findSubstring(
                "barfoothefoobarman", TransformUtil.toStringArray("[\"foo\",\"bar\"]")));

        System.out.println(findSubstring30.findSubstring(
                "wordgoodgoodgoodbestword", TransformUtil.toStringArray("[\"word\",\"good\",\"best\",\"word\"]")));

        System.out.println(findSubstring30.findSubstring(
                "barfoofoobarthefoobarman", TransformUtil.toStringArray("[\"bar\",\"foo\",\"the\"]")));

        System.out.println(findSubstring30.findSubstring(
                "wordgoodgoodgoodbestword", TransformUtil.toStringArray("[\"word\",\"good\",\"best\",\"good\"]")));

        System.out.println(findSubstring30.findSubstring(
                "aaa", TransformUtil.toStringArray("[\"a\",\"a\"]")));
    }
}

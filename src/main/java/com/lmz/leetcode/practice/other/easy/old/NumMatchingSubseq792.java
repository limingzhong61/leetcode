package com.lmz.leetcode.practice.other.easy.old;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author: codeofli
 * @create: 2022-11-17 9:25
 */
public class NumMatchingSubseq792 {
    /**
     * 存储字母的下标+二分，单独判断每个字母的时候，只需二分找到该字母在s中的下一个位置即可，时间复杂度O(m+nl*log m)：
     * lc: 二分查找，
     * 暴力会超时
     * 记录每个字符出现的位置pos数组（pos从小到大排序，可以二分查找），当需要在s[i,n-1]中找到word[j]的字符时,
     * 只需要在pos[word[j]]中找到是否有>=i的位置下标。
     * log(n)*word_size*word_length = log_2(5*10^4) *25*10^4
     * words[i]和 s 都只由小写字母组成。
     */
    public int numMatchingSubseq1(String s, String[] words) {
        final int charSize = 26;
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; ++i) {
            pos[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < s.length(); i++){
            pos[s.charAt(i) - 'a'].add(i);
        }
        int res = 0;
        for(String word : words){
            boolean success = true;
            int p = 0;
            for(char c : word.toCharArray()){
                int idx = greaterNumberIndexByBS(pos[c - 'a'], p);
                if (idx == pos[c - 'a'].size()) { //有可能比数组中所有数字都大
                    success = false;
                    break;
                }
                p = pos[c-'a'].get(idx) + 1;
                System.out.printf("%s,%d\n",word,p);
            }
            if (success) {
                res++;
            }
        }
        return res;
    }

    /**
     * 二分查找>= x的最小值下标。
     * F,T 右边界[....,<=,>,.....]
     * @return 返回的index有越界检查，不会越界
     */
    public static int greaterNumberIndexByBS(List<Integer> arr, int key) {
        int low = 0, high = arr.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) >= key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * 存储next位置的数组，直接对每个位置的下一个某个字母的下标进行记录，查找可在O(1)时间完成，时间复杂度O(mC+nl)
     *用队列存储每个char的<word_i,next_post_i>，直接遍历s，每次只需要在queue[s.charAt(i)]在检查更新即可。
     */
    public int numMatchingSubseq(String s, String[] words) {
        final int charSize = 26;
        // <word_i,next_post_i>
        Queue<int[]>[] queues = new Queue[charSize];
        for(int i = 0; i < queues.length; i++){
            queues[i] = new ArrayDeque<int[]>();
        }
        for(int i = 0; i < words.length; i++){
            queues[words[i].charAt(0) - 'a'].add(new int[]{i,0});
        }
        int res = 0;
        for(char c : s.toCharArray()){
            Queue<int[]> nowCharQueue = queues[c - 'a'];
            int size = nowCharQueue.size();
            for(int i = 0; i < size; i++){
                int[] poll = nowCharQueue.poll();
                if(poll[1] == words[poll[0]].length() - 1){
                    res++;
                }else{
                    ++poll[1];
                    queues[words[poll[0]].charAt(poll[1]) - 'a'].add(new int[]{poll[0],poll[1]});
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        NumMatchingSubseq792 numMatchingSubseq792 = new NumMatchingSubseq792();
        System.out.println(numMatchingSubseq792.numMatchingSubseq("abcde", TransformUtil.toStringArray("[\"a\",\"bb\",\"acd\",\"ace\"]")));
    }
}

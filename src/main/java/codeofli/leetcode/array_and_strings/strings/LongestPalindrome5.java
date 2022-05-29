package codeofli.leetcode.array_and_strings.strings;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindrome5 {
    /**
     * my:dp:
     * 状态：(length,i,j)，长度为length的子回文串[i,j],length可以省略
     * 因为length=j-i+1
     * 3维数组太大，可以用list[length]存储（i,j),表示length的子回文串[i,j]
     * 状态转移方程：
     * (i,j) = list[length-2].pop()
     * if(s[i-1] == s[j+1])
     * list[length].add(i-1,j+1);
     * 因为只用了两个list，故可用滚动数组省略,
     */
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int strLength = chars.length;
        List<int[]> sub1 = new ArrayList<>();
        List<int[]> sub2 = new ArrayList<>();

        //初始化边界,length=1，[i,i]
        int maxLength = 1;
        for (int i = 0; i < strLength; i++) {
            sub1.add(new int[]{i, i});
        }
        //初始化边界,length=2，
        for (int i = 1; i < strLength; i++) {
            if (chars[i] == chars[i - 1]) {
                sub2.add(new int[]{i - 1, i});
                maxLength = 2;
            }
        }
        //因为是最大回文子串，故最大只可能为strLength-1.
        for (int length = 1; length < strLength; length++) {
            List<int[]> temp = new ArrayList();
            if ((length & 1) != 0) { //奇数
                for (int j = 0; j < sub1.size(); j++) {
                    int[] idx = sub1.get(j);
                    if (idx[0] > 0 && idx[1] < strLength - 1) { //不能越界
                        if (chars[idx[0] - 1] == chars[idx[1] + 1]) {
                            temp.add(new int[]{idx[0] - 1, idx[1] + 1});
                        }
                    }
                }
                if (sub2.size() == 0 && temp.size() == 0) {
                    break;
                }
                sub1 = temp;
            } else {

                for (int j = 0; j < sub2.size(); j++) {
                    int[] idx = sub2.get(j);
                    if (idx[0] > 0 && idx[1] < strLength - 1) { //不能越界
                        if (chars[idx[0] - 1] == chars[idx[1] + 1]) {
                            temp.add(new int[]{idx[0] - 1, idx[1] + 1});
                        }
                    }
                }
                if (sub1.isEmpty() && temp.isEmpty()) {
                    break;
                }

                sub2 = temp;
            }
            if(!temp.isEmpty()){
                maxLength = length;
            }

        }
        if(maxLength % 2 == 0){ // 最长回文子串为偶数长度，统一处理为sub1
            sub1 = sub2;
        }

        int[] indexs = sub1.get(0); //取其中一个
        return String.copyValueOf(chars, indexs[0], indexs[1] - indexs[0] + 1);
    }

    public static void main(String[] args) {
        LongestPalindrome5 longestPalindrome = new LongestPalindrome5();
        //System.out.println(longestPalindrome.longestPalindrome("babad"));
        System.out.println(longestPalindrome.longestPalindrome("babad").equals("bab"));
        System.out.println(longestPalindrome.longestPalindrome("cbbd").equals("bb"));
    }
}

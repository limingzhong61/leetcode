package com.lmz.leetcode.practice.p.p_1000_2000;

/**
 * @author: limingzhong
 * @create: 2023-08-03 20:05
 */
public class GcdOfStrings1071 {
    /**
     * leetcode：https://leetcode.cn/problems/greatest-common-divisor-of-strings/solutions/144954/java-hen-jian-ji-yi-yan-jiu-neng-kan-ming-bai-by-s/?envType=study-plan-v2&envId=leetcode-75
     */
    public String gcdOfStrings(String str1, String str2) {
        // 假设str1是N个x，str2是M个x，那么str1+str2肯定是等于str2+str1的。
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        // 辗转相除法求gcd。
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b) {
        return b == 0? a: gcd(b, a % b);
    }

    public String gcdOfStrings1(String str1, String str2) {

        int len1 = str1.length(),len2 = str2.length();
        String ans = "";
        // 枚举 str1\str2 的子串长度
        for(int len = 1; len <= len1 / 2; len++){
            // 长度必须能被两个串的长度整除
            if(len1 % len != 0 || len2 % len != 0){
                continue;
            }
            boolean success = true;
            String sub = str1.substring(0,len);
            for(int i = len; i <= len1 - len; i += len){
                if(sub.equals(str1.substring(i,len))){
                    success = false;
                    break;
                }
            }
            if(!success) continue;
            for(int i = len; i <= len1 - len; i += len){
                if(sub.equals(str1.substring(i,len))){
                    success = false;
                    break;
                }
            }
            if(success){
                ans = sub;
                break;
            }
        }
        return ans;
    }
}

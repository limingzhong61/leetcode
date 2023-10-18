package com.lmz.algorithm_practice.other.medium.old;

/**
 * @author: limingzhong
 * @create: 2023-01-26 10:17
 */
public class GetSmallestString1663 {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i = n; i >= 1; i--){
            int next = (n - 1) * 26 - k;
            System.out.printf("%d,%d\n",k,next);
            if(next >= 0){ // 当前安排a,后面安排字母是可行的
                sb.append('a');
                k--;
            }else{
                sb.append((char)('a' - next));
            }
        }
        return sb.toString();
    }
}

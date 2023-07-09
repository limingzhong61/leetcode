package com.lmz.algorithm.contest.old.c317;

/**
 * @author: codeofli
 * @create: 2022-10-30 11:05
 */
public class MakeIntegerBeautiful {
    public long makeIntegerBeautiful(long n, int target) {
        this.target = target;
        char[] digit = String.valueOf(n).toCharArray();
        int[] digits = new int[digit.length];
        for(int i = 0; i < digit.length; i++){
            digits[i] = digit[i] - '0';
        }
        dfs(n,digits,0,0L);
        return res;
    }
    int target = 0;
    long res = Long.MAX_VALUE;
    private void dfs(long n, int[] digits, int cur,long sum) {
        //if(res != -1){
        //    return;
        //}
        if(cur == digits.length){
            char[] cs = String.valueOf(n).toCharArray();
            long nextSum = 0;
            for(int i = cs.length - 1; i >= 0 ; i--){
                nextSum += cs[i] - '0';
            }
            if(nextSum <= target){
                res = Math.min(res,sum);
            }
            return;
        }
        dfs(n,digits,cur+1,sum);
        long curD;
        long buD ;
        long buV;
        if(cur > 0){
            long base = (long)(Math.pow(10,cur));
            curD = n / base % 10;
            buD = 10 -curD;
            buV = buD * base;
        }else{
            curD = n % 10;
            buD = 10 -curD;
            buV = buD;
        }
        if(curD != 0){
            dfs(n +buV ,digits,cur+1,sum + buV);
        }
    }

    public static void main(String[] args) {
        MakeIntegerBeautiful makeIntegerBeautiful = new MakeIntegerBeautiful();
        //System.out.println(makeIntegerBeautiful.makeIntegerBeautiful(16, 6));
        //System.out.println(makeIntegerBeautiful.makeIntegerBeautiful(16, 6) == 4);
        //System.out.println(makeIntegerBeautiful.makeIntegerBeautiful(467, 6));
        //System.out.println(makeIntegerBeautiful.makeIntegerBeautiful(467, 6) == 33);
        System.out.println(makeIntegerBeautiful.makeIntegerBeautiful(590, 1));
        System.out.println(makeIntegerBeautiful.makeIntegerBeautiful(8, 2));
        System.out.println(makeIntegerBeautiful.makeIntegerBeautiful(1, 1) == 0);
    }


    //public long makeIntegerBeautiful(long n, int target) {
    //    this.target = target;
    //    char[] digit = String.valueOf(n).toCharArray();
    //    int[] digits = new int[digit.length];
    //    for(int i = 0; i < digit.length; i++){
    //        digits[i] = digit[i] - '0';
    //    }
    //    dfs(n,digits,digits.length - 1,0L);
    //    return res;
    //}
    //int target = 0;
    //long res = -1;
    //private void dfs(long n, int[] digits, int cur,long sum) {
    //    if(res != -1){
    //        return;
    //    }
    //    if(cur == -1){
    //        long next = n + sum;
    //        char[] cs = String.valueOf(next).toCharArray();
    //        long nextSum = 0;
    //        for(int i = 0; i < cs.length; i++){
    //            nextSum += nextSum * 10 + cs[i] - '0';
    //        }
    //        if(nextSum < target){
    //            res = sum;
    //        }
    //        return;
    //    }
    //    dfs(n,digits,cur-1,sum);
    //    dfs(n ,digits,cur-1,sum + digits[cur]);
    //}
}

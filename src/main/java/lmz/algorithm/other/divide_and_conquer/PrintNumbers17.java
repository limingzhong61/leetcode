package lmz.algorithm.other.divide_and_conquer;

import java.util.Arrays;

public class PrintNumbers17 {
    int[] res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public int[] printNumbers(int n) {
        this.n = n;
        res = new int[(int)Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;
        dfs(0);
        return res;
    }
    void dfs(int x) {
        if(x == n) {
            String s = String.valueOf(num).substring(start);
            if(!s.equals("0")) res[count++] = Integer.parseInt(s);
            if(n - start == nine) start--;
            return;
        }
        for(char i : loop) {
            if(i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }
    /**
     * 考虑大数的全排列:
     * 利用string来做全排列
     * 1. 删除高位多余的 0:
     * 变量 startstart 规定字符串的左边界，
     * 以保证添加的数字字符串 num[start:] 中无高位多余的 0 。
     * 例如当 n=2 时， 1−9 时start=1 ，10−99 时start=0 。
     */
    StringBuilder ans = new StringBuilder();
    char[] nums;
    int nineCnt = 0;

    public String printNumbersUseString(int n) {
        nums = new char[n];
        //刚开始nums[n-1,n]，只有一位
        start = n - 1;
        recur(0, n);
        return ans.toString();
    }

    public void recur(int x, int n) {
        if (x == n) {
            String s = String.valueOf(nums).substring(start);
            //防止0的加入
            if(!s.equals("0")){
                ans.append(s + ",");
            }
            if (n - start == nineCnt) start--;
            return;
        }
        for (char i : loop) {
            nums[x] = i; // 固定第 x 位为 i
            if (i == '9') nineCnt++;
            recur(x + 1, n);
        }
        //注意每次
        nineCnt--;
    }


    public int[] printNumbers1(int n) {
        int length = (int) Math.round(Math.pow(10, n));
        int[] nums = new int[length - 1];
        for (int i = 1; i < length; i++) {
            nums[i - 1] = i;
        }
        return nums;
    }

    public static void main(String[] args) {
        PrintNumbers17 printNumbers17 = new PrintNumbers17();
        //printNumbers17.printNumbers(3);
        System.out.println(Arrays.toString(printNumbers17.printNumbers(3)));
    }
}

package codeofli.leetcode.contest;

import java.util.Arrays;

public class MinimumNumbers5218 {
    public int minimumNumbers(int num, int k) {
        if (num == 0) {
            return 0;
        }
        int d = num % 10;
        for(int i = 1; i <= num; i++){
            int x = k* i;
            if(x > num){
                return -1;
            }
            if(x % 10 == d){
                return i;
            }
        }
        return -1;
    }

    int k;
    int cnt = -1;
    int num;

    public int minimumNumbers1(int num, int k) {
        this.k = k;
        this.num = num;
        if (num == 0) {
            return 0;
        }
        int[] tryNums = new int[num + 1];
        int i;
        for (i = 2; i <= num; i++) {
            Arrays.fill(tryNums, 0);
            recur(0, tryNums, i, num);
            if (cnt != -1) {
                return i;
            }
        }

        return -1;
    }

    private void recur(int tryCnt, int[] tryNums, int n, int num) {
        if (num < 0 || cnt != -1) {
            return;
        }
        if (tryCnt == n) {
            if (num == 0)
                cnt = n;
            return;
        }
        tryNums[tryCnt] = num - 10;
        if (tryNums[tryCnt] < 0) return;
        recur(tryCnt + 1, tryNums, n, num - tryNums[tryCnt]);
    }

    private int tryTwo(int num, int k) {
        int base = 10;
        while (num > base) {
            int x = num - base;
            x = x - x % 10 + k;
            int y = num - x;
            if (y % 10 == k) {
                return 2;
            }
            base += 10;
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumNumbers5218 minimumNumbers5218 = new MinimumNumbers5218();
        System.out.println(minimumNumbers5218.minimumNumbers(58, 9));
        System.out.println(minimumNumbers5218.minimumNumbers(7, 1));
    }
}

package codeofli.leetcode.contest.c311;

public class SmallestEvenMultiple {
    //1 <= n <= 150
    public int smallestEvenMultiple(int n) {
        if(n % 2 == 0){
            return n;
        }
        return n *2;
    }
}

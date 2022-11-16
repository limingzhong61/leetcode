package codeofli.leetcode.contest.old.c86;

public class IsStrictlyPalindromic6172 {
    //b 进制下（b 为 2 到 n - 2 之间的所有整数）
    public boolean isStrictlyPalindromic(int n) {
        for(int b = 2; b <= n-2; b++){
            String s = getN(n, b);
            for(int i = 0,j = s.length()-1; i < j; i++,j--){
                if(s.charAt(i) != s.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }

    public String getN(int n, int x) {
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            sb.append(n % x);
            n /= x;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IsStrictlyPalindromic6172 isStrictlyPalindromic6172 = new IsStrictlyPalindromic6172();
        System.out.println(isStrictlyPalindromic6172.getN(4, 2));
        System.out.println(isStrictlyPalindromic6172.isStrictlyPalindromic(4));
    }
}

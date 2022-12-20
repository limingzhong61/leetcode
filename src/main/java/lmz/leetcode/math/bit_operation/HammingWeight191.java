package lmz.leetcode.math.bit_operation;

public class HammingWeight191 {
    /**
     * leetcode:输入必须是长度为 32 的 二进制串 。
     */
    public int hammingWeight(int n) {

        int ans = 0;
        while(n != 0){
            n &= n-1;
            ans++;
        }
        return ans;
    }
    /**
     * leetcode:输入必须是长度为 32 的 二进制串 。
     */
    public int hammingWeight2(int n) {

        int ans = 0;
        for(int i = 0; i < 32; i++){
            if(((1<< 32) & n) != 0){
                ans++;
            }
        }
        return ans;
    }

    // my
    public int hammingWeight1(int n) {
        //System.out.println(n);
        String s = Integer.toBinaryString(n);
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        HammingWeight191 hammingWeight191 = new HammingWeight191();
        System.out.println(hammingWeight191.hammingWeight(-3));
    }
}

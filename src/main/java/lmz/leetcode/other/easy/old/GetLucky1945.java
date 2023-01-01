package lmz.leetcode.other.easy.old;

/**
 * @author: codeofli
 * @create: 2022-12-15 13:48
 */
public class GetLucky1945 {
    public int getLucky(String s, int k) {
        char[] cs = s.toCharArray();
        int total = 0;
        for (var c : cs) {
            int idx = c - 'a' + 1;
            total += idx / 10 + idx % 10;
        }
        for (int i = 1; i < k; i++) {
            int temp = total;
            int sum  = 0;
            while(total != 0){
                sum += total % 10;
                total /= 10;
            }
            total = sum;
            System.out.println(total);
        }
        return  total;
    }
}

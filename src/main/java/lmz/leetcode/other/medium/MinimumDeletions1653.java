package lmz.leetcode.other.medium;

/**
 * @author: limingzhong
 * @create: 2023-03-06 11:14
 */
public class MinimumDeletions1653 {
    public int minimumDeletions(String s) {
        int left = 0,right = s.length() - 1,cnt = 0;
        char[] cs = s.toCharArray();
        while(left < right){
            while(left < right && cs[right] == 'b'){
                right--;
            }
            while(left < right && cs[left] == 'a'){
                left++;
            }
            if(cs[left] != cs[right]){
                cnt++;
                char t = cs[right];
                cs[right] = cs[left];
                cs[left] = t;
            }

        }
        return cnt;
    }
}

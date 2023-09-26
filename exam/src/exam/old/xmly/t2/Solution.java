package exam.old.xmly.t2;

/**
 * @author: limingzhong
 * @create: 2023-09-24 19:37
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组 有序数组
     * @return int整型
     */
    public int removeDuplicates (int[] nums) {
        int start = nums[0];
        int cnt = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != start){
                start = nums[i];
                cnt++;
            }
        }
        return cnt;
    }
}

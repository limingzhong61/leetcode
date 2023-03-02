package lmz.leetcode.other.intro;

public class Rob198 {

    /**
     * leetcode状态：
     * maxRob[i]表示在抢劫前[0,i]的房屋时，所能抢劫到的最大值。
     * 状态转移方程：
     *      maxRob[i] = max(maxRob[i-1],nums[i]+maxRob[i-2])
     *
     * +++滚动数组优化
     */
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int length = nums.length;
        //初始
        int maxRob0 = nums[0];
        int maxRob1 = Math.max(nums[1],maxRob0);
        int maxRob2 = maxRob1;
        for(int i = 2; i < length; i++){
            maxRob2 = Math.max(maxRob1,nums[i]+maxRob0);
            maxRob0 = maxRob1;
            maxRob1 = maxRob2;
        }
        return maxRob2;
    }

    /**
     * leetcode状态：
     * maxRob[i]表示在抢劫前[0,i]的房屋时，所能抢劫到的最大值。
     * 状态转移方程：
     *      maxRob[i] = max(maxRob[i-1],nums[i]+maxRob[i-2])
     */
    public int rob2(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int length = nums.length;
        int[] maxRob = new int[length];
        //初始
        maxRob[0] = nums[0];
        maxRob[1] = Math.max(nums[1],maxRob[0]);
        for(int i = 2; i < length; i++){
            maxRob[i] = Math.max(maxRob[i-1],nums[i]+maxRob[i-2]);
        }
        return maxRob[length-1];
    }

    /**
     * my:
     * 状态：
     * rob[i]表示在抢劫前[0,i]的房屋时，所能抢劫到的值。
     * 状态转移方程：
     *      rob[i] = nums[i]+max(rob[0,i-2])
     * maxRob[i]，表示max(rob[0,i]);
     * 则rob[i] = rob[i]+maxRob[i-2]
     */
    public int rob1(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int length = nums.length;
        int[] rob = new int[length];
        int[] maxRob = new int[length];
        //初始
        rob[0] = nums[0];
        maxRob[0] = nums[0];
        rob[1] = nums[1];
        maxRob[1] = Math.max(nums[1],maxRob[0]);
        for(int i = 2; i < length; i++){
            rob[i] = nums[i] + maxRob[i-2];
            maxRob[i] = Math.max(maxRob[i-1],rob[i]);
        }
        return maxRob[length-1];
    }
}

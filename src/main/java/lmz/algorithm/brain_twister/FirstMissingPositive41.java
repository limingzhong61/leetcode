package lmz.algorithm.brain_twister;

/**
 * @author: limingzhong
 * @create: 2023-06-20 17:55
 */
public class FirstMissingPositive41 {

    /**
     * 原地hash：将数组视为哈希表
     *要找的数一定在 [1, N + 1] 左闭右闭（这里 N 是数组的长度）这个区间里
     * 就把 1这个数放到下标为 0 的位置，2这个数放到下标为 1的位置，按照这种思路整理一遍数组。然后我们再遍历一次数组，第 1个遇到的它的值不等于下标的那个数，就是我们要找的缺失的第一个正数。
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                if(nums[i] > n) continue; //超过n的数一定不是最小符合要求的
                if(i == nums[i] - 1 || nums[nums[i] - 1] == nums[i]) continue; // 不用交换
                // 交换 i 和 nums[i] - 1 两个位置的数
                // System.out.printf("%d,%d\n",nums[i],nums[nums[i] - 1]);
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
                i--;
            }
        }
        int start = 1;
        for(int i = 0; i < n; i++){
            if(nums[i] == start){
                start++;
            } else{
                return start;
            }
        }
        return n+1;
    }
}

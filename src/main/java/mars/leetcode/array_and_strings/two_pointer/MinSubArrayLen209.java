package mars.leetcode.array_and_strings.two_pointer;

public class MinSubArrayLen209 {
    /**
     * 滑动窗口
     */
    public int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;
        int sum = 0;
        int minLength = n + 1;
        for (int i = 0, j = 0; i <= j; ) {
            //符合条件
            if (sum >= target) {
                int length = j - i;
                minLength = Math.min(length, minLength);
                sum -= nums[i];
                i++;
            }else{ //sum < target
                if(j == n){ //j已经到边界了，不能再添加了
                    break;
                }
                sum += nums[j];
                j++;
            }
        }
        return minLength == n+1 ? 0 : minLength;
    }

    public static void main(String[] args) {
        MinSubArrayLen209 minSubArrayLen209 = new MinSubArrayLen209();
        System.out.println(minSubArrayLen209.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen209.minSubArrayLen(4, new int[]{1,4,4}));
        System.out.println(minSubArrayLen209.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
    }
}

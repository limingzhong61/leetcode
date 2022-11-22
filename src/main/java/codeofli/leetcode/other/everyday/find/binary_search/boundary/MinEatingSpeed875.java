package codeofli.leetcode.other.everyday.find.binary_search.boundary;

import codeofli.my.leetcode.TransformUtil;

public class MinEatingSpeed875 {
    /**
     * 找到false，true的true的最小（右边界）
     * @param piles
     * @param h
     * @return
     */
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 1000000000;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(check(piles,mid,h)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean check(int[] piles,int x,int h) {
        int n = piles.length;
        int sum = 0;
        for (int pile : piles) {
            int need = pile / x;
            // 向上取整
            if (pile % x != 0) {
                need++;
            }
            sum += need;
            if (sum > h) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinEatingSpeed875 minEatingSpeed875 = new MinEatingSpeed875();
        System.out.println(minEatingSpeed875.minEatingSpeed(TransformUtil.toIntArray("[3,6,7,11]"), 8));
    }

}

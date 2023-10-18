package com.lmz.algorithm_practice.find.binary_search;

public class FirstBadVersion278 {
    /**
     * isBadVersion(mid) 是true是错误的版本
     */
    public int firstBadVersion(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                low = mid + 1;
            } else  {
                high = mid - 1;
            }
        }
        return low;
    }

    private boolean isBadVersion(int i) {
        boolean[] res = new boolean[]{false,true,true,true,false,false};
        return  res[i];
    }

    public static void main(String[] args) {
        FirstBadVersion278 firstBadVersion278 = new FirstBadVersion278();
        System.out.println(firstBadVersion278.firstBadVersion(5));
    }

}

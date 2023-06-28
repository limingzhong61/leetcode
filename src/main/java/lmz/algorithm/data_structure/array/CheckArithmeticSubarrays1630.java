package lmz.algorithm.data_structure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckArithmeticSubarrays1630 {
    /**
     * 因为数组长度范围很小，故直接暴力检查
     *O(n*nlogn)
     *
     * n == nums.length
     * m == l.length == r.length
     * 2 <= n <= 500
     * 1 <= m <= 500
     */
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int m = l.length;
        List<Boolean> res = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int[] copy = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(copy);
            int left = 0,right = r[i] - l[i];
            int dist = copy[left+ 1]- copy[left];
            boolean check = true;
            for(int j = left + 2; j <= right; j++){
                if(dist != copy[j] - copy[j-1]){
                    check = false;
                    break;
                }
            }
            res.add(check);
        }
        return  res;
    }
}

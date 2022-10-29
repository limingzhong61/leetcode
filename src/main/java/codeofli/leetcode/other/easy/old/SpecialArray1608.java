package codeofli.leetcode.other.easy.old;

public class SpecialArray1608 {
    public int specialArray(int[] nums) {
        for(int x = 0; x  <= nums.length; x++){
            int cnt = 0;
            for(int item : nums){
                if(item >= x){
                    cnt++;
                }
            }
            if(cnt == x){
                return x;
            }
        }
        return -1;
    }
}

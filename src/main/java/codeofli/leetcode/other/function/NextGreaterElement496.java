package codeofli.leetcode.other.function;

public class NextGreaterElement496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //1 <= nums1.length <= nums2.length <= 1000
        int m = nums1.length,n = nums2.length;
        int[] res = new int[m];
        for(int i = 0; i <m; i++){
            int x = nums1[i];
            res[i] = -1;
            for(int j = 0; j <m; j++){
                if(nums2[j] == x){
                    for(int k = j+1; k < m; k++){
                        if(nums2[k] > x){
                            res[i] = nums2[k];
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return res;
    }
}

package codeofli.leetcode.other.loop;

import java.util.Arrays;

public class CanMakeArithmeticProgression1502 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        //2 <= arr.length <= 1000
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i =2; i < arr.length; i++) {
            if(diff != arr[i] - arr[i-1]){
                return false;
            }
        }
        return true;
    }
}

package com.lmz.algorithm_practice.other.easy.old;

public class CanFormArray1640 {
    /**
     * arr 中的整数 互不相同
     * pieces 中的整数 互不相同（也就是说，如果将 pieces 扁平化成一维数组，数组中的所有整数互不相同）
     */
    public boolean canFormArray(int[] arr, int[][] pieces) {
        //1 <= pieces.length <= arr.length <= 100
        int arrLen = arr.length;
        int i = 0;
        for(i = 0; i < arrLen;){
            boolean find = false;
            for (int[] piece : pieces) {
                if (piece[0] == arr[i]) {
                    for (int j : piece) {
                        if (j == arr[i]) {
                            i++;
                            if(i == arrLen){
                                break;
                            }
                        }
                    }
                    find = true;
                    break;
                }
            }
            if(!find){
                return false;
            }
        }
        return i == arrLen;
    }
}

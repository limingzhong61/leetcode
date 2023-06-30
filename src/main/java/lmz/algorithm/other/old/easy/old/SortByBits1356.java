package lmz.algorithm.other.old.easy.old;

import lmz.my.leetcode.TransformUtil;

import java.util.Arrays;

public class SortByBits1356 {
    /**
     *二维数组排序
     */
    public int[] sortByBits(int[] arr) {
        int[][] a = new int[arr.length][2];
        for(int i = 0; i < arr.length; i++){
            a[i][0] = arr[i];
            a[i][1] = countOneBitInNum(arr[i]);
        }
        Arrays.sort(a, (a1, a2) -> {
            if(a1[1] == a2[1]){
                return a1[0] - a2[0];
            }
            return a1[1] - a2[1];
        });
        for(int i = 0; i < arr.length; i ++){
            arr[i] = a[i][0];
        }
        return arr;
    }

    private int countOneBitInNum(int x) {
        int cnt = 0;
        while(x != 0){
            cnt += x & 1;
            x >>= 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        SortByBits1356 sortByBits1356 = new SortByBits1356();
        System.out.println(Arrays.toString(sortByBits1356.sortByBits(TransformUtil.toIntArray("[0,1,2,3,4,5,6,7,8]"))));
        System.out.println(Arrays.toString(sortByBits1356.sortByBits(TransformUtil.toIntArray("[1024,512,256,128,64,32,16,8,4,2,1]"))));
        System.out.println(Arrays.equals(sortByBits1356.sortByBits(TransformUtil.toIntArray("[1024,512,256,128,64,32,16,8,4,2,1]"))
                , TransformUtil.toIntArray("[1,2,4,8,16,32,64,128,256,512,1024]")));
    }
}

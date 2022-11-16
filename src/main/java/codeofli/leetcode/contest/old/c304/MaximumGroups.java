package codeofli.leetcode.contest.old.c304;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumGroups {
    /**
     * 1 <= grades.length <= 10^5
     * 1 <= grades[i] <= 10^5
     */
    public int maximumGroups(int[] grades) {
        Arrays.sort(grades);
        int n = grades.length;
        int res = 1;
        int stuTotal = 2;
        boolean[] mark = new boolean[n];
        mark[n-1] = true;
        int nowSum = grades[n-1];
        //while(true){
        //    int pickCnt = 0;
        //    int pickSum = grades[n-stuTotal];
        //    for(int i = 0; i < n; i++){
        //        if(!mark[i]){
        //            pickSum += grades[i];
        //            mark[i] = true;
        //            pickCnt++;
        //            if(pickCnt == stuTotal-1){
        //                //Arrays.binarySearch()
        //            }
        //            if(pickCnt == stuTotal){
        //                break;
        //            }
        //        }
        //    }
        //}
        //for(int i = 0; i < n; i++){
        //
        //}
        return 0;
    }
}

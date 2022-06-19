package codeofli.leetcode.graph_parse_ds.math;

import codeofli.my.leetcode.TransformString;

import java.util.*;

public class FindContinuousSequence57II {
    /**
     * leetcode:双指针
     * 维护一个[left,right]连续数组
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int left = 1, right = 2;
        while (left < right) {
            int sum = (left + right) * (right - left + 1) / 2;
            if (sum == target) {
                int[] temp = new int[right - left + 1];
                for (int i = 0; i < right - left + 1; i++) {
                    temp[i] = left + i;
                }
                res.add(temp);
                left ++;
            }else if(sum < target){
                right++;
            }else {
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    /**
     * 模拟计算
     */
    public int[][] findContinuousSequence1(int target) {
        List<int[]> res = new ArrayList<>();
        //cnt能分的数目
        for (int cnt = 2; cnt < target; cnt++) {
            int midNum = target / cnt;
            int half = cnt / 2;
            //起点为start-half,或者start-half+1 两者可能
            int start = midNum - half;

            if (start + 1 <= 0) {
                break;
            }
            checkAndAdd(target, res, cnt, start + 1);
            if (start <= 0) {
                break;
            }
            checkAndAdd(target, res, cnt, start);
        }
        Collections.reverse(res);
        return res.toArray(new int[res.size()][]);
    }

    private void checkAndAdd(int target, List<int[]> res, int cnt, int start) {
        int sum = 0;
        int[] temp = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            sum += start + i;
            temp[i] = start + i;
        }
        if (sum == target) {
            res.add(temp);
        }
    }

    public static void main(String[] args) {
        FindContinuousSequence57II findContinuousSequence = new FindContinuousSequence57II();

        System.out.println(TransformString.matrixToStr(findContinuousSequence.findContinuousSequence(9)));
        System.out.println(TransformString.matrixToStr(findContinuousSequence.findContinuousSequence(9))
                .equals("[[2,3,4],[4,5]]"));

        System.out.println(TransformString.matrixToStr(findContinuousSequence.findContinuousSequence(15)));
        System.out.println(TransformString.matrixToStr(findContinuousSequence.findContinuousSequence(15))
                .equals("[[1,2,3,4,5],[4,5,6],[7,8]]"));

        System.out.println(TransformString.matrixToStr(findContinuousSequence.findContinuousSequence(10)));
        System.out.println(TransformString.matrixToStr(findContinuousSequence.findContinuousSequence(10))
                .equals("[[1,2,3,4]]"));
    }


}

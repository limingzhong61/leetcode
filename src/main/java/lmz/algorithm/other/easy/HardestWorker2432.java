package lmz.algorithm.other.easy;

/**
 * @author: limingzhong
 * @create: 2023-05-05 11:56
 */
public class HardestWorker2432 {
    class Solution {
        public int hardestWorker(int n, int[][] logs) {
            int startTime = 0,resId = n+1,maxLen = 0;
            for(int i = 0; i < logs.length; i++){
                int len = logs[i][1] - startTime;
                startTime = logs[i][1];
                if(len > maxLen){
                    maxLen = len;
                }
            }

            startTime = 0;
            for(int i = 0; i < logs.length; i++){
                int len = logs[i][1] - startTime;
                startTime = logs[i][1];
                if(len == maxLen){
                    resId = Math.min(resId,logs[i][0]);
                }
            }
            return resId;
        }
    }
    class Solution1 {
        public int hardestWorker(int n, int[][] logs) {
            int startTime = 0,resId = n+1,maxLen = 0;
            for(int i = 0; i < logs.length; i++){
                int len = logs[i][1] - startTime;
                startTime = logs[i][1];
                if(len > maxLen){
                    maxLen = len;
                }
            }

            startTime = 0;
            for(int i = 0; i < logs.length; i++){
                int len = logs[i][1] - startTime;
                startTime = logs[i][1];
                if(len == maxLen){
                    resId = Math.min(resId,logs[i][0]);
                }
            }
            return resId;
        }
    }
}

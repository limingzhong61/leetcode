package lmz.algorithm.other.old.easy.old;

/**
 * @author: codeofli
 * @create: 2022-11-22 10:05
 */
public class SumOddLengthSubarrays1588 {
    /**
     * 计算idx位置的数组有多少个奇数长度的位置：要为奇数长度，左右两边要么都是奇数，要么都是偶数：
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int leftCount = i, rightCount = n - i - 1;
            int leftOdd = (leftCount + 1) / 2;
            int rightOdd = (rightCount + 1) / 2;
            int leftEven = leftCount / 2 + 1;
            int rightEven = rightCount / 2 + 1;
            sum += arr[i] * (leftOdd * rightOdd + leftEven * rightEven);
        }
        return sum;
    }

    public int sumOddLengthSubarrays1(int[] arr) {
        int n = arr.length,res = 0;
        for(int len = 1; len <= n; len +=2) {
            int temp = 0;
            for(int i = 0; i < len; i++){
                temp += arr[i];
            }
            res += temp;
            for(int i = len; i < n; i++){
                temp = temp - arr[i - len] + arr[i];
                res += temp;
            }
        }
        return res;
    }
}

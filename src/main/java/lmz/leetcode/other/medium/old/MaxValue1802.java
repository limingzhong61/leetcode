package lmz.leetcode.other.medium.old;

public class MaxValue1802 {
    /**
     * lc简化计算sum
     */
    public int maxValue(int n, int index, int maxSum) {
        long l = 0, r = maxSum;
        //因为数组中所有的数均为正整数，所以减去n，剩余的表示可以填的数
        maxSum -= n;
        while(l<r){
            //m表示index指向位置的高度
            long m = l+r+1>>1;

            //计算当index的位置高度为m时，数组所有元素的和
            long count = m*m;
            //如果左边越界，就减去左边多的
            if(m>index) count -= (m-index-1)*(m-index)/2;
            //如果右边越界，就减去右边多的
            if(m>(n-index)) count -= (m-(n-index-1)-1)*(m-(n-index-1))/2;

            //二分法判断
            if(count>maxSum) r = m-1;
            else l = m;
        }
        return (int)l+1;
    }
    /**
     * 二分查找：
     * left - right
     * true,false, 左边界
     */
    public int maxValue1(int n, int index, int maxSum) {
        int left = 1, right = maxSum;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(n, index, maxSum, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private boolean check(int n, int index, int maxSum, int x) {
        int leftLen = index, rightLen = n - index - 1;
        long need = x;
        int leftFillLen = Math.min(leftLen,x -1);
        int rightFillLen = Math.min(rightLen,x -1);
        if (leftLen > x - 1) {
            need += (long) x * (x - 1) / 2;
        } else {
            need += (long) leftLen * (x - 1 + x - leftLen) / 2;
        }
        if (rightLen > x - 1) {
            need += (long) x * (x - 1) / 2;
        } else {
            need += (long) rightLen * (x - 1 + x - rightLen) / 2;
        }
        if (leftFillLen + rightFillLen + 1 < n) {
            need += n - leftFillLen - rightFillLen - 1;
        }
        return need <= maxSum;
    }

    public static void main(String[] args) {
        MaxValue1802 maxValue1802 = new MaxValue1802();
        //testCase(maxValue1802, 3, 2, 18, 7);
        testCase(maxValue1802, 4, 0, 4, 1);
    }

    private static void testCase(MaxValue1802 maxValue1802, int n, int index, int maxSum, int x) {
        System.out.println(maxValue1802.maxValue(n, index, maxSum));
        System.out.println(maxValue1802.maxValue(n, index, maxSum) == x);
    }
}

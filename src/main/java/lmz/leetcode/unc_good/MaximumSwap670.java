package lmz.leetcode.unc_good;

public class MaximumSwap670 {
    public int maximumSwap(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int n = charArray.length;
        int maxIdx = n - 1;
        int idx1 = -1, idx2 = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (charArray[i] > charArray[maxIdx]) {
                maxIdx = i;
            } else if (charArray[i] < charArray[maxIdx]) {
                idx1 = i;
                idx2 = maxIdx;
            }
        }
        if (idx1 >= 0) {
            swap(charArray, idx1, idx2);
            return Integer.parseInt(new String(charArray));
        } else {
            return num;
        }
    }

    public void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

    /**
     * 贪心：
     * 贪心法一句话总结：每一位数字应该不小于所有排它后面的数字，否则找最大的且排最后面的数字与之交换
     * 找到最左边最大的数字和第一位交换，
     */
    public int maximumSwap1(int num) {
        int[] digits = getNumberDigitArray(num);
        int n = digits.length;
        for (int i = 0; i < n; i++) {
            int maxIdx = n - 1;
            for (int j = n - 2; j >= i; j--) {
                if (digits[j] > digits[maxIdx]) {
                    maxIdx = j;
                }
            }
            if (digits[maxIdx] != digits[i]) {
                swap(digits, maxIdx, i);
                break;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = res * 10 + digits[i];
        }
        return res;
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    /**
     * @return 返回自然数的每一位数字形成的数组
     */
    public static int[] getNumberDigitArray(int num) {
        //int 最多十位
        int[] nums = new int[11];
        //获取每一位的数字
        int index = 0;
        //获取数字位数，用do-while,防止0的情况
        do {
            nums[index++] = num % 10;
            num /= 10;
        } while (num != 0);
        int[] res = new int[index];
        for(int i = 0; i < res.length ; i++){
            res[i] = nums[--index];
        }
        return res;
    }
}

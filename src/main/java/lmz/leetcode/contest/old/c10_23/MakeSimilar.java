package lmz.leetcode.contest.old.c10_23;

import lmz.leetcode.bruce_solution.bruce_search.my.leetcode.TransformUtil;

import java.util.Arrays;

/**
 * @author: codeofli
 * @create: 2022-10-23 10:59
 */
public class MakeSimilar {
    /**
     * 测试数据保证 nums 一定能变得与 target 相似
     */
    public long makeSimilar(int[] nums, int[] target) {
        Arrays.sort(nums);
        Arrays.sort(target);
        int n = nums.length;
        int targetStart = 0;
        long operatorVal = 0;
        var used = new boolean[n];
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target[targetStart]) {
                used[targetStart] = true;
                targetStart++;
            } else {
                while(targetStart < n && used[targetStart]){
                    targetStart++;
                }
                // find next can be val for nums[i];
                for (int j = targetStart; j < n; j++) {
                    if (!used[j] && (target[j] - nums[i]) % 2 == 0) {
                        int now = target[j] - nums[i];
                        if(now > 0 && operatorVal < 0 || now < 0 && operatorVal > 0){
                            if(Math.abs(operatorVal) >= Math.abs(now)){
                                operatorVal += now;
                            }else{
                                operatorVal += now;
                                res += Math.abs(operatorVal) /  2;
                            }

                        }else{
                            res += Math.abs(now) / 2;
                            operatorVal += now;
                        }
                        used[j] = true;
                        nums[i] = target[j];
                        System.out.println(operatorVal);
                        System.out.println(res);
                        System.out.println(Arrays.toString(nums));
                        System.out.println(Arrays.toString(target));
                        System.out.println("------------");
                        break;
                    }
                }
            }
        }
        System.out.println(operatorVal);
        return res;
    }

    public static void main(String[] args) {
        MakeSimilar makeSimilar = new MakeSimilar();
        //testCase(makeSimilar, "[8,12,6]", "[2,14,10]", 2);
        //testCase(makeSimilar, "[758,334,402,1792,1112,1436,1534,1702,1538,1427,720,1424,114,1604,564,120,578]",
        //        "[1670,216,1392,1828,1104,464,678,1134,644,1178,1150,1608,1799,1156,244,2,892]", 645);
        testCase(makeSimilar, "[369,691,379,191,333,595,187,800,161,97,436,488,505,313,89,943,91,875,672,71,854,936,570,813,363,987,359,269,439,899,961,112,986,848,792,775,13,298,490,715,541,967,964,179,767,278,845,223,305,603,407,745,260,533,795,629,609,53,781,365,782,674,525,985,55,940,525,753,805,659,642,593,911,871,556,517,863,839,767,291,723,676,213,650,627,716,373,55,889,437,507,950,615,13,417,109]",
                "[577,510,653,833,676,459,45,194,597,55,623,999,941,127,751,891,167,959,391,967,567,41,669,781,569,999,864,263,801,909,946,37,203,814,855,799,225,261,205,851,833,999,301,720,987,146,187,154,359,839,977,38,714,163,903,169,756,841,982,432,281,66,67,637,269,303,880,235,127,301,407,969,645,589,941,899,758,768,469,690,225,528,463,234,466,561,953,520,978,651,243,443,143,773,839,242]",
                1446);
    }

    private static void testCase(MakeSimilar makeSimilar, String original, String original1, int x) {
        System.out.println(makeSimilar.makeSimilar(TransformUtil.toIntArray(original)
                , TransformUtil.toIntArray(original1)));
        System.out.println(makeSimilar.makeSimilar(TransformUtil.toIntArray(original)
                , TransformUtil.toIntArray(original1)) == x);
    }

    /**
     * 测试数据保证 nums 一定能变得与 target 相似
     */
    public long makeSimilar1(int[] nums, int[] target) {
        Arrays.sort(nums);
        Arrays.sort(target);
        int n = nums.length;
        int left = 0, right = n - 1;
        long res = 0;
        while (left < right) {
            while (left < right && nums[left] == target[left]) {
                left++;
            }
            while (left < right && nums[right] == target[right]) {
                right--;
            }
            int leftDiff = nums[left] - target[left]; //左边一定更大
            int rightDiff = target[right] - nums[right]; //右边一定更小
            if (leftDiff < rightDiff) {
                res += leftDiff;
                nums[left] = target[left];
                nums[right] = nums[right] + leftDiff;
            } else { // leftDiff bigger
                res += rightDiff;
                nums[left] = target[left] + rightDiff;
                nums[right] = target[right];
            }

        }
        return res;
    }
}

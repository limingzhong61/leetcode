package codeofli.leetcode.other.easy;

import codeofli.my.leetcode.TransformUtil;

import java.util.Arrays;

public class ThreeEqualParts927 {
    /**
     * 1的个数必须是3的整数倍 将1等分成3份 ；
     * 再根据最后一份末尾0的个数推导 前两份的最后一个坐标，最后判断3份去掉前导0 是不是一样
     */
    public int[] threeEqualParts(int[] arr) {
        //3 <= arr.length <= 3 * 104
        int n = arr.length;
        int cntOne = 0;
        for (int x : arr) {
            if (x == 1) {
                cntOne++;
            }
        }
        if (cntOne == 0) { // 全部都是0的情况，随便分，不越界就行;
            return new int[]{0, n - 1};
        }
        int needOne = cntOne / 3;
        // 1 不能3等分
        if (needOne * 3 != cntOne) {
            return new int[]{-1, -1};
        }

        //找打i,j
        int needLastOne = 0;
        int endOne3 = n - 1;      //第3部分的最后一个1
        for (; endOne3 >= 0; endOne3--) {
            if (arr[endOne3] != 0) {
                break;
            }
            needLastOne++;
        }
        // 100...
        int cntNeedOne = needOne;
        //startOne3, 第三部分开始的1
        int startOne3 = endOne3;
        for (; startOne3 >= 0; startOne3--) {
            if (arr[startOne3] == 1) {
                cntNeedOne--;
                if (cntNeedOne == 0) {
                    break;
                }
            }
        }
        //第二部分[i+1,j-1]
        int endOne2 = startOne3 - 1; //第二个部分的最后一个1
        for (; endOne2 >= 0; endOne2--) {
            if (arr[endOne2] != 0) {
                break;
            }
        }
        int findJ = startOne3 - 1;
        //中间0的数量
        int cntZero = startOne3 - endOne2 - 1;
        if (cntZero < needLastOne) {
            return new int[]{-1, -1};
        } else { //中间0的数量是足够的
            int extraOne = cntZero - needLastOne; //补充第二部分多余的0
            findJ = startOne3 - extraOne; //补充划分后后面的0
        }

        // 找到j了,[0,i]
        int startOne2 = endOne2;
        cntNeedOne = needOne;  //重置需要1的个数
        for (; startOne2 >= 0; startOne2--) {
            if (arr[startOne2] == 1) {
                cntNeedOne--;
                if (cntNeedOne == 0) {
                    break;
                }
            }
        }
        int endOne1 = startOne2 - 1; //第1部分的最后一个1
        for (; endOne1 >= 0; endOne1--) {
            if (arr[endOne1] != 0) {
                break;
            }
        }
        int findI = startOne2 - 1;
        //中间0的数量
        cntZero = startOne2 - endOne1 - 1;
        if (cntZero < needLastOne) {
            return new int[]{-1, -1};
        } else { //中间0的数量是足够的
            int extraOne = cntZero - needLastOne; //补充第二部分多余的0
            findI = startOne2 - extraOne; //补充划分后后面的0
        }
        // 以为i是第一部分结尾；则i
        findI--;
        // 找到i了,[0,i]
        int startOne1 = endOne1;
        cntNeedOne = needOne;  //重置需要1的个数
        for (; startOne1 >= 0; startOne1--) {
            if (arr[startOne1] == 1) {
                cntNeedOne--;
                if (cntNeedOne == 0) {
                    break;
                }
            }
        }
        //compare
        if (Arrays.compare(arr, startOne1, endOne1 + 1, arr, startOne2, endOne2 + 1) != 0
                || Arrays.compare(arr, startOne1, endOne1 + 1, arr, startOne3, endOne3 + 1) != 0) {
            return new int[]{-1, -1};
        }
        return new int[]{findI, findJ};
    }

    public static void main(String[] args) {
        ThreeEqualParts927 threeEqualParts927 = new ThreeEqualParts927();
        //System.out.println(Arrays.toString(threeEqualParts927.threeEqualParts(TransformUtil.toIntArray("[1,0,1,0,1]"))));
        //System.out.println(Arrays.toString(threeEqualParts927.threeEqualParts(TransformUtil.toIntArray("[1,1,0,1,1]"))));
        testCase(threeEqualParts927, "[1,1,0,0,1]", "[0, 2]");
        testCase(threeEqualParts927, "[0,0,0,0,0]", "[0,4]");
        testCase(threeEqualParts927, "[0,0,0,1,0,1,1,0,1,1,1,0,0,1,0,1,1]", "[-1,-1]");
    }

    private static void testCase(ThreeEqualParts927 threeEqualParts927, String original, String original1) {
        System.out.println(Arrays.toString(threeEqualParts927.threeEqualParts(TransformUtil.toIntArray(original))));
        System.out.println(Arrays.equals(threeEqualParts927.threeEqualParts(TransformUtil.toIntArray(original)),
                TransformUtil.toIntArray(original1)));
    }

}

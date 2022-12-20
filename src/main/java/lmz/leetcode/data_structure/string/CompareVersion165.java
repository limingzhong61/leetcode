package lmz.leetcode.data_structure.string;

public class CompareVersion165 {
    /**
     * version1 和 version2 仅包含数字和 '.'
     * version1 和 version2 都是 有效版本号
     * version1 和 version2 的所有修订号都可以存储在 32 位整数 中
     */
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int i,j;
        for ( i = 0, j = 0; i < split1.length || j < split2.length; i++, j++) {
            int a = i < split1.length ? Integer.parseInt(split1[i]) : 0;
            int b = j < split2.length ? Integer.parseInt(split2[j]) : 0;
            if (a != b) {
                return a - b > 0 ? 1 : -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("0001"));
    }
}

package codeofli.leetcode.array_and_strings.summary;

import java.util.ArrayList;
import java.util.List;

public class GetRow119 {

    /**
     * leetcode:递推公式
     *
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>(rowIndex + 1);
        ans.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            ans.add(i, (int) ((long) ans.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return ans;
    }

    /**
     * leetcode:滚动数组：优化为用一个
     * 当前行第 i 项的计算只与上一行第 i−1 项及第 i 项有关。因此我们可以倒着计算当前行，这样计算到第 i 项时，第 i−1 项仍然是上一行的值。
     */
    public List<Integer> getRow2(int rowIndex) {
        int[] rows = new int[rowIndex + 1];
        rows[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            //(1,i-1)符合,倒着推
            for (int j = i; j > 0; j--) {
                rows[j] += rows[j - 1];
            }
            rows[i] = 1;
        }
        List<Integer> ans = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++) {
            ans.add(rows[i]);
        }
        return ans;
    }

    /**
     * my:滚动数组：用了两个数组
     */
    public List<Integer> getRow1(int rowIndex) {
        List<Integer> last = new ArrayList<>();

        //第一个为0
        last.add(1);
        if (rowIndex == 0) {
            return last;
        }
        List<Integer> now = null;
        for (int i = 1; i <= rowIndex; i++) {
            now = new ArrayList<>();
            now.add(1);
            //(1,i-1)符合
            for (int j = 1; j < i; j++) {
                now.add(last.get(j - 1) + last.get(j));
            }
            now.add(1);
            last = now;
        }
        return now;
    }

    public static void main(String[] args) {
        GetRow119 getRow119 = new GetRow119();

        System.out.println(getRow119.getRow(3));
        System.out.println(getRow119.getRow(0));
        System.out.println(getRow119.getRow(1));
        //System.out.println(getRow119.getRow(3));
    }
}

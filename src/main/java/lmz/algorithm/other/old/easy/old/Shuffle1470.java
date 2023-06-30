package lmz.algorithm.other.old.easy.old;

public class Shuffle1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        int index = 0;
        for (int i = 0, j = n; i < n && j < 2 * n; i++, j++) {
            res[index++] = nums[i];
            res[index++] = nums[j];
        }
        return res;
    }
}

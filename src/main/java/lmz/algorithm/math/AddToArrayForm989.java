package lmz.algorithm.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayForm989 {
    /**
     * 因为整个加法都不会溢出，则逐个按位相加即可
     * 1 <= k <= 10^4
     */
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>(num.length);
        int carry = 0;
        for (int i = num.length - 1; i >= 0 || carry > 0 || k > 0; i--) {
            int  x = i >= 0 ? num[i] : 0;
            int sum = x + carry + k % 10;
            carry = sum / 10;
            res.add(sum % 10);
            k /= 10;
        }
        Collections.reverse(res);
        return res;
    }
}

package lmz.algorithm.other.easy.old;

import java.util.Deque;
import java.util.LinkedList;

public class FinalPrices1475 {
    /**
     * 单调栈：找到下一个比当前元素小的值
     */
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        Deque<Integer> stack = new LinkedList<>();

        for (int i = n - 1; i >= 0; i--) {
            int prePrice = prices[i];
            // 将比当前元素更大的值出栈，这样形成出栈顺序是升序。
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.poll();
            }
            if (!stack.isEmpty()) {
                prices[i] = prePrice - stack.peek();
            }
            stack.push(prePrice);
        }
        return prices;
    }

    public int[] finalPrices1(int[] prices) {
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }
        return prices;
    }
}

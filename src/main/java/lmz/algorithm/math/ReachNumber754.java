package lmz.algorithm.math;

/**
 * @author: codeofli
 * @create: 2022-11-04 9:59
 */
public class ReachNumber754 {
    /**
     *lc: 分类讨论
     *
     */
    public int reachNumber(int target) {
        target = Math.abs(target);
        int s = 0,n = 0;
        while(s < target || (s - target) % 2 != 0){ // 没有到达（越过）终点，或者相距奇数
            s += ++n;
        }
        return n;
    }
}

package lmz.algorithm.other.easy.old;

/**
 * @author: codeofli
 * @create: 2022-10-27 9:15
 */
public class ArraySign1822 {
    public int arraySign(int[] nums) {
        int product = 1;
        for(int x : nums){
            product *= x;
        }
        if(product == 0){
            return 0;
        }
        return product > 0 ? 1 : -1;
    }
}

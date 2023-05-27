package lmz.algorithm.other.easy.old;

/**
 * @author: codeofli
 * @create: 2022-12-23 10:17
 */
public class FinalValueAfterOperations2011 {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(var s : operations){
            if(s.startsWith("++") || s.endsWith("++")){
                x++;
            }else{
                x--;
            }
        }
        return x;
    }
}

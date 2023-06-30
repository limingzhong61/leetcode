package lmz.algorithm.other.old.easy.old;

/**
 * @author: codeofli
 * @create: 2022-11-02 20:49
 */
public class BestCoordinate1620 {
    /**
     * 枚举
     */
    public int[] bestCoordinate(int[][] towers, int radius) {
        int max = 0;
        int[] res = new int[2];
        //0 <= xi, yi, qi <= 50
        for (int x = 0; x <= 50; x++) {
            for (int y = 0; y <= 50; y++) {
                int q = 0;
                for (int[] tower : towers) {
                    double d = Math.sqrt((x - tower[0]) * (x - tower[0]) + (y - tower[1]) * (y - tower[1]));
                    if(d <= radius){
                        q += Math.floor((tower[2]) / ( 1 + d));
                    }
                }
                // System.out.printf("x=%d,y=%d,q=%d\n",x,y,q);
                if(q > max){
                    res = new int[]{x,y};
                    max = q;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}

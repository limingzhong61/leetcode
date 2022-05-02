package mars.my.matrix;

public class Matrix {
    /**
     *
     * @param a n*n
     */
   public static void Transposition(int[][] a){
       int length = a.length;
       for(int i = 0; i < length; i++){
           for(int j = 0; j < i; j++){
               int temp = a[i][j];
               a[i][j] = a[j][i];
               a[j][i] = temp;
           }
       }
   }
}

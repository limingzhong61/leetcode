package exam.old.txm.t1;




public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param n int整型
     * @return int整型
     */
    public int fun (int n) {
        // write code here
        char[] cs = String.valueOf(n).toCharArray();
        int cnt = 0;
        for(int i = cs.length - 1; i >= 0; i--){
            if(cs[i] == '5' || cs[i] == '0'){
                return cnt;
            }else{
                cnt++;
            }
        }
        return cnt;
    }
}

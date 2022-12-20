package lmz.leetcode.data_structure.string;

public class BalancedStringSplit1221 {
    // 感觉这个也挺像括号匹配的, 不过这里的 L 和 R 并没有左右前后之分
    // 这样我们可以用一个'平衡因子'变量: balance_factor 来表示当前 L 和 R 的数量差
    // 因为题目中提供的字符串本身就是个平衡的字符串, 所以我们才可以使用贪心的思想, 我已经有了非常完美优雅的证明, 但这地方太小写不下, 我就不写了
    // 我们'贪心'地从左往右扫描字符串:
    // 遇到L就给 balance_factor 加1
    // 遇到R就给 balance_factor 减1
    // 当 balance_factor 为0时, 就表示当前成功分割出了一个平衡字符串
    public int balancedStringSplit(String s) {
        int balanceFactor = 0;
        int res = 0;
        for(int i = 0; i <s.length(); i++){
            if(s.charAt(i) == 'L'){
                balanceFactor++;
            }else{
                balanceFactor--;
            }
            if(balanceFactor == 0){
                res++;
            }
        }
        return res;
    }
}

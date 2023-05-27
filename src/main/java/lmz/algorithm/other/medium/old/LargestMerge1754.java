package lmz.algorithm.other.medium.old;

/**
 * @author: codeofli
 * @create: 2022-12-24 18:39
 */
public class LargestMerge1754 {
    public String largestMerge(String word1, String word2) {
        int len1 = word1.length(),len2 = word2.length();
        char[] cs1 = word1.toCharArray(),cs2 = word2.toCharArray();
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while(i < len1 && j < len2){
            if(cs1[i] > cs2[j]){
                sb.append(cs1[i]);
                i++;
            }else if(cs1[i] < cs2[j]){
                sb.append(cs2[j]);
                j++;
            }else{ // ==
                int i1 = i,j1 = j;
                boolean add = false;
                while(i1 < len1 && j1 < len2){
                    if(cs1[i1] > cs2[j1]){
                        sb.append(cs1[i++]);
                        add = true;
                        break;
                    }else if(cs1[i1] < cs2[j1]){
                        sb.append(cs2[j++]);
                        add = true;

                        break;
                    }else{ // ==
                        i1++;
                        j1++;
                    }
                }
                if(!add){
                    if(i1 < len1){
                        sb.append(cs1[i++]);
                    }else{
                        sb.append(cs2[j++]);
                    }
                }
            }
            // System.out.printf("i=%d,j=%d\n",i,j);
        }
        while(i < len1){
            sb.append(cs1[i++]);
        }
        while(j < len2){
            sb.append(cs2[j++]);
        }
        return sb.toString();
    }
}

//package lmz.leetcode.other.medium.exam.old;
//
//import java.util.*;
//
///**
// * @author: limingzhong
// * @create: 2023-02-08 9:37
// */
//public class RemoveSubfolders1233 {
//    public List<String> removeSubfolders(String[] folder) {
//        Trie trie = new Trie();
//        List<String> ans = new ArrayList<String>();
//        for(int i = 0; i < folder.length;i++){
//            trie.insert(folder[i],i);
//        }
//        dfs(trie,folder,ans);
//        return ans;
//    }
//
//    private void dfs(Trie trie, String[] folder, List<String> ans) {
//        if(trie.ref != -1){
//            ans.add(folder[trie.ref]);
//            return;
//        }
//        for(var val: trie.children.values()){
//            dfs(val,folder,ans);
//        }
//    }
//
//    public List<String> removeSubfolders1(String[] folder) {
//        Arrays.sort(folder);
//        List<String> ans = new ArrayList<String>();
//        ans.add(folder[0]);
//        for (int i = 1; i < folder.length; ++i) {
//            int pre = ans.get(ans.size() - 1).length();
//            if (!(pre < folder[i].length() && ans.get(ans.size() - 1).equals(folder[i].substring(0, pre)) && folder[i].charAt(pre) == '/')) {
//                ans.add(folder[i]);
//            }
//        }
//        return ans;
//    }
//}
//
//class Trie {
//    int ref = -1; //末尾结点表示在数组中的位置，-1表示中间结点
//
//    Map<String, Trie> children;
//
//    public Trie() {
//        children = new HashMap<>();
//    }
//
//    /**
//     * 在字典树中插入一个字符串
//     *
//     * @param path 字符串
//     */
//    void insert(String path,int i) {
//        Trie cur = this;
//        String[] split = path.split("/");
//        for (String s : split) {
//            cur.children.putIfAbsent(s, new Trie());
//            cur = cur.children.get(s);
//        }
//        cur.ref= i;
//    }
//}

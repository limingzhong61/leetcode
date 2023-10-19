package com.lmz.leetcode.practice.p.p_0_1000;

import com.lmz.algorithm_learning.leetcode.TransformUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: limingzhong
 * @create: 2023-08-03 17:15
 */
public class RemoveComments722 {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<String>();
        StringBuilder newLine = new StringBuilder();
        boolean inBlock = false;
        for (String line : source) {
            for (int i = 0; i < line.length(); i++) {
                if (inBlock) {
                    if (i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                        inBlock = false;
                        i++;
                    }
                } else {
                    if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                        inBlock = true;
                        i++;
                    } else if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                        break;
                    } else {
                        newLine.append(line.charAt(i));
                    }
                }
            }
            if (!inBlock && newLine.length() > 0) {
                res.add(newLine.toString());
                newLine.setLength(0);
            }
        }
        return res;
    }

    public static void main(String[] args) {


        RemoveComments722 removeComments722 = new RemoveComments722();
        testCase(removeComments722, "[\"a//*b//*c\",\"blank\",\"d/*/e*//f\"]",
                "[\"a\",\"blank\",\"d/f\"]");
        testCase(removeComments722, "[\"/*Test program */\", \"int main()\", \"{ \", \"  // variable declaration \", \"int a, b, c;\", \"/* This is a test\", \"   multiline  \", \"   comment for \", \"   testing */\", \"a = b + c;\", \"}\"]", "[\"int main()\",\"{ \",\"  \",\"int a, b, c;\",\"a = b + c;\",\"}\"]");
        testCase(removeComments722, "[\"class test{\", \"public: \", \"   int x = 1;\", \"   /*double y = 1;*/\", \"   char c;\", \"};\"]", "[\"class test{\",\"public: \",\"   int x = 1;\",\"   \",\"   char c;\",\"};\"]");


    }

    private static void testCase(RemoveComments722 removeComments722, String original, String ans1) {
        List<String> res1 = removeComments722.removeComments(TransformUtil.toStringArray(
                original));
        System.out.println(ans1);
        System.out.println(TransformUtil.toString(res1));
        System.out.println(TransformUtil.toString(res1).equals(ans1));
    }
}

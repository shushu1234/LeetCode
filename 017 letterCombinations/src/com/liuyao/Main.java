package com.liuyao;

import java.util.LinkedList;
import java.util.List;
/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



 示例:

 输入："23"
 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 说明:
 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */

/**
 * @author liuyao
 * @date 2018/07/18
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(Solution.letterCombinations(""));
    }

    static class Solution {
        final static String[] letterMap={
                " ",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
        static List<String> res=new LinkedList<>();
        public static List<String> letterCombinations(String digits) {
            if (digits.equals("")){
                return res;
            }
            findCombination(digits,0,"");
            return res;
        }

//        s中保存了此时从digits[0...index-1]翻译得到的一个字母字符串
//        寻找和digits[index]匹配的字母，获得digits[0...index]翻译得到的解
        public static void findCombination(String digits,int index,String s){
            if (index==digits.length()){
                res.add(s);
                return ;
            }

            char c=digits.charAt(index);
            String letters=letterMap[c-'0'];
            for (int i = 0; i < letters.length(); i++) {
                findCombination(digits,index+1,s+letters.charAt(i));
            }
            return;
        }
    }
}

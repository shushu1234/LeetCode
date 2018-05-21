package com.liuyao;

import java.util.List;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

 说明：

 字母异位词指字母相同，但排列不同的字符串。
 不考虑答案输出的顺序。
 示例 1:

 输入:
 s: "cbaebabacd" p: "abc"

 输出:
 [0, 6]

 解释:
 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 示例 2:

 输入:
 s: "abab" p: "ab"

 输出:
 [0, 1, 2]

 解释:
 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(Solution.findAnagrams("cbaebabacd","abc"));
    }

    static class Solution {
        public static List<Integer> findAnagrams(String s, String p) {
            List<Integer> list=new ArrayList<>();
            if (null == s || s.length()==0 || null == p || p.length()==0){
                return list;
            }
            int hash[]=new int[256];
            for (char c : p.toCharArray()) {
                hash[c]++;
            }

            int left=0;
            int right=0;
            int count =p.length();
            while (right <s.length()){
//                判断此时新加入的右边的字母在hash表中是否还存在
                if (hash[s.charAt(right++)]-->=1){
                    count--;
                }
//                所有字符都在，添加到list中
                if (count==0){
                    list.add(left);
                }
//                判断当前的子串的长度是否跟p的长度相同，以及hash表中left的字母的加一，并将count也加一
                if (right-left==p.length() && hash[s.charAt(left++)]++ >=0){
                    count++;
                }
            }
            return list;
        }
    }
}

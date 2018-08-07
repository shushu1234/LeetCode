package com.liuyao;

import java.util.Arrays;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

 案例:

 s = "leetcode"
 返回 0.

 s = "loveleetcode",
 返回 2.


 注意事项：您可以假定该字符串只包含小写字母。
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        String str="loveleetcode";
        System.out.println(Solution.firstUniqChar(str));
    }

    static class Solution {
        public static int firstUniqChar(String s) {
            int[] arr=new int[26];
            Arrays.fill(arr,0);
            for (int i = 0; i < s.length(); i++) {
                arr[s.charAt(i)-'a']++;
            }
            for (int i = 0; i < s.length(); i++) {
                if (arr[s.charAt(i)-'a']==1){
                    return i;
                }
            }
            return -1;
        }
    }
}

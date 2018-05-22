package com.liuyao;

import java.util.HashMap;

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * <p>
 * 示例：
 * <p>
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * <p>
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * <p>
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 */

/**
 * 基本思想是，保留一个散列表，它将字符串中的字符存储为键，并将它们的位置存储为值，
 * 并保留定义最大子字符串的两个指针。移动右边的指针扫描字符串，
 * 同时更新散列表。如果该字符已经在散列表中，
 * 则将左指针移到最后找到的相同字符的右侧。请注意，这两个指针只能向前移动。
 */
public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println(Solution.lengthOfLongestSubstring2("abba"));
    }

    static class Solution {
        public static int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) {
                return 0;
            }
            int max = 0;
            HashMap<Character, Integer> map = new HashMap<>();
//            hi为右指针，lo为左指针，扫描字符串
            for (int hi = 0, lo = 0; hi < s.length(); hi++) {
//                检测当前子串的右边的字符是或否在map中已经存在，如果存在的话，将左指针指向当前找到的相同字符的右侧
                if (map.containsKey(s.charAt(hi))) {
//                    要取较大值，为了防止lo有回到之前的位置去，用dvdf，和abba可以测试出结果
                    lo = Math.max(lo, map.get(s.charAt(hi)) + 1);
//                    lo = map.get(s.charAt(hi)) + 1;
                }
                map.put(s.charAt(hi), hi);
                max = Math.max(max, hi - lo + 1);
            }
            return max;
        }

        public static int lengthOfLongestSubstring2(String s) {
            int n = s.length(), ans = 0;
            int[] index = new int[128];
            for (int j = 0, i = 0; j < n; j++) {
                i = Math.max(index[s.charAt(j)], i);
                ans = Math.max(ans, j - i + 1);
                index[s.charAt(j)] = j + 1;
            }
            return ans;
        }
    }
}

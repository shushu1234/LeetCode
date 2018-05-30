package com.liuyao;

import java.util.HashMap;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。

 示例 1:

 输入: s = "anagram", t = "nagaram"
 输出: true

 示例 2:
 输入: s = "rat", t = "car"
 输出: false
 说明:
 你可以假设字符串只包含小写字母。

 进阶:
 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(Solution.isAnagram("abav","baav"));
    }
    static class Solution {
        public static boolean isAnagram(String s, String t) {
            HashMap<Character,Integer> map=new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))){
                    int count=map.get(s.charAt(i));
                    map.put(s.charAt(i),++count);
                }else {
                    map.put(s.charAt(i),1);
                }
            }
            for (int i = 0; i < t.length(); i++) {
                if (map.containsKey(t.charAt(i))){
                    int count=map.get(t.charAt(i));
                    if (count>0){
                        map.put(t.charAt(i),--count);
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }
            }
            for (Character c:map.keySet()
                 ) {
                if (map.get(c)!=0){
                    return false;
                }
            }
            return true;
        }
        public boolean isAnagram2(String s, String t) {
            int []chars = new int[26];
            for(char c : s.toCharArray()){
                chars[c-'a']++;
            }
            for(char c: t.toCharArray()){
                chars[c-'a']--;
            }
            for(int i : chars){
                if( i != 0){
                    return false;
                }
            }
            return true;
        }
    }
}

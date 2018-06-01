package com.liuyao;

import java.util.HashMap;
/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。

 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。

 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。

 示例 1:

 输入: s = "egg", t = "add"
 输出: true
 示例 2:

 输入: s = "foo", t = "bar"
 输出: false
 示例 3:

 输入: s = "paper", t = "title"
 输出: true
 说明:
 你可以假设 s 和 t 具有相同的长度。
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(Solution.isIsomorphic2("ad","gg"));
    }
    static class Solution {
        public static boolean isIsomorphic(String s, String t) {
            char[] arr1=s.toCharArray();
            char[] arr2=t.toCharArray();
            HashMap<Character,Integer> map1=new HashMap<>();
            HashMap<Character,Integer> map2=new HashMap<>();
            if (arr1.length!=arr2.length){
                return false;
            }
            for (int i = 0; i < arr1.length; i++) {
                if (map1.containsKey(arr1[i])){
                    int count1=map1.get(arr1[i]);
                    if (map2.containsKey(arr2[i])){
                        int count2=map2.get(arr2[i]);
                        if (count1==count2){
                            continue;
                        }else {
                            return false;
                        }
                    }else {
                        return false;
                    }
                }else {
                    map1.put(arr1[i],i);
                    if (map2.containsKey(arr2[i])){
                        return false;
                    }else {
                        map2.put(arr2[i],i);
                        continue;
                    }
                }
            }
            return true;
        }

        public static boolean isIsomorphic2(String s, String t) {
            int[] arr1=new int[256];
            int[] arr2=new int[256];
            for (int i = 0; i < s.length(); i++) {
                char c1=s.charAt(i);
                char c2=t.charAt(i);
                if (arr1[c1]==0 && arr2[c2]==0){
                    arr1[c1]=i+1;
                    arr2[c2]=i+1;
                    continue;
                }else {
                    if (arr1[c1]==arr2[c2]){
                        continue;
                    }else {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}

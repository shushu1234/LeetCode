package com.liuyao;

import java.util.HashMap;
/**
 * 给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。

 这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。

 示例1:

 输入: pattern = "abba", str = "dog cat cat dog"
 输出: true
 示例 2:

 输入:pattern = "abba", str = "dog cat cat fish"
 输出: false
 示例 3:

 输入: pattern = "aaaa", str = "dog cat cat dog"
 输出: false
 示例 4:

 输入: pattern = "abba", str = "dog dog dog dog"
 输出: false
 说明:
 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。   
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(Solution.wordPattern("abba","dog dog dog dog"));
    }

   static class Solution {
        public static boolean wordPattern(String pattern, String str) {
            HashMap<Character,Integer> map1=new HashMap<>();
            HashMap<String,Integer> map2=new HashMap<>();
            char[] arr1=pattern.toCharArray();
            String[] arr2=str.split(" ");
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
    }
}

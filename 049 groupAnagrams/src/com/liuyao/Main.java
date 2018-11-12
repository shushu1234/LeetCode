package com.liuyao;

import java.util.*;
/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

 示例:

 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 输出:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 说明：

 所有输入均为小写字母。
 不考虑答案输出的顺序。
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] arr={"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(Solution.groupAnagrams(arr));

    }

    static class Solution {
        public static List<List<String>> groupAnagrams(String[] strs) {
            if (null == strs || strs.length==0)
                return new ArrayList<List<String>>();
            Map<String,List<String>> map=new HashMap<>();
            for (String s :
                    strs) {
                char[] ca=s.toCharArray();
                Arrays.sort(ca);
                String keyStr=String.valueOf(ca);
                if (!map.containsKey(keyStr)){
                    map.put(keyStr,new ArrayList<>());
                }
                map.get(keyStr).add(s);
            }
            return new ArrayList<>(map.values());
        }
    }
}

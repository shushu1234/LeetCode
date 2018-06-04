package com.liuyao;

import java.util.*;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。

 示例 1:

 输入:
 "tree"

 输出:
 "eert"

 解释:
 'e'出现两次，'r'和't'都只出现一次。
 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 示例 2:

 输入:
 "cccaaa"

 输出:
 "cccaaa"

 解释:
 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 示例 3:

 输入:
 "Aabb"

 输出:
 "bbAa"

 解释:
 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 注意'A'和'a'被认为是两种不同的字符。
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(Solution.frequencySort("tree"));
    }

    static class Solution {
        public static String frequencySort(String s) {
            Map<Character,Integer> map=new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i),map.get(s.charAt(i))+1);
                }else {
                    map.put(s.charAt(i),1);
                }
            }
            PriorityQueue<Map.Entry<Character,Integer>> priorityQueue=new PriorityQueue<>(
                    new Comparator<Map.Entry<Character, Integer>>() {
                @Override
                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                    return o2.getValue()-o1.getValue();
                }
            });
            priorityQueue.addAll(map.entrySet());
            StringBuffer stringBuffer=new StringBuffer();
            while (!priorityQueue.isEmpty()){
                Map.Entry entry=priorityQueue.poll();
                for (int i = 0; i < (Integer) entry.getValue(); i++) {
                    stringBuffer.append(entry.getKey());
                }
            }
            return stringBuffer.toString();
        }
        public String frequencySort2(String s) {
            int[] f = new int[256];
            char[] chars = s.toCharArray();
            char[] res = new char[s.length()];

            for (char c : chars)
                f[c]++;

            for (int i = 0; i < res.length; ) {
                int max = 0;
                int c = 0;

                for (int j = 0; j < f.length; j++) {
                    if (f[j] > max) {
                        max = f[j];
                        c = j;
                    }
                }

                f[c] = 0;
                while (max-- > 0)
                    res[i++] = (char)c;
            }

            return new String(res);
        }
    }
}

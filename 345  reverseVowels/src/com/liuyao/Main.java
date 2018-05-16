package com.liuyao;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。

 示例 1：
 给定 s = "hello", 返回 "holle".

 示例 2：
 给定 s = "leetcode", 返回 "leotcede".

 注意:
 元音字母不包括 "y".
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(Solution.reverseVowels("leetcode"));
    }
    static class Solution {
        public static String reverseVowels(String s) {
            char[] arr=s.toCharArray();
            int lo=0;
            int hi=s.length()-1;
            while (lo<hi){
                if (valid(arr[lo]) && valid(arr[hi])){
                    char c=arr[lo];
                    arr[lo]=arr[hi];
                    arr[hi]=c;
                    lo++;
                    hi--;
                }
                if (!valid(arr[lo])){
                   lo++;
                }
                if (!valid(arr[hi])){
                    hi--;
                }

            }
            return String.valueOf(arr);
        }

        private static boolean valid(char c){
            switch (c){
                case 'a':
                case 'A':
                case 'e':
                case 'E':
                case 'i':
                case 'I':
                case 'o':
                case 'O':
                case 'u':
                case 'U':
                    return true;
                    default:return false;
            }
        }
    }
}

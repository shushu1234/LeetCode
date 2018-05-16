package com.liuyao;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

 说明：本题中，我们将空字符串定义为有效的回文串。

 示例 1:

 输入: "A man, a plan, a canal: Panama"
 输出: true
 示例 2:

 输入: "race a car"
 输出: false
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        String s="0P";
        System.out.println(Solution.isPalindrome(s));
    }

    static class Solution {
        public static boolean isPalindrome(String s) {
            s=s.toLowerCase();
            int lo=0;
            int hi=s.length()-1;
            while (lo<hi){
                Character c1=s.charAt(lo);
                Character c2=s.charAt(hi);
                if (!Character.isLetterOrDigit(c1)){
                    lo++;
                }else if (!Character.isLetterOrDigit(c2)){
                    hi--;
                }else if (c1!=c2){
                    return false;
                }else {
                    lo++;
                    hi--;
                }
            }
            return true;
        }
    }
}

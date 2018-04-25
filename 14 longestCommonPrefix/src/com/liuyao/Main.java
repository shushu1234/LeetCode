package com.liuyao;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。

 如果不存在公共前缀，返回空字符串 ""。

 示例 1:

 输入: ["flower","flow","flight"]
 输出: "fl"
 示例 2:

 输入: ["dog","racecar","car"]
 输出: ""
 解释: 输入不存在公共前缀。
 说明:

 所有输入只包含小写字母 a-z
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] strings=new String[]{"a","aa"};
        System.out.println(Solution2.longestCommonPrefix(strings));
    }

    static  class Solution {
        public static String longestCommonPrefix(String[] strs) {
            if (strs.length==0){
                return "";
            }
            StringBuilder stringBuilder=new StringBuilder();
            boolean flag=true;
            for (int i = 0; i < strs[0].length(); i++) {
                stringBuilder.append(strs[0].charAt(i));
                for (int j = 1; j <strs.length; j++) {
                    if (strs[j].length()<=i ||strs[j].charAt(i)!=stringBuilder.charAt(i)){
                        flag=false;
                    }
                }
                if (!flag) break;
            }
            if (stringBuilder.length()>=1 && !flag)
                return stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
            else
                return stringBuilder.toString();
        }
    }

    static class Solution2 {
        public static String longestCommonPrefix(String[] strs) {
            if (null==strs || strs.length<1){
                return "";
            }
            if (strs.length==1){
                return strs[0];
            }
            String string=strs[0];
            int i=1;
            while (i<strs.length){

                while (strs[i].indexOf(string)!=0){  //巧妙之处
                    string=string.substring(0,string.length()-1);
                }
                i++;
            }
            return string;
        }
    }
}

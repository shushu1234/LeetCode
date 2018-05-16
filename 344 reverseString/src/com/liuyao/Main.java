package com.liuyao;

/**
 *
 请编写一个函数，其功能是将输入的字符串反转过来。

 示例：

 输入：s = "hello"
 返回："olleh"
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        String s="hello";
        System.out.println(Solution.reverseString(s));
    }

    static class Solution {
        public static String reverseString(String s) {
            if (s.length()==0){
                return "";
            }
            int lo=0;
            int hi=s.length()-1;
            char[] arr=s.toCharArray();
            while (lo<hi){
                char temp=arr[lo];
                arr[lo]=arr[hi];
                arr[hi]=temp;
                lo++;
                hi--;
            }
            return String.valueOf(arr);
        }
    }
}

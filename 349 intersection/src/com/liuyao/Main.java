package com.liuyao;

import java.util.HashSet;

/**
 *
 给定两个数组，写一个函数来计算它们的交集。

 例子:

 给定 num1= [1, 2, 2, 1], nums2 = [2, 2], 返回 [2].

 提示:

 每个在结果中的元素必定是唯一的。
 我们可以不考虑输出结果的顺序。
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
    }
    static class Solution {
        public static int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> set1=new HashSet<Integer>();
            for (int i :
                    nums1) {
                set1.add(i);
            }
            HashSet<Integer> set2=new HashSet<>();
            for (int i:nums2){
                if (set1.contains(i)){
                    set2.add(i);
                }
            }
            int[] arr=new int[set2.size()];
            int count=0;
            for (int i :
                    set2) {
                arr[count++]=i;
            }
            return arr;
        }
    }
}

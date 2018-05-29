package com.liuyao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定两个数组，写一个方法来计算它们的交集。

 例如:
 给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].

 注意：

 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 我们可以不考虑输出结果的顺序。
 跟进:

 如果给定的数组已经排好序呢？你将如何优化你的算法？
 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 如果nums2的元素存储在磁盘上，内存是有限的，你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] a={1,2,2,1};
        int[] b={2,2};
        System.out.println(Solution.intersect(a,b).toString());
    }

   static class Solution {
        public static int[] intersect(int[] nums1, int[] nums2) {
            HashMap<Integer,Integer> map=new HashMap<>();
            for (int i = 0; i < nums1.length; i++) {
                if (map.containsKey(nums1[i])){
                    int count=map.get(nums1[i]);
                    map.put(nums1[i],++count);
                }else {
                    map.put(nums1[i],1);
                }
            }
            ArrayList<Integer> list=new ArrayList<>();
            for (int i :
                    nums2) {
                if (map.containsKey(i)){
                    int num=map.get(i);
                    if (num > 0){
                        map.put(i,--num);
                        list.add(i);
                    }
                }
            }
            int a=0;
            int[] arr=new int[list.size()];
            for (int i :
                    list) {
                arr[a++]=i;
            }
            return arr;
        }
       public int[] intersect2(int[] nums1, int[] nums2) {
           Arrays.sort(nums1);
           Arrays.sort(nums2);

           int i = 0;
           int j = 0;
           int k = 0;

           int[] res = new int[Math.min(nums1.length, nums2.length)];
           while (i < nums1.length && j < nums2.length) {
               if (nums1[i] == nums2[j]) {
                   res[k] = nums1[i];
                   k++;
                   i++;
                   j++;
               } else if (nums1[i] < nums2[j]) {
                   i++;
               } else {
                   j++;
               }
           }
           return Arrays.copyOfRange(res, 0, k);

       }
    }
}

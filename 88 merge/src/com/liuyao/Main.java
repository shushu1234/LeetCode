package com.liuyao;

/**
 *
 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

 说明:

 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 示例:

 输入:
 nums1 = [1,2,3,0,0,0], m = 3
 nums2 = [2,5,6],       n = 3

 输出: [1,2,2,3,5,6]
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums1 = {4,5,6,0,0,0};
        int[] nums2={1,2,3};
        Solution.merge2(nums1,3,nums2,3);
    }
    static class Solution {
        public static void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] arr=new int[m+n];
            int k=0;
            int i=0;
            int j=0;
           while (i<m||j<n){
               if (i==m){
                   arr[k++]=nums2[j++];
                   continue;
               }
               if (j==n){
                   arr[k++]=nums1[i++];
                   continue;
               }
               if (nums1[i]<nums2[j]){
                   arr[k++]=nums1[i++];
               }else {
                   arr[k++]=nums2[j++];
               }
           }
            for (int l = 0; l < arr.length; l++) {
                nums1[l]=arr[l];
            }
        }

        public static void merge2(int[] nums1, int m, int[] nums2, int n){
            int k=n+m-1;
            int i=m-1;
            int j=n-1;
            while (i>-1||j>-1){
                if (i==-1){
                    nums1[k--]=nums2[j--];
                    continue;
                }
                if (j==-1){
                    nums1[k--]=nums1[i--];
                    continue;
                }
                if (nums1[i]>nums2[j]){
                    nums1[k--]=nums1[i--];
                }else {
                    nums1[k--]=nums2[j--];
                }
            }
        }
    }
}

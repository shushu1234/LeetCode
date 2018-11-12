package com.liuyao;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

 注意:
 不能使用代码库中的排序函数来解决这道题。

 示例:

 输入: [2,0,2,1,1,0]
 输出: [0,0,1,1,2,2]
 进阶：

 一个直观的解决方案是使用计数排序的两趟扫描算法。
 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */

public class Main {

    public static void main(String[] args) {
        int[] arr={2,0,2,1,1,0};
        Solution.sortColors3(arr);
	// write your code here
    }
    static class Solution {
        public static void sortColors(int[] nums) {
            int i0=0;
            int i1=0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]==0){
                    i0++;
                }else if (nums[i]==1){
                    i1++;
                }
            }
            for (int i=0;i<nums.length;i++){
                if (i<i0){
                    nums[i]=0;
                }else if (i <i1+i0){
                    nums[i]=1;
                }else {
                    nums[i]=2;
                }
            }
        }
        public static void sortColors2(int[] nums){
            int zero=-1;
            int two=nums.length;
            for (int i = 0; i < two; ) {
                if (nums[i]==1){
                    i++;
                }else if (nums[i]==2){
                    two--;
                    swap(nums,i,two);
                }else {
                    zero++;
                    swap(nums,zero,i);
                    i++;
                }

            }
        }

        public static void swap(int[] arr,int i,int j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }

//        三路快排
        public static void sortColors3(int[] nums){
            int lt=-1;
            int gt=nums.length;
            int i=lt+1;
            while (i<gt){
                if (nums[i]<1){
                    swap(nums,i,lt+1);
                    i++;
                    lt++;
                }else if (nums[i]>1){
                    swap(nums,i,gt-1);
                    gt--;
                }else {
                    i++;
                }
            }

        }
    }
}

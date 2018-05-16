package com.liuyao;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

 示例 1:

 输入: [3,2,1,5,6,4] 和 k = 2
 输出: 5
 示例 2:

 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 输出: 4
 说明:

 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度
 */

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] arr = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(Solution.findKthLargest(arr, 4));
    }

    static class Solution {
        public static int findKthLargest(int[] nums, int k) {
            k = nums.length - k;
            int lo = 0;
            int hi = nums.length - 1;
            while (lo < hi) {
                int j = partition(nums, lo, hi);
                if (j < k) {
                    lo = j + 1;
                } else if (j > k) {
                    hi = j - 1;
                } else {
                    break;
                }
            }
            return nums[k];
        }

        private static int partition(int[] nums, int lo, int hi) {
            int i = lo;
            int j = hi + 1;
            while (true) {
                while (i < hi && less(nums[++i], nums[lo])) ;
                while (j > lo && less(nums[lo], nums[--j])) ;
                if (i >= j) {
                    break;
                }
                exch(nums, i, j);
            }
            exch(nums, lo, j);
            return j;
        }

        private static boolean less(int num, int num1) {
            return num < num1;
        }

        private static void exch(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}

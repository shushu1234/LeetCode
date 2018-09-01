package com.liuyao;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。

 示例:

 输入: s = 7, nums = [2,3,1,2,4,3]
 输出: 2
 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 进阶:

 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */
public class Main {

    public static void main(String[] args) {
        int[] nums={1,1};
        System.out.println(Solution.minSubArrayLen(3,nums));
    }
   static class Solution {
        public static int minSubArrayLen(int s, int[] nums) {
            if (nums.length==0){
                return 0;
            }
            int left=0;
            int right=0;
            int temp = 0;
            int min=nums.length+1;
            while ( left<nums.length){
//                if (temp<nums[right]){
//                    temp+=nums[left];
//                    left++;
//                }
//                if (temp>=nums[right]){
//                    temp-=nums[right];
//                    right++;
//                }
//                if (temp==0 && (right-left)<min){
//                    min=right-left;
//                }
                if (temp>=s){
                    temp-=nums[left++];
                    if (right-left+1<min){
                        min=right-left+1;
                    }
                } else if (temp<s){
                    if (right==nums.length){
                        break;
                    }
                    temp+=nums[right++];
                }

            }

            return min==nums.length+1?0:min;
        }
    }
}

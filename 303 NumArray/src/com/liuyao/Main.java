package com.liuyao;

/**
 *
 给定一个数组，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。

 例如：

 给定nums = [-2, 0, 3, -5, 2, -1]，求和函数为sumRange()

 sumRange(0, 2) -> 1
 sumRange(2, 5) -> -1
 sumRange(0, 5) -> -3
 注意:

 你可以假设数组不可变。
 会多次调用 sumRange 方法
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    class NumArray {
        int[] nums;
        public NumArray(int[] nums) {
            for (int i = 1; i <nums.length ; i++) {
                nums[i]+=nums[i-1];
            }
            this.nums=nums;
        }

        public int sumRange(int i, int j) {
           if (i==0){
               return nums[j];
           }
           return nums[j]-nums[i-1];
        }
    }
}

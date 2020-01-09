package com.liuyao;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        new Main().rotate(arr, 3);
    }

    public void rotate(int[] nums, int k) {
        // 三步：
        // 1. 先整体旋转
        // 2. 再旋转前k个元素
        // 3. 再旋转后n-k个元素

        k %= nums.length;
        rotate(nums, 0, nums.length - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, nums.length - 1);
    }

    public void rotate(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

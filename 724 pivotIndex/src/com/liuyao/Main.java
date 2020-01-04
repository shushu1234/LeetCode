package com.liuyao;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        // write your code here
//        int[] arr={1, 7, 3, 6, 5, 6};
        int[] arr = {-1, -1, -1, 0, 1, 1};
        System.out.println(Solution.pivotIndex(arr));

    }

    static class Solution {
        public static int pivotIndex(int[] nums) {
            long total = Arrays.stream(nums).summaryStatistics().getSum();
            long leftTotal = 0;
            long rightTotal;
            for (int i = 0; i < nums.length; i++) {
                rightTotal = total - (leftTotal + nums[i]);
                if (leftTotal == rightTotal) {
                    return i;
                }
                leftTotal += nums[i];
            }
            return -1;
        }
    }
}

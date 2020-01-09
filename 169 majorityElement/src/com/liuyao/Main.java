package com.liuyao;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr={3,2,3,2,3,3};
        System.out.println(new Main().majorityElement(arr));
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[(nums.length-1)/2];
    }
}

package com.liuyao;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr={1,12,-5,-6,50,3};
        System.out.println(new Main().findMaxAverage(arr, 4));
    }

    public double findMaxAverage(int[] nums, int k) {
        int maxTotal = 0;
        int total;
        for (int i = 0; i < k; i++) {
            maxTotal += nums[i];
        }
        total = maxTotal;
        for (int i = k; i < nums.length; i++) {
            total -= nums[i - k];
            total += nums[i];
            maxTotal = total > maxTotal ? total : maxTotal;
        }
        return maxTotal * 1.0 / k;
    }
}

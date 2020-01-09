package com.liuyao;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr={0,1,1,0,0,1,1,1,0};
        System.out.println(new Main().findMaxConsecutiveOnes(arr));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==1){
                ++count;
            }else {
                max = (count>max)?count:max;
                count=0;
            }
        }
        return (count>max)?count:max;
    }
}

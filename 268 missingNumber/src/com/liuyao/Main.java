package com.liuyao;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr={9,6,4,2,3,5,7,0,1};
        System.out.println(new Main().missingNumber(arr));
    }

    public int missingNumber1(int[] nums) {
        int[] arr=new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]=1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==0){
                return i;
            }
        }
        return 0;
    }

    public int missingNumber(int[] nums) {
        int res=nums.length;
        for (int i = 0; i < nums.length; i++) {
            res=res^(i^nums[i]);
        }
        return res;
    }
}

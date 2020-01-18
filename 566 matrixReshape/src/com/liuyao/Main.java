package com.liuyao;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] arr={{1,2},{3,4}};
        System.out.println(new Main().matrixReshape(arr, 2, 4));
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] arr=new int[r][c];
        int a=nums.length;
        int b=nums[0].length;
        if (a*b==r*c){
            int[] array = Arrays.stream(nums).flatMapToInt(x -> Arrays.stream(x)).toArray();
            int count=0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    arr[i][j]=array[count++];
                }
            }
            return arr;
        }else {
            return nums;
        }
    }
}

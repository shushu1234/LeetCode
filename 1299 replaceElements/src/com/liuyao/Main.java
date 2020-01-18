package com.liuyao;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr={17,18,5,4,6,1};
        System.out.println(Arrays.toString(new Main().replaceElements(arr)));
    }

    public int[] replaceElements(int[] arr) {
        int max=arr[arr.length-1];
        arr[arr.length-1]=-1;
        for (int i = arr.length-2; i >=0 ; i--) {
            int temp=arr[i];
            arr[i]=max;
            max = temp>max?temp:max;
        }
        return arr;
    }
}

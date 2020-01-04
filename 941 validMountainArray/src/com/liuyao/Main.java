package com.liuyao;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] arr = {0,3,2,1};
        System.out.println(new Main().validMountainArray(arr));
    }

    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int tempPos = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                tempPos = i-1;
                break;
            }
        }
        for (int i = A.length - 1; i > tempPos; i--) {
            if (A[i] >= A[i - 1]) {
                return false;
            }
        }
        return tempPos==0?false:true;
    }
}

package com.liuyao;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(Arrays.toString(new Main().sumZero(2)));
    }
    public int[] sumZero(int n) {
        int start = -1 * n / 2;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (n % 2 == 0 && start == 0) {
                start++;
            }
            arr[i] = start++;
        }
        return arr;
    }
}

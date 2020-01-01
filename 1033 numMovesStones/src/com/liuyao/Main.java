package com.liuyao;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        for (int i : Solution.numMovesStones(1, 2, 5)) {
            System.out.println(i);
        }
    }

   static class Solution {
        public static int[] numMovesStones(int a, int b, int c) {
            int[] res = new int[2];
            int[] arr = {a, b, c};
            Arrays.sort(arr);

            if(arr[1]!=arr[0]+1 || arr[2]!=arr[1]+1) {
                //只要不是（1，2，5）（1，3，5）这种可以一步就移到的，像（1，4，7）两边都需要往中间移一下就需要2步
                if(arr[1]==arr[0]+1 || arr[1]==arr[0]+2 || arr[2]==arr[1]+1 || arr[2]==arr[1]+2) {
                    res[0] = 1;
                } else {
                    res[0] = 2;
                }
            }
            res[1] = arr[2]-arr[0]-2 ;
            return res;

        }
    }
}

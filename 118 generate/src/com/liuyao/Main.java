package com.liuyao;
import java.util.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution solution = new Solution();
        solution.generate(10).forEach(System.out::println);
    }

    static class Solution {
        public static List<List<Integer>> generate(int numRows) {
            int[][] arr=new int[numRows][numRows];
            if (numRows == 1){
                return Arrays.asList(Arrays.asList(1));
            }
            if (numRows == 2){
                return Arrays.asList(Arrays.asList(1),Arrays.asList(1,1));
            }
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numRows; j++) {
                    if (j == 0 ){
                        arr[i][j]=1;
                    }else if (i == j){
                        arr[i][j]=1;
                    }else {
                        arr [i] [j] = 0;
                    }
                }
            }

            for (int i = 2; i < numRows; i++) {
                for (int j = 1; j < i; j++) {
                    if (arr [i] [j] ==0){
                        arr [i] [j] = arr [i-1][j-1]+arr [i-1][j];
                    }
                }
            }

//            for (int i = 0; i < numRows; i++) {
//                for (int j = 0; j < numRows; j++) {
//                    System.out.print(arr[i][j]+"\t");
//                }
//                System.out.println();
//            }
            List < List<Integer>> res=new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                List<Integer> temp=new LinkedList<>();
                for (int j = 0; j <= i; j++) {
                    temp.add(arr[i][j]);
                }
                res.add(temp);
            }
            return res;
        }
    }
}

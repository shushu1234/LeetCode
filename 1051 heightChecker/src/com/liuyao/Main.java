package com.liuyao;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr={1,1,4,2,1,3};
        System.out.println(new Main().heightChecker(arr));
    }

    public int heightChecker(int[] heights) {
        int[] arr=new int[100];
        for (int i : heights) {
            arr[i]++;
        }

        int total=0;
        for (int i = 1,j=0;j < heights.length; i++) {

            while (arr[i]-->0){
                if (heights[j++]!=i){
                    total++;
                }
            }
        }
        return total;
    }
}

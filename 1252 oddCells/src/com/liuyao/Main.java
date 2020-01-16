package com.liuyao;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] arr={{1,1},{0,0}};
        System.out.println(new Main().oddCells(2, 2, arr));
    }

    public int oddCells(int n, int m, int[][] indices) {
        int[] x=new int[n];
        int[] y=new int[m];
        int total=0;
        for (int i = 0; i < indices.length; i++) {
            x[indices[i][0]]++;
            y[indices[i][1]]++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if( (x[i]+y[j])%2 !=0){
                    total++;
                }
            }
        }
        return total;
    }
}

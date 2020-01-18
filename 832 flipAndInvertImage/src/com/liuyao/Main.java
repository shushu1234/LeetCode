package com.liuyao;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] arr={{1,1,0,0},{0,1,1,1},{0,0,0,1}};
        Arrays.asList(new Main().flipAndInvertImage(arr)).stream().flatMapToInt(x->Arrays.stream(x)).forEach(System.out::print);

    }

    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int x=0;
            int y=A[i].length-1;
            while (x<y){
                int temp=A[i][x];
                A[i][x]=A[i][y];
                A[i][y]=temp;
                x++;
                y--;
            }
            for (int j = 0; j < A[i].length; j++) {
                A[i][j]=(A[i][j]==1?0:1);
            }
        }
        return A;
    }
}

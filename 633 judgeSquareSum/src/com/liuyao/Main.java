package com.liuyao;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println(new Main().judgeSquareSum(2147483646));
    }

    public boolean judgeSquareSum(int c) {
        for (int i = 0; i *i <= c; i++) {
            double j = Math.sqrt(c - i * i);
            if (j == (int) j) {
                return true;
            }
        }
        return false;
    }
}

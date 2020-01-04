package com.liuyao;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] arr = new int[]{701, 702, 780, 704};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Solution.convertToTitle(arr[i]));
        }
    }

    static class Solution {
        public static String convertToTitle(int n) {
            StringBuilder str = new StringBuilder();
            while (n > 0) {
                int c = n % 26;
                if (c == 0) {
                    //由于如果能整除的话，按照26进制的话，应该是A0，为了映射成AZ，相当于进制转换后的数少了1，
                    //所以插入Z之后要原来的数要减一
                    str.insert(0, (char) (25 + 'A'));
                    --n;
                } else {
                    str.insert(0, (char) (c - 1 + 'A'));

                }
                n /= 26;
            }
            return str.toString();
        }
    }
}

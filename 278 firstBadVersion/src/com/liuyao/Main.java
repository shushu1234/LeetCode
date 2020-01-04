package com.liuyao;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println(firstBadVersion(5));
    }

    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int middle = left + ( right - left) /2 ;
            if (isBadVersion(middle)){
                right=middle;
            }else {
                left = middle+1;
            }
        }
        return left;
    }

    public static boolean isBadVersion(int n) {
        if (n > 3 )
            return true;
        else
            return false;
    }
}

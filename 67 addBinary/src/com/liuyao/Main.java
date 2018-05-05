package com.liuyao;

import java.math.BigInteger;

/**
 * Given two binary strings, return their sum (also a binary string).

 The input strings are both non-empty and contains only characters 1 or 0.

 Example 1:

 Input: a = "11", b = "1"
 Output: "100"
 Example 2:

 Input: a = "1010", b = "1011"
 Output: "10101"
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    static class Solution {
        public static String addBinary(String a, String b) {
            BigInteger decimal_a=new BigInteger(a,2);
            BigInteger decimal_b=new BigInteger(b,2);
            BigInteger sum =decimal_a.add(decimal_b);
            String temp=sum.toString(2);
            return temp;
        }
    }
}

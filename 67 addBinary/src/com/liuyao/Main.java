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
        public String addBinary2(String a, String b) {
            StringBuilder sb = new StringBuilder();
            int i = a.length() - 1, j = b.length() -1, carry = 0;
            while (i >= 0 || j >= 0) {
                /**
                 * 一共四种情况 0+0+0=0   sb+0 carry=0
                 *             1+0+0=1   sb+1 carry=0
                 *             1+1+0=2   sb+0 carry=1
                 *             1+1+1=3   sb+1 carry=1
                 */
                int sum = carry;
                if (j >= 0) sum += b.charAt(j--) - '0';
                if (i >= 0) sum += a.charAt(i--) - '0';

                sb.append(sum % 2);
                carry = sum / 2;
            }
            if (carry != 0) sb.append(carry);
            return sb.reverse().toString();
        }
    }
}

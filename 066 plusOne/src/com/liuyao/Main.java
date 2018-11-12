package com.liuyao;

import java.math.BigInteger;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums={1,2,3};
        System.out.println(Solution.plusOne(nums).toString());
    }

   static class Solution {
        public static int[] plusOne(int[] digits) {
            for (int i = digits.length-1; i >=0 ; i--) {
                if (digits[i]<9){
                    digits[i]++;
                    return digits;
                }else {
                    digits[i]=0;
                }
            }

            int[] new_digits=new int[digits.length+1];
            new_digits[0]=1;
            return new_digits;
        }
    }
}

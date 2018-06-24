package com.liuyao;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
    static class Solution {
        public static boolean containsDuplicate(int[] nums) {
            Set<Integer> set=new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (!set.add(nums[i])){
                    return true;
                }
            }
            return false;
        }
    }
}

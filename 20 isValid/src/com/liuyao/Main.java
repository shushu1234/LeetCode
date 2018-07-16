package com.liuyao;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public static class Solution {
        public static boolean isValid(String s) {
            Stack<Integer> p = new Stack<>();
            for(int i = 0; i < s.length(); i++) {
                int q = "(){}[]".indexOf(s.substring(i, i + 1));
                if(q % 2 == 1) {
                    if(p.isEmpty() || p.pop() != q - 1) return false;
                } else p.push(q);
            }
            return p.isEmpty();
        }
    }
}

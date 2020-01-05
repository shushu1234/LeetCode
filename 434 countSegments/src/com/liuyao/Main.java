package com.liuyao;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(new Main().countSegments(null));
    }

    public int countSegments(String s) {
        // 注意连续空格，字符串开头是空格
        return (s == null ||s.trim().equals("")) ? 0 : s.trim().split("\\s+").length;
    }
}

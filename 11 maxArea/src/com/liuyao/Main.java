package com.liuyao;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。画 n 条垂直线，使得垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

 注意：你不能倾斜容器，n 至少是2。
 */
public class Main {

    public static void main(String[] args) {
        // write your code here
    }

    static class Solution {
        public static int maxArea(int[] height) {
            int max = 0;
            int area = 0;
            int i = 0, j = height.length - 1;
            while(i<j){
                if(height[i]<height[j]){
                    area = (j-i)*height[i];
                    i++;
                }else{
                    area = (j-i)*height[j];
                    j--;
                }
                if(area > max){
                    max=area;
                }
            }
            return max;
        }

    }
}

package com.liuyao;

/**
 * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[0,1,0]
 * 输出：1
 * 示例 2：
 *
 * 输入：[0,2,1,0]
 * 输出：1
 *
 *
 * 提示：
 *
 * 3 <= A.length <= 10000
 * 0 <= A[i] <= 10^6
 * A 是如上定义的山脉
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr={0,1,0};
        System.out.println(Solution.peakIndexInMountainArray(arr));
    }

    static class Solution {
        public static int peakIndexInMountainArray(int[] A) {
            int posa = 0;
            int posb = 0;
            for (int i = 0; i < A.length-1; i++) {
                if (A[i]>A[i+1]){
                    posa=i;
                    break;
                }
            }
            for (int i = A.length-1; i > 0; i--) {
                if (A[i]>A[i-1]){
                    posb=i;
                    break;
                }
            }
            if (posa==posb){
                return posa;
            }else {
                return 0;
            }
        }
    }
}

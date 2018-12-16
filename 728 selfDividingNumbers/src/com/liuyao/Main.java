package com.liuyao;

import java.util.LinkedList;
import java.util.List;

/**
 * 自除数 是指可以被它包含的每一位数除尽的数。
 *
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 *
 * 还有，自除数不允许包含 0 。
 *
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 *
 * 示例 1：
 *
 * 输入：
 * 上边界left = 1, 下边界right = 22
 * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * 注意：
 *
 * 每个输入参数的边界满足 1 <= left <= right <= 10000。
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(Solution.selfDividingNumbers(1,22));
    }
    static class Solution {
        public static List<Integer> selfDividingNumbers(int left, int right) {
            LinkedList<Integer> res=new LinkedList<Integer>();
            for (int i = left; i <=right ; i++) {
                int temp=i;
                if (i<9){
                    res.addLast(i);
                }
                else {
                    boolean flag=true;
                    while (temp > 0){
                        int a=temp%10;
                        if (a==0||i%a!=0){
                            flag=false;
                            break;
                        }else {
                            temp /= 10;
                        }
                    }
                    if (flag){
                        res.addLast(i);
                    }
                }
            }
            return res;
        }
    }
}

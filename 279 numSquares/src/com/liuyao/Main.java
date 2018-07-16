package com.liuyao;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

 示例 1:

 输入: n = 12
 输出: 3
 解释: 12 = 4 + 4 + 4.
 示例 2:

 输入: n = 13
 输出: 2
 解释: 13 = 4 + 9.

 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(Solution.numSquares(13));
    }

    static class Solution {
        public static int numSquares(int n) {
            //利用队列进行广度优先遍历
            Queue<LinkedList<Integer>> queue=new LinkedList<>();
//            设置数组避免对重复的再次遍历
            boolean[] arr=new boolean[n+1];
            LinkedList<Integer> list=new LinkedList<>();
            arr[n]=true;
            list.add(n);
            list.add(0);
            queue.add(list);
            while (!queue.isEmpty()){
                int num=queue.peek().get(0);
                int step=queue.peek().get(1);
                queue.poll();
//                if (num==0){
//                    return step;
//                }
                for (int i = 1;  ; i++) {
                    int a=num-i*i;
                    if (a<0)
                        break;
                    if (a==0) //当a=0的时候表示找到了一条路径
                        return step+1;
                   if (!arr[a]){
                       LinkedList<Integer> list1=new LinkedList<>();
                       list1.add(a);
                       list1.add(step+1);
                       arr[a]=true;
                       queue.add(list1);
                   }
                }
            }
            return 0;
        }
    }
}

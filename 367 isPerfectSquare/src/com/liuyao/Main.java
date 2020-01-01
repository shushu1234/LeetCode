package com.liuyao;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(Solution.isPerfectSquare(99));
    }

   static class Solution {
        public static boolean isPerfectSquare1(int num) {
            //大于0的完全平方数由 1+3+5+7...的奇数和组成
            for (int i = 1; num > 0; i+= 2) {
                if ((num -= i) == 0){
                    return true;
                }
            }
            return num == 0;
        }
       public static boolean isPerfectSquare(int num) {
           //可以使用折半查找的方式来降低复杂度
           long left = 1;
           long right = num;

           while (left <= right){
               //注意右移的时候可能会出现数字越界，得使用long
               long middle = (left+right) >> 1;
               long res = (long) Math.pow(middle,2);
               if ( res == num ){
                   return true;
               }
               if (res > num){
                   right = middle-1;
               }else {
                   left = middle+1;
               }
           }
           return num == 0;
       }
    }
}

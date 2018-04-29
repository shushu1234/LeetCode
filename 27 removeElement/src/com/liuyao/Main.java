package com.liuyao;


public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] arr = {3};
        System.out.println(Solution.removeElement(arr, 3));
    }

    static class Solution {
        public static int removeElement(int[] nums, int val) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int last = nums.length;
            for (int i = 0; i < last; i++) {
                if (nums[i] == val) {
                    while (last>i){
                        if (nums[--last]!=val){
                            nums[i]=nums[last];
                            break;
                        }
                    }
                }
            }
            return last;

//            if (nums==null || nums.length==0){
//                return 0;
//            }
//            LinkedList<Integer> list=new LinkedList<>();
//            for (int i = 0; i < nums.length; i++) {
//                if (nums[i]!=val){
//                    list.add(nums[i]);
//                }
//            }
//            int size=list.size();
//            for (int i = 0; i < size; i++) {
//                nums[i]=list.removeFirst();
//            }
//            return size;

        }
    }
}

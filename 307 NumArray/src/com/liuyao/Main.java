package com.liuyao;

/**
 *
 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。

 update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。

 示例:

 Given nums = [1, 3, 5]

 sumRange(0, 2) -> 9
 update(1, 2)
 sumRange(0, 2) -> 8
 说明:

 数组仅可以在 update 函数下进行修改。
 你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
    }
    private SegmentTree<Integer> segmentTree;

    class NumArray {

        public NumArray(int[] nums) {
            if (nums.length>0){
                Integer[] data=new Integer[nums.length];
                for (int i = 0; i < nums.length; i++) {
                    data[i]=nums[i];
                }
                segmentTree=new SegmentTree<>(data,(a,b)->a+b);
            }
        }

        public void update(int i, int val) {
            segmentTree.set(i,val);
        }

        public int sumRange(int i, int j) {
            return segmentTree.query(i,j);
        }
    }

    class NumArray2 {

        private int[] nums;
        private int length;
        private int[] tree;

        public NumArray2(int[] nums) {
            this.nums = nums;
            length = nums.length;
            tree = new int[length * 2];
            for(int i = length; i < 2 * length; i++)
                tree[i] = nums[i - length];
            for(int i = length - 1; i > 0; i--){
                tree[i] = tree[2 * i] + tree[2*i+1];
            }
        }

        public void update(int i, int val) {
            i = i + length;
            tree[i] = val;
            i = i / 2;
            while(i > 0){
                tree[i] = tree[2*i] + tree[2*i+1];
                i = i / 2;
            }
        }

        public int sumRange(int i, int j) {
            int result = 0;
            i = i + length;
            j = j + length;
            while(i <= j){
                if(i % 2 == 1){
                    result += tree[i];
                    i++;
                }
                if(j % 2 == 0){
                    result += tree[j];
                    j--;
                }
                i /= 2;
                j /= 2;
            }
            return result;
        }
    }

}

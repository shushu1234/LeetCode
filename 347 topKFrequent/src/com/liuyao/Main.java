package com.liuyao;
/**
 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

 例如，

 给定数组 [1,1,1,2,2,3] , 和 k = 2，返回 [1,2]。

 注意：

 你可以假设给定的 k 总是合理的，1 ≤ k ≤ 数组中不相同的元素的个数。
 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr={1,1,1,2,2,3};
        System.out.println(Solution.topKFrequent(arr,2));
    }
    static class Solution {
        public static List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer,Integer> map=new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])){
                    map.put(nums[i],map.get(nums[i])+1);
                }else {
                    map.put(nums[i],1);
                }
            }
            PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o2.getValue()-o1.getValue();
                }
            });
            pq.addAll(map.entrySet());
            List<Integer> list=new LinkedList<>();
            for (int i = 0; i < k; i++) {
                list.add(pq.poll().getKey());
            }
            return list;
        }
    }
}

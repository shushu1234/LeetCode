package com.liuyao;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。

 注意:

 可以认为区间的终点总是大于它的起点。
 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 示例 1:

 输入: [ [1,2], [2,3], [3,4], [1,3] ]

 输出: 1

 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 示例 2:

 输入: [ [1,2], [1,2], [1,2] ]

 输出: 2

 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 示例 3:

 输入: [ [1,2], [2,3] ]

 输出: 0

 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        Interval interval=new Interval(1,2);
        Interval interval1=new Interval(2,3);
        Solution solution=new Solution();
        Interval[] arr={interval,interval1};
        System.out.println(solution.eraseOverlapIntervals(arr));
    }

      public static class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
      }
    static class Solution {
        public int eraseOverlapIntervals(Interval[] intervals) {
            if (intervals.length==0 || intervals.length==1){
                return 0;
            }
            Arrays.sort(intervals,new Cmp());
            int[] meno= new int[intervals.length + 1];
            Arrays.fill(meno,1);
            for (int i = 1; i < intervals.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (intervals[i].start>=intervals[j].end){
                        meno[i]=Math.max(meno[i],1+meno[j]);
                    }
                }
            }
            int res=0;
            for (int i = 0; i < meno.length; i++) {
                res=Math.max(res,meno[i]);
            }
            return intervals.length-res;
        }

        class Cmp implements Comparator<Interval>{

            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start){
                    return o1.start - o2.start;
                }else {
                    return o1.end - o2.end;
                }
            }
        }
    }

    static class Solution2 {
        public int eraseOverlapIntervals(Interval[] intervals) {
            if (intervals.length==0 || intervals.length==1){
                return 0;
            }
            Arrays.sort(intervals,new Cmp());
            int res=1;
            int pre=0;
            for (int i = 1; i < intervals.length; i++) {
//                如果当前的开始比之前的结束还有大，则可以加入
                if (intervals[i].start>=intervals[pre].end){
                    pre=i;
                    res++;
                }
            }
            return intervals.length-res;
        }

        class Cmp implements Comparator<Interval>{

            @Override
            public int compare(Interval o1, Interval o2) {
//                贪心思想，我们让先结束的在前面
                if (o1.end != o2.end){
                    return o1.end - o2.end;
                }else {
//                    否者让先开始的在最前面
                    return o1.start - o2.start;
                }
            }
        }
    }
}

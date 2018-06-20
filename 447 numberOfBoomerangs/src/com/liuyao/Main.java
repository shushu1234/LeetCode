package com.liuyao;

import java.util.HashMap;
/**
 *
 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。

 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。

 示例:

 输入:
 [[0,0],[1,0],[2,0]]

 输出:
 2

 解释:
 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] nums={{0,0},{1,0},{2,0}};
        System.out.println(Solution.numberOfBoomerangs(nums));
    }

    static class Solution {
        public static int numberOfBoomerangs(int[][] points) {
            int res=0;
            for (int i = 0; i < points.length; i++) {
                HashMap<Long,Integer> map=new HashMap<>();
                for (int j = 0; j < points.length; j++) {
                    if (i!=j){
                        long dis=getDistance(points[i],points[j]);
                        if (map.containsKey(dis)){
                            int count=map.get(dis);
                            map.put(dis,++count);
                        }else {
                            map.put(dis,1);
                        }
                    }
                }
                for (Integer v:map.values()) {
                    if (v>=2){
                        res+=(v*(v-1));
                    }
                }
            }
            return res;
        }

        private static long getDistance(int[] point, int[] point1) {
            return (point[0]-point1[0])*(point[0]-point1[0])+
                    (point[1]-point1[1])*(point[1]-point1[1]);
        }
    }
}

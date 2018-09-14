import java.util.LinkedList;
import java.util.List;

/**
 * @author liuyao
 * @date 2018/09/14
 */

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
public class Main {
    public static void main(String[] args) {
        List<List<Integer>> lists = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(2);
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(3);
        list1.add(4);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(6);
        list2.add(5);
        list2.add(7);
        LinkedList<Integer> list3 = new LinkedList<>();
        list3.add(4);
        list3.add(1);
        list3.add(8);
        list3.add(3);
        lists.add(list);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        System.out.println(new Solution().minimumTotal(lists));
    }

    static class Solution {
        //        动态规划
        public int minimumTotal(List<List<Integer>> triangle) {
            int layer = triangle.size();
            for (int i = layer - 2; i >= 0; i--) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    triangle.get(i).set(j, Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + triangle.get(i).get(j));
                }
            }
            return triangle.get(0).get(0);
        }

        public int minimumTotal2(List<List<Integer>> triangle) {
            if (triangle.size() == 0) {
                return 0;
            }
            Integer[][] visited = new Integer[triangle.size()][triangle.get(triangle.size() - 1).size()];
            return dfs(triangle, 0, 0, visited);
        }

        private int dfs(List<List<Integer>> triangle, int i, int j, Integer[][] visited) {
            if (i == triangle.size()) {
                return 0;
            }
            if (visited[i][j] != null) {
                return visited[i][j];
            }
            int sum = triangle.get(i).get(j) + Math.min(dfs(triangle, i + 1, j, visited), dfs(triangle, i + 1, j + 1, visited));
            visited[i][j] = sum;
            return sum;
        }
    }
}
